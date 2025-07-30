#include <iostream>
#include <fstream>
#include <cryptlib.h>
#include <aes.h>
#include <filters.h>
#include <modes.h>
#include <osrng.h>

using namespace CryptoPP;
using namespace std;

void encryptFile(const string& inputFile, const string& outputFile, const byte key[AES::DEFAULT_KEYLENGTH], const byte iv[AES::BLOCKSIZE]) {
    ifstream in(inputFile, ios::binary);
    ofstream out(outputFile, ios::binary);

    if (!in || !out) {
        cerr << "Error opening files!" << endl;
        return;
    }

    CBC_Mode<AES>::Encryption encryptor;
    encryptor.SetKeyWithIV(key, AES::DEFAULT_KEYLENGTH, iv);

    FileSource(in, true, new StreamTransformationFilter(encryptor, new FileSink(out)));

    cout << "Encryption successful!" << endl;
}

void decryptFile(const string& inputFile, const string& outputFile, const byte key[AES::DEFAULT_KEYLENGTH], const byte iv[AES::BLOCKSIZE]) {
    ifstream in(inputFile, ios::binary);
    ofstream out(outputFile, ios::binary);

    if (!in || !out) {
        cerr << "Error opening files!" << endl;
        return;
    }

    CBC_Mode<AES>::Decryption decryptor;
    decryptor.SetKeyWithIV(key, AES::DEFAULT_KEYLENGTH, iv);

    FileSource(in, true, new StreamTransformationFilter(decryptor, new FileSink(out)));

    cout << "Decryption successful!" << endl;
}

int main() {
    AutoSeededRandomPool prng;

    byte key[AES::DEFAULT_KEYLENGTH];
    byte iv[AES::BLOCKSIZE];

    prng.GenerateBlock(key, sizeof(key));
    prng.GenerateBlock(iv, sizeof(iv));

    string inputFile = "sample.txt";
    string encryptedFile = "encrypted.dat";
    string decryptedFile = "decrypted.txt";

    encryptFile(inputFile, encryptedFile, key, iv);
    decryptFile(encryptedFile, decryptedFile, key, iv);

    return 0;
}
