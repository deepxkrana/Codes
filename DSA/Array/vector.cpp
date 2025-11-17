// #include<iostream>
// #include<vector>
// using namespace std;
// int main(){
//     vector<int> v; //you need not mention size
//     vector<int> ve(5,7); // initial size = 5, each element is 7
//     v.push_back(6);
//     v.push_back(4);
//     v.push_back(8);
//     v.push_back(0);
//     v.size(); //checks the no. of element in the vector
//     v.capacity(); //doubles the size of the vector if full //capacity does not decrease when doing v.pop_back()
//     for(int s : v){
//         cout<<s<<" ";
//     }
//     cout<<endl;
//     v.pop_back();
//     for(int s : v){
//         cout<<s<<" ";
//     }
// }

#include<iostream>
#include<vector>
using namespace std;
int main(){
    vector<int> v; //you need not mention size
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int x;
        cin>>x;
        v.push_back(x);
    }
    sort(v.begin(),v.end());
    for(int s : v){
        cout<<s<<" ";
    }
}