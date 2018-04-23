import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;
        long C = sc.nextLong();

        long costs[] = new long[N];   // x_i
        int values[] = new int[N];  // v_i
        costs[0] = 0;  // 初期位置
        values[0] = 0;

        for (int i = 1; i < N; i++) {
            costs[i] = sc.nextLong();
            values[i] = sc.nextInt();
        }

        // O(N^2) 解
        long value_accum[] = new long[N];
        long value_accum_rev[] = new long[N];
        value_accum[0] = 0;  // 初期位置
        value_accum_rev[0] = 0;
        for (int i = 1; i < N; i++) {
            value_accum[i] = value_accum[i-1] + values[i];
            value_accum_rev[i] = value_accum_rev[i-1] + values[N-i];
        }
        // System.out.println(Arrays.toString(values));
        // System.out.println(Arrays.toString(value_accum));
        // System.out.println(Arrays.toString(value_accum_rev));

        // 全探索
        long score_max = 0;
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N-i; j++) {
                // System.out.println(i + ", " + j);

                // 時計回り側の価値・コスト
                long cw_value = value_accum[i];
                long cw_cost = costs[i];

                // 反時計周り
                long acw_value = value_accum_rev[j];
                long acw_cost = (j == 0) ? j : (C - costs[N-j]);
                // System.out.println("acw_value: " + acw_value);
                // System.out.println("acw_cost: " + acw_cost);

                // 時計回りに先に行く場合
                long score_cw = (cw_value - cw_cost * 2) + (acw_value - acw_cost);
                // System.out.println("score_cw: " + score_cw);

                // 反時計周り
                long score_acw = (cw_value - cw_cost) + (acw_value - acw_cost * 2);
                // System.out.println("score_acw: " + score_acw);

                if (score_cw >= score_max) { score_max = score_cw; }
                if (score_acw >= score_max) { score_max = score_acw; }
            }
        }

        System.out.println(score_max);
    }
}
