#include <cstdio>
#include <vector>
#include <algorithm>
#include <iterator>
using namespace std;

#define DEBUG true

int main() {
  int N, M;
  scanf("%d %d", &N, &M);

  vector<int> train(N + 2, 0);
  train[0] = 1;
  train[N+1] = 1;

  vector<int> human(M, 0);
  vector<int> human_next(M, 0);

  for (int i = 0; i < M; i++)
  {
    int input;
    scanf("%d", &input);
    human[i] = input;
  }

  int answer = -1;
  int left_border = 0;
  int right_border = N;
  while (left_border != right_border)
  {
    answer++;
    // update train
    for (int i = 0; i < M; i++)
    {
      train[human[i]] = 1;
    }

    bool endflag = true;
    for (int i = 1; i < M; i++)
    {
      if (train[i] == 0) { endflag = false; break; }
    }
    if (endflag) { break; }

    // update border
    for (int j = left_border; ; j++)
    {
      if (train[j] == 0) { left_border = j - 1; break; }
    }
    for (int j = right_border; ; j--)
    {
      if (train[j] == 0) { right_border = j + 1; break; }
    }

    // debug
    if (DEBUG) {
      printf("Left Border:  %d\n", left_border);
      printf("Right Border: %d\n", right_border);
      printf("Current State:\n");
      for (int i = 1; i < N; i++)
      {
        if (train[i] == false) printf("x");
        if (train[i] == true)  printf("O");
      }
      puts("");
      for (int i = 0; i < M; i++)
      {
        printf("Human %d: %d\n", i, human[i]);
      }
      puts("");
    }


    // move people
    for (int j = 0; j < M; j++)
    {
      if (j == 0)
      {
        if (human[j] >= left_border) { human_next[j] = human[j] + 1; }
        else { human_next[j] = human[j] - 1; }
      }

      else if (j == M-1)
      {
        if (human[j] <= right_border) { human_next[j] = human[j] - 1; }
        else { human_next[j] = human[j] + 1; }
      }

      else if (train[human[j] - 1] != train[human[j] + 1])
      {
        // 片方が未であればそっちに動く
        if (train[human[j] - 1] == 0)
        {
          human_next[j] = human[j] - 1;
        }
        else if (train[human[j] + 1] == 0)
        {
          human_next[j] = human[j] + 1;
        }
      }

      else
      {
        // 遠い車掌の方に動く
        if ((human[j] - human[j-1]) > (human[j+1] - human[j]))
        {
          human_next[j] = human[j] - 1;
        }
        else if ((human[j] - human[j-1]) < (human[j+1] - human[j]))
        {
          human_next[j] = human[j] + 1;
        }
        else
        {
          // (とりあえず左に動く)
          human_next[j] = human[j] - 1;
        }
      }
    }

    for (int i = 0; i < M; i++)
    {
      human[i] = human_next[i];
    }
  }

  printf("%d", answer);



  return 0;
}
