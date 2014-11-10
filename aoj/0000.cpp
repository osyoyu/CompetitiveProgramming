#include <iostream>

int main(int argc, char const* argv[])
{
  int i, j;
  
  for (i = 1; i <= 9; i++) {
    for (j = 1; j <= 9; j++) {
      std::cout << i << "x" << j << "=" << i * j << std::endl;
    }
  }

  return 0;
}
