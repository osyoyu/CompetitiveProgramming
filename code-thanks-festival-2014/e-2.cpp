#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int dy[]={0, 1, 0, -1};
int dx[]={-1, 0, 1, 0};

int r, c, r_s, c_s, r_g, c_g, n;

char grid[50][50];

void dfs(int x, int y) {
  grid[x][y] = '.';

  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];

    if (nx >= 0 && nx <= r && ny >= 0 && ny <= c) {
      if (grid[nx][ny] == 'G') { grid[nx][ny] = '&'; return; }
      if (grid[nx][ny] == '#') { dfs(nx, ny); }
    }
  }
}

int main() {
  cin >> r >> c >> r_s >> c_s >> r_g >> c_g >> n;

  // initialize with '.'
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      grid[i][j] = '.';
    }
  }

  for (int i = 0; i < n; i++) {
    int r_i, c_i, h_i, w_i;
    cin >> r_i >> c_i >> h_i >> w_i;

    for (int j = r_i - 1; j < (r_i - 1) + h_i; j++) {
      for (int k = c_i - 1; k < (c_i - 1) + w_i; k++) {
        grid[j][k] = '#';
      }
    }
  }

  if (grid[r_s - 1][c_s - 1] != '#') {
    cout << "NO" << endl;
    return 0;
  }

  if (grid[r_g - 1][c_g - 1] == '#') {
    grid[r_g - 1][c_g - 1] = 'G';
  } else {
    cout << "NO" << endl;
    return 0;
  }

  dfs(r_s - 1, c_s - 1);

  /*
     for (int i = 0; i < r; i++) {
     for (int j = 0; j < c; j++) {
     cout << grid[i][j];
     }
     cout << endl;
     }
     */

  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      if (grid[i][j] == 'G') {
        cout << "NO" << endl;
        return 0;
      }
    }
  }

  cout << "YES" << endl;

  return 0;
}
