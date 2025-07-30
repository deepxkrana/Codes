#include <iostream>

using namespace std;

const int MAX = 6;
int adj[MAX][MAX] = {0};
bool visited[MAX] = {false};

void dfs(int node) {
    visited[node] = true;
    cout << node << " ";

    for (int i = 0; i < MAX; i++) {
        if (adj[node][i] == 1 && !visited[i]) {
            dfs(i);
        }
    }
}

int main() {
    adj[0][1] = adj[1][0] = 1;
    adj[0][2] = adj[2][0] = 1;
    adj[1][3] = adj[3][1] = 1;
    adj[1][4] = adj[4][1] = 1;
    adj[2][5] = adj[5][2] = 1;
    adj[4][5] = adj[5][4] = 1;

    cout << "DFS Traversal: ";
    dfs(0);

    return 0;
}
