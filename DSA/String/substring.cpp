#include<iostream>
#include<string>
using namespace std;
int main(){
    string str;
    getline(cin,str);
    int len=str.length();
    str.substr(len/2);
}