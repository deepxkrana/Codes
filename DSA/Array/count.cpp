//largest element
#include<iostream>
using namespace std;
int main(){
    int arr[5]={2,4,7,5,9};
    int n=sizeof(arr)/sizeof(arr[0]);
    int target=5;
    int count=0;
    for(int i=0;i<n;i++){
        if(arr[i]>target) count++;
    }
    cout<<count;
}