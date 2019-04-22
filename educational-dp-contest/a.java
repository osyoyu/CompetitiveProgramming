import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] h = new int[N+1];

        for (int i = 0; i < N; i++) {
            h[i+1] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        dp[N] = 0;
        dp[N-1] = Math.abs(h[N] - h[N-1]);

        for (int i = N-2; i >= 1; i--) {
            dp[i] = Math.min(Math.abs(h[i] - h[i+1]) + dp[i+1], Math.abs(h[i] - h[i+2]) + dp[i+2]);
        }

        // System.out.println(Arrays.toString(dp));

        System.out.println(dp[1]);
    }
}
