import os
import base64
import hashlib
from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from dataclasses import dataclass
from typing import Dict, List, Optional, Union
import json
import time
import uuid

# ================ User Management ================

@dataclass
class User:
    user_id: str
    username: str
    password_hash: str  # Storing only hash
    salt: str
    role: str
    created_at: int
    last_login: int
    mfa_enabled: bool = False
    mfa_secret: Optional[str] = None

class UserManager:
    def __init__(self, user_db_path: str = "users.json"):
        self.user_db_path = user_db_path
        self.users: Dict[str, User] = {}
        self._load_users()

    def _load_users(self):
        if os.path.exists(self.user_db_path):
            with open(self.user_db_path, 'r') as f:
                user_data = json.load(f)
                for user_id, data in user_data.items():
                    self.users[user_id] = User(**data)

    def _save_users(self):
        with open(self.user_db_path, 'w') as f:
            user_dict = {uid: user.__dict__ for uid, user in self.users.items()}
            json.dump(user_dict, f, indent=2)

    def create_user(self, username: str, password: str, role: str = "user") -> User:
        # Check if user exists
        if any(u.username == username for u in self.users.values()):
            raise ValueError(f"User {username} already exists")

        # Generate salt and hash password
        salt = os.urandom(16)
        salt_b64 = base64.b64encode(salt).decode('utf-8')
        password_hash = self._hash_password(password, salt)

        # Create user
        user_id = str(uuid.uuid4())
        new_user = User(
            user_id=user_id,
            username=username,
            password_hash=password_hash,
            salt=salt_b64,
            role=role,
            created_at=int(time.time()),
            last_login=0
        )

        self.users[user_id] = new_user
        self._save_users()
        return new_user

    def _hash_password(self, password: str, salt: bytes) -> str:
        kdf = PBKDF2HMAC(
            algorithm=hashes.SHA256(),
            length=32,
            salt=salt,
            iterations=100000,
        )
        key = kdf.derive(password.encode('utf-8'))
        return base64.b64encode(key).decode('utf-8')

    def authenticate(self, username: str, password: str) -> Optional[User]:
        for user in self.users.values():
            if user.username == username:
                salt = base64.b64decode(user.salt)
                password_hash = self._hash_password(password, salt)
                if password_hash == user.password_hash:
                    # Update last login time
                    user.last_login = int(time.time())
                    self._save_users()
                    return user
        return None

# ================ File Encryption ================

class FileEncryptor:
    def __init__(self, key_dir: str = ".keys"):
        self.key_dir = key_dir
        os.makedirs(key_dir, exist_ok=True)

    def generate_file_key(self) -> str:
        """Generate a unique key for file encryption"""
        key = Fernet.generate_key()
        key_id = str(uuid.uuid4())

        # Store the key
        with open(os.path.join(self.key_dir, f"{key_id}.key"), 'wb') as f:
            f.write(key)

        return key_id

    def get_file_key(self, key_id: str) -> bytes:
        """Retrieve a file key by ID"""
        key_path = os.path.join(self.key_dir, f"{key_id}.key")
        if not os.path.exists(key_path):
            raise ValueError(f"Key {key_id} not found")

        with open(key_path, 'rb') as f:
            return f.read()

    def encrypt_file(self, file_path: str, output_path: Optional[str] = None) -> str:
        """Encrypt a file and return the key ID"""
        if output_path is None:
            output_path = f"{file_path}.enc"

        # Generate a key
        key_id = self.generate_file_key()
        key = self.get_file_key(key_id)

        # Encrypt the file
        fernet = Fernet(key)
        with open(file_path, 'rb') as f:
            data = f.read()

        encrypted_data = fernet.encrypt(data)

        with open(output_path, 'wb') as f:
            f.write(encrypted_data)

        return key_id

    def decrypt_file(self, file_path: str, key_id: str, output_path: Optional[str] = None) -> str:
        """Decrypt a file using its key ID"""
        if output_path is None:
            if file_path.endswith('.enc'):
                output_path = file_path[:-4]
            else:
                output_path = f"{file_path}.dec"

        # Get the key
        key = self.get_file_key(key_id)

        # Decrypt the file
        fernet = Fernet(key)
        with open(file_path, 'rb') as f:
            encrypted_data = f.read()

        decrypted_data = fernet.decrypt(encrypted_data)

        with open(output_path, 'wb') as f:
            f.write(decrypted_data)

        return output_path

# ================ File Manager ================

@dataclass
class FileMetadata:
    file_id: str
    filename: str
    original_filename: str
    size: int
    content_type: str
    owner_id: str
    key_id: str  # Reference to encryption key
    created_at: int
    modified_at: int
    checksum: str
    version: int = 1
    parent_folder_id: Optional[str] = None

class Permission:
    READ = "read"
    WRITE = "write"
    DELETE = "delete"
    SHARE = "share"
    OWNER = "owner"

@dataclass
class FilePermission:
    file_id: str
    user_id: str
    permission_type: str  # read, write, delete, share, owner
    granted_by: str
    granted_at: int
    expires_at: Optional[int] = None

class SecureFileManager:
    def __init__(self,
                 storage_path: str = "storage",
                 metadata_path: str = "metadata.json",
                 permissions_path: str = "permissions.json"):
        self.storage_path = storage_path
        self.metadata_path = metadata_path
        self.permissions_path = permissions_path

        # Ensure storage directory exists
        os.makedirs(storage_path, exist_ok=True)

        # Initialize components
        self.encryptor = FileEncryptor()
        self.user_manager = UserManager()

        # Load metadata and permissions
        self.files: Dict[str, FileMetadata] = {}
        self.permissions: Dict[str, List[FilePermission]] = {}
        self._load_metadata()
        self._load_permissions()

    def _load_metadata(self):
        if os.path.exists(self.metadata_path):
            with open(self.metadata_path, 'r') as f:
                file_data = json.load(f)
                for file_id, data in file_data.items():
                    self.files[file_id] = FileMetadata(**data)

    def _save_metadata(self):
        with open(self.metadata_path, 'w') as f:
            file_dict = {fid: file.__dict__ for fid, file in self.files.items()}
            json.dump(file_dict, f, indent=2)

    def _load_permissions(self):
        if os.path.exists(self.permissions_path):
            with open(self.permissions_path, 'r') as f:
                perm_data = json.load(f)
                for file_id, perms in perm_data.items():
                    self.permissions[file_id] = [FilePermission(**p) for p in perms]

    def _save_permissions(self):
        with open(self.permissions_path, 'w') as f:
            perm_dict = {fid: [p.__dict__ for p in perms] for fid, perms in self.permissions.items()}
            json.dump(perm_dict, f, indent=2)

    def _compute_checksum(self, file_path: str) -> str:
        """Compute SHA-256 checksum of a file"""
        sha256 = hashlib.sha256()
        with open(file_path, 'rb') as f:
            for block in iter(lambda: f.read(4096), b''):
                sha256.update(block)
        return sha256.hexdigest()

    def upload_file(self, user_id: str, file_path: str, content_type: str = "application/octet-stream",
                   folder_id: Optional[str] = None) -> FileMetadata:
        """Upload and encrypt a file"""
        # Check if user exists
        if user_id not in self.user_manager.users:
            raise ValueError(f"User {user_id} does not exist")

        # Get file info
        original_filename = os.path.basename(file_path)
        file_size = os.path.getsize(file_path)
        file_id = str(uuid.uuid4())
        timestamp = int(time.time())

        # Compute checksum before encryption
        checksum = self._compute_checksum(file_path)

        # Create storage path
        stored_filename = f"{file_id}_{timestamp}"
        stored_path = os.path.join(self.storage_path, stored_filename)

        # Encrypt the file
        key_id = self.encryptor.encrypt_file(file_path, stored_path)

        # Create metadata
        metadata = FileMetadata(
            file_id=file_id,
            filename=stored_filename,
            original_filename=original_filename,
            size=file_size,
            content_type=content_type,
            owner_id=user_id,
            key_id=key_id,
            created_at=timestamp,
            modified_at=timestamp,
            checksum=checksum,
            parent_folder_id=folder_id
        )

        # Save metadata
        self.files[file_id] = metadata
        self._save_metadata()

        # Create owner permission
        owner_perm = FilePermission(
            file_id=file_id,
            user_id=user_id,
            permission_type=Permission.OWNER,
            granted_by=user_id,
            granted_at=timestamp
        )

        # Save permission
        self.permissions[file_id] = [owner_perm]
        self._save_permissions()

        return metadata

    def download_file(self, user_id: str, file_id: str, output_path: Optional[str] = None) -> str:
        """Download and decrypt a file"""
        # Check if file exists
        if file_id not in self.files:
            raise ValueError(f"File {file_id} not found")

        # Check permission
        if not self._has_permission(user_id, file_id, Permission.READ):
            raise PermissionError(f"User {user_id} does not have permission to read file {file_id}")

        file_meta = self.files[file_id]

        # Get the stored file path
        stored_path = os.path.join(self.storage_path, file_meta.filename)

        # Set output path if not provided
        if output_path is None:
            output_path = file_meta.original_filename

        # Decrypt the file
        decrypted_path = self.encryptor.decrypt_file(stored_path, file_meta.key_id, output_path)

        # Verify checksum
        checksum = self._compute_checksum(decrypted_path)
        if checksum != file_meta.checksum:
            # Remove the decrypted file if checksum fails
            os.remove(decrypted_path)
            raise ValueError(f"File integrity check failed: checksum mismatch for {file_id}")

        return decrypted_path

    def _has_permission(self, user_id: str, file_id: str, permission_type: str) -> bool:
        """Check if a user has a specific permission for a file"""
        if file_id not in self.permissions:
            return False

        # Check user's permissions
        user_perms = [p for p in self.permissions[file_id] if p.user_id == user_id]

        # Owner has all permissions
        if any(p.permission_type == Permission.OWNER for p in user_perms):
            return True

        # Check for specific permission
        has_permission = any(p.permission_type == permission_type for p in user_perms)

        # Check if any permission has expired
        now = int(time.time())
        valid_perms = [p for p in user_perms if p.expires_at is None or p.expires_at > now]

        return has_permission and len(valid_perms) > 0

    def grant_permission(self, grantor_id: str, file_id: str, grantee_id: str,
                        permission_type: str, expires_in: Optional[int] = None) -> FilePermission:
        """Grant a permission to a user for a file"""
        # Check if file exists
        if file_id not in self.files:
            raise ValueError(f"File {file_id} not found")

        # Check if grantor has permission to share
        if not self._has_permission(grantor_id, file_id, Permission.SHARE):
            raise PermissionError(f"User {grantor_id} does not have permission to share file {file_id}")

        # Check if users exist
        if grantor_id not in self.user_manager.users or grantee_id not in self.user_manager.users:
            raise ValueError("Invalid user ID")

        # Create permission
        timestamp = int(time.time())
        expires_at = None
        if expires_in is not None:
            expires_at = timestamp + expires_in

        permission = FilePermission(
            file_id=file_id,
            user_id=grantee_id,
            permission_type=permission_type,
            granted_by=grantor_id,
            granted_at=timestamp,
            expires_at=expires_at
        )

        # Save permission
        if file_id not in self.permissions:
            self.permissions[file_id] = []
        self.permissions[file_id].append(permission)
        self._save_permissions()

        return permission

    def revoke_permission(self, revoker_id: str, file_id: str, grantee_id: str,
                         permission_type: Optional[str] = None) -> bool:
        """Revoke a permission from a user for a file"""
        # Check if file exists
        if file_id not in self.files or file_id not in self.permissions:
            raise ValueError(f"File {file_id} not found")

        # Check if revoker is owner or self-revoking
        is_owner = self._has_permission(revoker_id, file_id, Permission.OWNER)
        is_self = revoker_id == grantee_id

        if not (is_owner or is_self):
            raise PermissionError(f"User {revoker_id} cannot revoke permissions for file {file_id}")

        # Find permissions to revoke
        original_count = len(self.permissions[file_id])
        if permission_type:
            # Revoke specific permission type
            self.permissions[file_id] = [
                p for p in self.permissions[file_id]
                if not (p.user_id == grantee_id and p.permission_type == permission_type)
            ]
        else:
            # Revoke all permissions
            self.permissions[file_id] = [
                p for p in self.permissions[file_id] if p.user_id != grantee_id
            ]

        # Check if any permissions were revoked
        if len(self.permissions[file_id]) < original_count:
            self._save_permissions()
            return True

        return False

    def list_files(self, user_id: str, folder_id: Optional[str] = None) -> List[FileMetadata]:
        """List files accessible to a user"""
        accessible_files = []

        for file_id, metadata in self.files.items():
            # Filter by folder if specified
            if folder_id is not None and metadata.parent_folder_id != folder_id:
                continue

            # Check if user has read permission
            if self._has_permission(user_id, file_id, Permission.READ):
                accessible_files.append(metadata)

        return accessible_files

    def delete_file(self, user_id: str, file_id: str) -> bool:
        """Delete a file"""
        # Check if file exists
        if file_id not in self.files:
            raise ValueError(f"File {file_id} not found")

        # Check if user has delete permission
        if not self._has_permission(user_id, file_id, Permission.DELETE):
            raise PermissionError(f"User {user_id} does not have permission to delete file {file_id}")

        # Get file metadata
        metadata = self.files[file_id]

        # Remove the file
        file_path = os.path.join(self.storage_path, metadata.filename)
        if os.path.exists(file_path):
            os.remove(file_path)

        # Remove encryption key
        key_path = os.path.join(self.encryptor.key_dir, f"{metadata.key_id}.key")
        if os.path.exists(key_path):
            os.remove(key_path)

        # Remove from metadata and permissions
        del self.files[file_id]
        if file_id in self.permissions:
            del self.permissions[file_id]

        # Save changes
        self._save_metadata()
        self._save_permissions()

        return True

# Example usage
if __name__ == "__main__":
    # Initialize the system
    file_manager = SecureFileManager()

    # Create users
    admin = file_manager.user_manager.create_user("admin", "admin_password", "admin")
    user1 = file_manager.user_manager.create_user("user1", "user1_password", "user")

    # Upload a file
    with open("example.txt", "w") as f:
        f.write("This is a test file with sensitive information.")

    file_meta = file_manager.upload_file(admin.user_id, "example.txt")
    print(f"File uploaded: {file_meta.file_id}")

    # Grant permission to user1
    file_manager.grant_permission(
        admin.user_id, file_meta.file_id, user1.user_id,
        Permission.READ, expires_in=3600  # 1 hour
    )

    # Download the file
    decrypted_path = file_manager.download_file(user1.user_id, file_meta.file_id, "downloaded.txt")
    print(f"File downloaded to: {decrypted_path}")

    # List files accessible to user1
    user_files = file_manager.list_files(user1.user_id)
    print(f"User1 has access to {len(user_files)} files")

    # Revoke permission
    file_manager.revoke_permission(admin.user_id, file_meta.file_id, user1.user_id)

    # Clean up
    os.remove("example.txt")
    os.remove("downloaded.txt")
