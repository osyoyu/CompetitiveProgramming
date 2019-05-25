import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] gates = new int[2][M];

        for (int i = 0; i < M; i++) {
            gates[0][i] = sc.nextInt();
            gates[1][i] = sc.nextInt();
        }

        Arrays.sort(gates, (a, b) -> Integer.compare(a[0], b[0]));

        int ansLeft = Integer.MIN_VALUE;
        int ansRight = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            ansLeft = Math.max(ansLeft, gates[0][i]);
            ansRight = Math.min(ansRight, gates[1][i]);
        }

        System.out.println(Math.max(0, ansRight - ansLeft + 1));
    }
}
