#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

int main() {
    vector<int> arr = {7, 9, 1, 3, 5};
    int target = 6;

    unordered_set<int> seen;

    for (int x : arr) {
        int rem = target - x;

        if (seen.find(rem) != seen.end()) {
            cout << "true";
            return 0;
        }

        seen.insert(x);
    }

    cout << "false";
    return 0;
}