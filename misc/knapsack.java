import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void printDPTable(int[][] dp) {
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int values[] = new int[N];
        int weights[] = new int[N];

        int dp[][] = new int[N+1][W+1];

        for (int i = 0; i < N; i++) {
            values[i] = sc.nextInt();
            weights[i] = sc.nextInt();
        }

        // DP 初期化
        for (int i = 0; i < W; i++) {
            dp[0][i] = 0;
        }

        // DP
        for (int i = 0; i < N; i++) {
            for (int w = 0; w <= W; w++) {
                if (w >= weights[i]) {
                    dp[i+1][w] = Math.max(dp[i][w-weights[i]] + values[i], dp[i][w]);
                }
                else {
                    dp[i+1][w] = dp[i][w];
                }
            }
        }

        printDPTable(dp);
        System.out.println(dp[N][W]);
    }
}
