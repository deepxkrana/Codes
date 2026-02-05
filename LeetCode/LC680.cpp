#include<iostream>
#include<string>

// Valid Palindrome II
// Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

// Example 1:

// Input: s = "aba"
// Output: true
// Example 2:

// Input: s = "abca"
// Output: true
// Explanation: You could delete the character 'c'.
// Example 3:

// Input: s = "abc"
// Output: false

//Code
class Solution {
public:
    bool palin(string s, int l, int h){
        bool p=true;
        while(l<h){
            if(s[l]!=s[h]){
                p=false;
                break;
            }
            l++;
            h--;
        }
        return p;
    }
    bool validPalindrome(string s) {
        int low=0;
        int high=s.size()-1;
        while(low<high){
            if(s[low]!=s[high]){
                return palin(s,low+1,high) || palin(s,low,high-1);
            }
            low++;
            high--;
        }
        return true;
    }
};