#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

int main(int argc, char const* argv[])
{
  int i, input;
  vector<int> scores;

  for (i = 0; i < 5; i++) {
    cin >> input;
    if (input < 40) { input = 40; }
    scores.push_back(input);
  }

  cout << accumulate(scores.begin(), scores.end(), 0) / 5 << endl;

  return 0;
}
