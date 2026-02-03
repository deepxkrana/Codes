#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    vector<int> v = {0,3,4,7,9,10};
    int n = v.size();
    int k = 4;

    // selection mask
    vector<int> mask(n, 0);
    for(int i = n - k; i < n; i++)
        mask[i] = 1;

    do {
        // print current combination
        for(int i = 0; i < n; i++) {
            if(mask[i])
                cout << v[i] << " ";
        }
        cout << endl;

    } while(next_permutation(mask.begin(), mask.end()));
    
}