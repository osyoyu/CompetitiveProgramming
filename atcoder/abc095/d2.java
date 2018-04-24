import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 2;     // N[0] と N[-1] == 0
        long C = sc.nextLong();
        long costs[] = new long[N];   // x_i
        int values[] = new int[N];    // v_i
        for (int i = 1; i < N - 1; i++) {
            costs[i] = sc.nextLong();
            values[i] = sc.nextInt();
        }
        costs[N-1] = C;
        sc.close();

        long cw_values_accum[] = new long[N];
        long ccw_values_accum[] = new long[N];
        for (int i = 1; i < N; i++) {
            cw_values_accum[i] = cw_values_accum[i-1] + values[i];
            ccw_values_accum[i] = ccw_values_accum[i-1] + values[(N-1)-i];
        }
        // System.out.println(Arrays.toString(cw_values_accum));
        // System.out.println(Arrays.toString(ccw_values_accum));

        long cw_score_max1[] = new long[N];
        long cw_score_max2[] = new long[N];
        for (int i = 1; i < N; i++) {
            cw_score_max1[i] = Math.max(cw_score_max1[i-1], cw_values_accum[i] - costs[i]);
            cw_score_max2[i] = Math.max(cw_score_max2[i-1], cw_values_accum[i] - costs[i]*2);
        }
        // System.out.println(Arrays.toString(cw_score_max1));
        // System.out.println(Arrays.toString(cw_score_max2));

        long score_max = 0;
        for (int i = 0; i < N-1; i++) {
            long ccw_first = ccw_values_accum[i] - (C - costs[(N-1)-i])*2 + cw_score_max1[(N-1)-i-1];
            long cw_first  = ccw_values_accum[i] - (C - costs[(N-1)-i])   + cw_score_max2[(N-1)-i-1];
            if (cw_first >= score_max) { score_max = cw_first; }
            if (ccw_first >= score_max) { score_max = ccw_first; }
        }

        System.out.println(score_max);
    }
}
