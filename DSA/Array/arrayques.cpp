// #include<iostream>
// using namespace std;
// int main(){
//     int arr[7];
//     // cout<<arr[0];
//     // cin>>arr[0];
//     for(int i=0;i<=6;i++){
//         cin>>arr[i];
//     }
//     for(int i=0;i<=6;i++){
//         cout<<arr[i]<<" ";
//     }
// }


// #include<iostream>
// using namespace std;
// int main(){
//     int n;
//     cout<<"Enter Number of students: ";
//     cin>>n;
//     int arr[n];
//     for(int i=0;i<=n-1;i++){
//         cin>>arr[i];
//     }
//     for(int i=0;i<=6;i++){
//         if(arr[i]<35){
//             cout<<i<<" ";
//         }
//     }
//     //Size and Size of Operator
//     cout<<endl;
//     int size=sizeof(arr)/sizeof(arr[0]);
//     cout<<size;
// }

// #include<iostream>
// using namespace std;
// int main(){
//     int arr[7]={90, 33, 34, 66, 78, 22, 97};
//     int sum=0;
//     for(int i=0;i<=6;i++){
//         sum+=arr[i];
//     }
//     cout<<sum;
// }

//Linear Search
// #include<iostream>
// using namespace std;
// int main(){
//     int n;
//     cout<<"Enter the size: ";
//     cin>>n;
//     int arr[n];
//     for(int i=0;i<=n-1;i++){
//         cin>>arr[i];
//     }
//     int x;
//     cout<<"Enter the Number to find: ";
//     cin>>x;
//     bool flag=false;
//     for(int i=0;i<=n;i++){
//         if(arr[i]==x) flag=true;
//     }
//     if(flag==true) cout<<"Present";
//     else cout<<"Absent";
// }


//Fing Max element
// #include<iostream>
// #include<climits> //To use INT_MIN and INT_MAX
// using namespace std;
// int main(){
//     int n;
//     cout<<"Enter the size: ";
//     cin>>n;
//     int arr[n];
//     for(int i=0;i<=n-1;i++){
//         cin>>arr[i];
//     }
//     int max=INT_MIN; //INT_MIN to find Max val and INT_MAX to find Min val
//     for(int i=1;i<=n-1;i++){
//         if(max<arr[i]) max=arr[i];
//     }
//     int smax=INT_MIN;
//     for(int i=1;i<=n-1;i++){
//         if(arr[i]!=max && smax<arr[i]) smax=arr[i];
//     }
//     cout<<max;
//     cout<<smax;
// }


#include<iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter the size: ";
    cin>>n;
    int arr[n];
    for(int i=0;i<=n-1;i++){
        cin>>arr[i];
    }
    int x;
    cout<<"Enter the Number to find: ";
    cin>>x;
    bool flag=false;
    for(int i=0;i<=n;i++){
        if(arr[i]==x) flag=true;
    }
    int count=0;
    if(flag==true){
        for(int i=0;i<n;i++){
            if(arr[i]>x) count++;
        }
        cout<<count;
    }
    else cout<<"Absent";
}