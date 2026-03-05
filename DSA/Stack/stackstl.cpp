#include<iostream>
using namespace std;
int main(){
    stack<int> s;
    s.push(10);
    s.push(20);
    s.push(30);
    s.push(40);
    s.push(50);
    // cout<<"Top Element: "<<s.top()<<endl; //40
    // s.pop(); //removes 40
    // cout<<"New Top: "<<s.top()<<endl; //30
    // cout<<"Size: "<<s.size()<<endl;
    // cout<<s.empty()<<endl; //returns 1 for true and 0 for false
    stack<int>temp;
    while(s.size()>0){
        cout<<s.top()<<" ";
        temp.push(s.top());
        s.pop();
    }
    cout<<endl;
    while(temp.size()>0){
        cout<<temp.top()<<" ";
        s.push(temp.top());
        temp.pop();
    }
}