import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] h = new int[N+1];

        for (int i = 0; i < N; i++) {
            h[i+1] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        dp[N] = 0;

        for (int i = N-1; i >= 1; i--) {
            List<Integer> candidates = new ArrayList<Integer>();
            for (int j = 1; j <= K; j++) {
                if (i+j > N) { break; }
                candidates.add(Math.abs(h[i] - h[i+j]) + dp[i+j]);
            }

            dp[i] = Collections.min(candidates);
        }

        // System.out.println(Arrays.toString(dp));

        System.out.println(dp[1]);
    }
}
