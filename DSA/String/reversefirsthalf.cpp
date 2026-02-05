#include<iostream>
#include<string>
using namespace std;
int main(){
    string str;
    getline(cin,str);
    int len=str.length();
    reverse(str.begin()+0,str.begin()+len/2);
}