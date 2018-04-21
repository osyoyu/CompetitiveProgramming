#include "stdio.h"

int main() {
  char S[4];
  scanf("%s", S);

  if (S[0] != S[1] && S[1] != S[2] && S[2] != S[0]) {
    puts("Yes");
  }
  else {
    puts("No");
  }

  return 0;
}
