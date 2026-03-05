#include<iostream>
using namespace std;
class Node{
    public:
    int val;
    Node* next;
    Node(int val){
        this->val=val;
        next=NULL;
    }
};
class Stack{
public:
    Node* head;
    int sz;
    Stack(){
        head=NULL;
        sz=0;
    }
    void push(int val){
        Node* temp=new Node(val);
        temp->next=head;
        head=temp;
        sz++;
    }
    void pop(){
        if(head==NULL){
            cout<<"Stack is Empty"<<endl;
            return;
        }
        Node* temp=head;
        head=head->next;
        delete temp;
        sz--;
    }
    int top(){
        if(head==NULL){
            cout<<"Stack is Empty"<<endl;
            return -1;
        }
        return head->val;
    }
    int size(){
        return sz;
    }
    void print(Node* temp){
        if(temp==NULL) return;
        print(temp->next);
        cout<<temp->val<<" ";
    }
    void display(){
        Node* temp=head;
        print(temp);
        cout<<endl;
    }
};
int main(){
    Stack st;
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);
    st.push(50);
    cout<<st.size()<<endl;
    st.pop();
    cout<<st.size()<<endl;
    cout<<st.top()<<endl;
    st.display();
}