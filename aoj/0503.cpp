#include <iostream>
#include <vector>
#include <cstdlib>
#include <cmath>
using namespace std;

int main() {
  int input, height, i, j;
  int n, m;
  int turns_left, turns_right;
  int position, d;

  while (true){
    cin >> n;
    cin >> m;

    if (n == 0 && m == 0) { break; }

    vector<int> cups(15);

    // input
    for (i = 0; i < 3; i++) {
      cin >> height;
      for (j = 0; j < height; j++) {
        cin >> input;
        cups.at(input - 1) = i;
      }
    }

    // left
    position = 0;
    turns_left = 0;
    for (i = 0; i < n; i++) {
      d = position - cups.at(i);
      if (d == 0) {
      } else if (d == 1 || d == -1) {
        turns_left += static_cast<int>(pow(3, (n - 1) - i));
        if (position == 0) {
          position = 2;
        } else if (position == 2) { 
          position = 0;
        }
      } else if (d == 2 || d == -2) {
        turns_left += 2 * static_cast<int>(pow(3, (n - 1) - i));
      }
    }

    // right
    position = 2;
    turns_right = 0;
    for (i = 0; i < n; i++) {
      d = position - cups.at(i);
      if (d == 0) {
      } else if (d == 1 || d == -1) {
        turns_right += static_cast<int>(pow(3, (n - 1) - i));
        if (position == 0) {
          position = 2;
        } else if (position == 2) { 
          position = 0;
        }
      } else if (d == 2 || d == -2) {
        turns_right += 2 * static_cast<int>(pow(3, (n - 1) - i));
      }
    }

    cout << (min(turns_left, turns_right) <= m ? min(turns_left, turns_right) : -1) << endl;

    cups.clear();
  }

  return 0;
}
