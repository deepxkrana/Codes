#include<iostream>
#include<string>
#include<sstream>
#include<algorithm>
using namespace std;
string reverseWords(string s){
    stringstream ss(s);
    vector<string> words;
    string w;
    while(ss>>w){
        words.push_back(w);
    }
    string result;
    // reverse(words.begin(),words.end());
    for(int i=words.size()-1;i>=0;i--){
        result+=words[i];
        if(i>0) result += " ";
    }
    return result;
}
int main(){
    string s = "the sky is blue";
    cout << reverseWords(s);
}