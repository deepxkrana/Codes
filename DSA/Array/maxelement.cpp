// //largest element
// #include<iostream>
// using namespace std;
// int main(){
//     int arr[5]={2,4,7,5,9};
//     int n=sizeof(arr)/sizeof(arr[0]);
//     int max=arr[0];
//     for(int i=0;i<n;i++){
//         if(max<arr[i]) max=arr[i];
//     }
//     cout<<max;
// }

//second largest element
#include<iostream>
using namespace std;
int main(){
    int arr[5]={2,4,7,5,9};
    int n=sizeof(arr)/sizeof(arr[0]);
    int max=arr[0];
    for(int i=0;i<n;i++){
        if(max<arr[i]) max=arr[i];
    }
    cout<<max<<endl;
    int smax=INT_MIN;
    for(int i=0;i<n;i++){
        if(arr[i]!=max && smax<arr[i]) smax=arr[i];
    }
    cout<<smax<<endl;
}