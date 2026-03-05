#include<iostream>
using namespace std;
class Stack{
public:
    vector<int> v;
    Stack(){
    }
    void push(int val){
        v.push_back(val);
    }
    void pop(){
        if(v.size()==0){
            cout<<"Stack is Empty"<<endl;
            return;
        }
        v.pop_back();
    }
    int top(){
        if(v.size()==0){
            cout<<"Stack is Empty"<<endl;
            return -1;
        }
        return v[v.size()-1];
    }
    int size(){
        return (int)v.size();
    }
    void print(int i){
        if(i<0) return;
        print(i-1);
        cout<<v[i]<<" ";
    }
    void display(){
        print(v.size()-1);
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