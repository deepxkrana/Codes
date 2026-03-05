#include<iostream>
using namespace std;
int find(int arr[], int size,int target,int i=0){
    if(i==size) return -1;
    if(arr[i]==target) return i;
    return find(arr,size,target,i+1);
}
int main(){
    int arr[]={1,5,1,1,9,10};
    int n=sizeof(arr)/sizeof(arr[0]);
    int target=9;
    cout<<find(arr,n,target);

}