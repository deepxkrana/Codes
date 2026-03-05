#include<iostream>
using namespace std;
void print(stack<int>& s){
    stack<int>temp;
    while(s.size()>0){
        temp.push(s.top());
        s.pop();
    }
    while(temp.size()>0){
        cout<<temp.top()<<" ";
        s.push(temp.top());
        temp.pop();
    }
    cout<<endl;
}
void pushAtBottom(stack<int>& s,int val){
    stack<int>temp;
    while(s.size()>0){
        temp.push(s.top());
        s.pop();
    }
    s.push(val);
    while(temp.size()>0){
        s.push(temp.top());
        temp.pop();
    }
}
void pushAtIdx(stack<int>& s,int idx,int val){
    stack<int>temp;
    while(s.size()>idx){
        temp.push(s.top());
        s.pop();
    }
    s.push(val);
    while(temp.size()>0){
        s.push(temp.top());
        temp.pop();
    }
}
int main(){
    stack<int> st;
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);
    st.push(50);
    print(st);
    pushAtBottom(st,70);
    print(st);
    pushAtIdx(st,2,90);
    print(st);
}