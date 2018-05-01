import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static <T> void printDPTable(T[][] dp) {
        for (T[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int points[] = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = sc.nextInt();
        }
        int maxPoint = IntStream.of(points).sum();

        Boolean dp[][] = new Boolean[N+1][maxPoint+1];

        // DP 初期化
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= N; i++) {
            for (int p = 1; p <= maxPoint; p++) {
                dp[i][p] = false;
            }
        }

        // printDPTable(dp);

        // DP
        for (int i = 0; i < N; i++) {
            for (int p = 0; p <= maxPoint; p++) {
                // System.out.println(String.format("i, p = %d, %d", i, p));
                if (p >= points[i]) {
                    dp[i+1][p] = dp[i][p-points[i]] || dp[i][p];
                }
                else {
                    dp[i+1][p] = dp[i][p];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= maxPoint; i++) {
            if (dp[N][i]) { answer++; }
        }

        // printDPTable(dp);

        System.out.println(answer);
    }
}
