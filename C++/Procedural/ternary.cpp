#include<iostream>
using namespace std;
int main(){
    int x;
    cin>>x;
    // if(x%2==0){
    //     cout<<"even";
    // }
    // else { cout<<"odd"; }
    //condition ? true : false ;
    x%2==0 ? cout<<"even" : cout<<"odd";
    x>33 ? cout<<"pass" : cout<<"fail";
}