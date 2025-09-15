#include<iostream>
using namespace std;
class Node{
    public:
    int val;
    Node* next;
    Node* prev;
    Node(int val){
        this->val=val;
        this->next=NULL;
        this->prev=NULL;
    }
};
class DoublyLinkedList{
    public:
    Node* head;
    Node* tail;
    int size;
    DoublyLinkedList(){
        head=tail=NULL;
        size=0;
    }
    void insertAtTail(int val){
        Node* temp=new Node(val);
        if(size==0) head=tail=temp;
        else{
            tail->next=temp;
            temp->prev=tail;
            tail=temp; 
        }
        size++;
    }
    void insertAtHead(int val){
        Node* temp=new Node(val);
        if(size==0) head=tail=temp;
        else{
            temp->next=head;
            head->prev=temp;
            head=temp;
        }
        size++;
    }
    void insertAtIdx(int idx, int val){
        if(idx<0 || idx>size) cout<<"Invalid Index"<<endl;
        else if(idx==0) insertAtHead(val);
        else if(idx==size) insertAtTail(val);
        else{
            Node* t=new Node(val);
            Node* temp=head;
            for(int i=1;i<idx-1;i++){
                temp=temp->next;
            }
            t->next=temp->next;
            temp->next=t;
            t->prev=temp;
            t->next->prev=t;
            size++;
        }
    }
    void deleteAtHead(){
        if(size==0){
            cout<<"LL is Empty"<<endl;
            return;
        }
        head=head->next;
        if(head) head->prev=NULL;
        if(head==NULL) tail=NULL;
        size--;
    }
    void deleteAtTail(){
        if(size==0){
            cout<<"LL is Empty"<<endl;
            return;
        }
        else if(size==1) {
            deleteAtHead();
            return;
        }
        else{
            Node* temp=tail->prev;
            temp->next=NULL;
            tail=temp;
        }
        size--;
    }
    void deleteAtIdx(int idx){
        if(size==0){
            cout<<"List is Empty"<<endl;
            return;
        }
        else if(idx<0 || idx>size){
            cout<<"Invalid Index"<<endl;
            return;
        }
        else if(idx==0) return deleteAtHead();
        else if(idx==size) return deleteAtTail();
        else{
            Node* temp=head;
            for(int i=1;i<idx-1;i++){
                temp=temp->next;
            }
            temp->next=temp->next->next;
            temp->next->prev=temp;
            size--;
        }
    }
    int getidx(int idx){
        if(idx>=size || idx<0){
            cout<<"Invalid index";
            return -1;
        }
        else if(idx==0) return head->val;
        else if(idx==size-1) return tail->val;
        else{
            if(idx<size/2){
                Node* temp=head;
                for(int i=1;i<=idx;i++){
                    temp=temp->next;
                }
                return temp->val;
            }
            else{
                Node* temp=tail;
                for(int i=1;i<size-idx;i++){
                    temp=temp->prev;
                }
                return temp->val;
            }
        }
    }
    void display(){
        Node* temp=head;
        while(temp){
            cout<<temp->val<<" ";
            temp=temp->next;
        }
        cout<<endl;
    }
};
int main(){
    DoublyLinkedList ll;
    ll.insertAtHead(10);
    ll.insertAtTail(20);
    ll.insertAtIdx(1,15);
    ll.display();
    ll.insertAtHead(5);
    ll.insertAtTail(30);
    ll.display();
    ll.deleteAtTail();
    ll.display();
    ll.deleteAtHead();
    ll.display();
    ll.deleteAtIdx(1);
    ll.display();
    cout<<ll.getidx(1);
    cout<<endl;
    cout<<149/2;
}