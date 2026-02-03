#include<iostream>
using namespace std;
int main(){
    int arr[]={0,3,5,2,4,6};
    int n = sizeof(arr) / sizeof(arr[0]);
    int target=6;
    bool sol=false;
    for(int i=0; i<n-1;i++){
        for(int j=0;j<n-1;j++){
            if(arr[i]+arr[j]==target){
                cout<<arr[i];
                cout<<arr[j];
            }
        }
    }
}