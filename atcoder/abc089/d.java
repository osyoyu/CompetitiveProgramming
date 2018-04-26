import java.lang.Math;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Pair {
    public final int x;
    public final int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    static Map<Integer, Pair> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int D = sc.nextInt();
        map = new HashMap<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map.put(sc.nextInt(), new Pair(i, j));
            }
        }

        // 累積和
        long costs[][] = new long[D][H*W/D+1];
        for (int i = 0; i < D; i++) {
            costs[i][0] = 0;
            for (int j = 1; j < H*W/D+1; j++) {
                costs[i][j] = costs[i][j-1] + singleHopCost(i+(j-1)*D, i+j*D);
            }
            // System.out.println(Arrays.toString(costs[i]));
        }

        int Q = sc.nextInt();
        for (int q = 0; q < Q; q++) {
            int START = sc.nextInt();
            int GOAL = sc.nextInt();
            int lg = Math.max(START, GOAL);
            int sm = Math.min(START, GOAL);
            // System.out.println(Arrays.toString(costs[0]));

            long answer = costs[lg%D][lg/D] - costs[lg%D][sm/D];  // lg%D == sm%D
            System.out.println(answer);
        }
    }

    public static Integer singleHopCost(int l, int r) {
        if (l == 0) { return 0; }
        Pair lPoint = map.get(l);
        Pair rPoint = map.get(r);

        if (lPoint == null || rPoint == null) { return 0; }

        return Math.abs(lPoint.x - rPoint.x) + Math.abs(lPoint.y - rPoint.y);
    }
}
