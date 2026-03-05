#include<iostream>
using namespace std;
class Stack{
public:
    int arr[5];
    int idx;
    Stack(){
        idx=-1;
    }
    void push(int val){
        if(idx==4){
            cout<<"Stack is Full"<<endl;
            return;
        }
        arr[++idx]=val;
    }
    void pop(){
        if(idx==-1){
            cout<<"Stack is Empty"<<endl;
            return;
        }
        idx--;
    }
    int top(){
        if(idx==-1){
            cout<<"Stack is Empty"<<endl;
            return -1;
        }
        return arr[idx];
    }
    int size(){
        return idx+1;
    }
    void print(int i){
        if(i<0) return;
        print(i-1);
        cout<<arr[i]<<" ";
    }
    void display(){
        print(idx);
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