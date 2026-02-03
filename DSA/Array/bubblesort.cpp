#include<iostream>
using namespace std;
void bubbleSort(int arr[],int n){
    for(int i=0; i<n-1;i++){
        bool isSwap=false;
        for(int j=0; j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                swap(arr[j], arr[j+1]);
            }
        }
    }
}
void insertionSort(int arr[], int n){
    for(int i=1;i<n;i++){
        int key=arr[i];
        int j=i-1;
        while(j>=0 && arr[j]>key){
            arr[j+1]= arr[j];
            j--;
        }
        arr[j+1]=key;
    }
}
void selectionSort(int arr[], int n){
    for(int i=0;i<n-1;i++){
        int minIdx=i;
        for(int j=i+1; j<n; j++){
            if(arr[j] < arr[minIdx]){
                minIdx=j;
            }
        }
        swap(arr[i], arr[minIdx]);
    }
}
int main(){
    int arr1[] = {5, 2, 4, 6, 1, 3};
    int n1 = sizeof(arr1) / sizeof(arr1[0]);

    int arr2[] = {5,8,1,9,3,6};
    int n2 = sizeof(arr2) / sizeof(arr2[0]);

    int arr3[] = {7,2,9,1,5,8};
    int n3 = sizeof(arr3) / sizeof(arr3[0]);

    insertionSort(arr1, n1);
    bubbleSort(arr2,n2);
    selectionSort(arr3,n3);

    for (int i = 0; i < n1; i++){
        cout << arr1[i] << " ";
    }
    cout<<endl;

    for (int i = 0; i < n2; i++){
        cout << arr2[i] << " ";
    }
    cout<<endl;

    for (int i = 0; i < n3; i++){
        cout << arr3[i] << " ";
    }
    cout<<endl;


    return 0;
}