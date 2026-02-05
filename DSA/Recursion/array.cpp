#include<iostream>
using namespace std;
int printnormal(int arr[], int size, int i=0){
    if(i==size) return 0;
    cout<<arr[i]<<" ";
    printnormal(arr, size, i+1);
    return 0;
}
int printreverse(int arr[], int size, int i=0){
    if(i==size) return 0;
    cout<<arr[i]<<" ";
    printreverse(arr, size, i+1);
    return 0;
}
int main(){
    int arr[]={0,1,2,3,4};
    int n=sizeof(arr)/sizeof(arr[0]);
    printnormal(arr, n);
    printreverse(arr, n);
}