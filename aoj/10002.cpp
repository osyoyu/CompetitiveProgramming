#include <iostream>
using namespace std;

int main() {
  std::cin.tie(0);
  std::ios::sync_with_stdio(false);

  int a, b;
  cin >> a;
  cin >> b;
  cout << a * b << " " << (a + b) * 2 << endl;

  return 0;
}
