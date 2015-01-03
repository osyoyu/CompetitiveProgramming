#include <iostream>
#include <vector>

using namespace std;

int MAX = 1000001;
int prime[1000001] = {0};

void make_prime(){
  int i, j;

  for (i = 2; i < MAX; i++) {
    prime[i] = 1;
  }

  for (i = 2; i * i < MAX; i++) {
    if (prime[i]){
      for (j = i * 2; j < MAX; j += i) {
        prime[j] = 0;
      }
    }
  }
}

int main() {
  make_prime();

  int n;
  cin >> n;

  if (prime[((1 + n) * n) / 2] == 1) {
    cout << "WANWAN" << endl;
  } else {
    cout << "BOWWOW" << endl;
  }

  return 0;
}

