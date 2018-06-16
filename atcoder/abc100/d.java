import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[][] ary = new long[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                ary[i][j] = sc.nextLong();
            }
        }

        long[][] dp = new long[N+1][M+1];
        Long[] answers = new Long[8];

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (ary[i-1][0] + ary[i-1][1] + ary[i-1][2]));
            }
        }
        answers[0] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (ary[i-1][0] + ary[i-1][1] - ary[i-1][2]));
            }
        }
        answers[1] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (ary[i-1][0] - ary[i-1][1] + ary[i-1][2]));
            }
        }
        answers[2] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (ary[i-1][0] - ary[i-1][1] - ary[i-1][2]));
            }
        }
        answers[3] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (-ary[i-1][0] + ary[i-1][1] + ary[i-1][2]));
            }
        }
        answers[4] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (-ary[i-1][0] + ary[i-1][1] - ary[i-1][2]));
            }
        }
        answers[5] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (-ary[i-1][0] - ary[i-1][1] + ary[i-1][2]));
            }
        }
        answers[6] = dp[N][M];

        for (int i = 0; i < N+1; i++) {
            for (int w = 0; w < M+1; w++) {
                dp[i][w] = 0;
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int w = 1; w < M+1; w++) {
                // 入れない場合, 入れる場合
                dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-1] + (-ary[i-1][0] - ary[i-1][1] - ary[i-1][2]));
            }
        }
        answers[7] = dp[N][M];

        System.out.println(Collections.max(Arrays.asList(answers)));
    }
}
