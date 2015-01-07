#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int dy[]={0, 1, 0, -1};
int dx[]={-1, 0, 1, 0};

int r, c, r_s, c_s, r_g, c_g, n;

bool grid[50][50];
bool grid_visited[50][50];

bool bfs(int x, int y) {
  cout << "now at " << x << ", " << y << endl;

  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (i == x && j == y) {
        cout << "!";
        continue;
      }
      if (grid_visited[i][j] == true) {
        cout << "v";
      } else {
        cout << ".";
      }
    }
    cout << endl;
  }

  grid_visited[x][y] = true;

  if (grid[x][y] == false) { return false; }
  if (x == r_g - 1 && y == c_g - 1 && grid[x][y] == true) { return true; }

  for (int i = 0; i < 4; i++) {
    if ((x + dx[i] >= 0) && (x + dx[i] <= c) && (y + dy[i] >= 0) && (y + dy[i] <= r)) {
      if (grid[x + dx[i]][y + dy[i]] == true) {
        if (grid_visited[x + dx[i]][y + dy[i]] == false) {
          bfs(x + dx[i], y + dy[i]);
        } else {
          cout << "visited: " << x + dx[i] << ", " << y + dy[i] << endl;
        }
      } else {
        cout << "false: " << x + dx[i] << ", " << y + dy[i] << endl;
      }
    } else {
      cout << "out of range: " << x + dx[i] << ", " << y + dy[i] << endl;
    }
  }

  return false;
}


int main() {
  cin >> r >> c >> r_s >> c_s >> r_g >> c_g >> n;

  // initialize with false
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      grid[i][j] = false;
      grid_visited[i][j] = false;
    }
  }

  for (int i = 0; i < n; i++) {
    int r_i, c_i, h_i, w_i;
    cin >> r_i >> c_i >> h_i >> w_i;

    for (int j = r_i - 1; j < (r_i - 1) + h_i; j++) {
      for (int k = c_i - 1; k < (c_i - 1) + w_i; k++) {
        grid[j][k] = true;
      }
    }
  }

  // print
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (grid[i][j] == true) {
        cout << "#";
      } else {
        cout << ".";
      }
    }
    cout << endl;
  }

  cout << "result:" << endl;
  cout << bfs(r_s - 1, c_s - 1) << endl;

  return 0;
}
