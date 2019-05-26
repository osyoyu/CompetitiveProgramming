import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static boolean[] toBits(int number, int length) {
        boolean[] bits = new boolean[length];
        for (int i = 0; i < length; i++) {
            bits[length-1-i] = (1 << i & number) != 0;
        }
        return bits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> bulbs = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            List<Integer> bulb = new ArrayList<>();

            int K = sc.nextInt();
            for (int j = 0; j < K; j++) {
                bulb.add(sc.nextInt()-1);
            }

            bulbs.add(bulb);
        }

        // System.out.println(bulbs.toString());

        int[] P = new int[M];
        for (int i = 0; i < M; i++) {
            P[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 0; i < (int)Math.pow(2, N); i++) {
            boolean[] bits = toBits(i, N);

            boolean allOn = true;
            for (int j = 0; j < M; j++) {
                int num = 0;
                for (Integer sw : bulbs.get(j)) {
                    if (bits[sw]) { num++; }
                }
                if (num % 2 != P[j]) {
                    allOn = false;
                    break;
                }
            }

            if (allOn) { answer++; }
        }

        System.out.println(answer);
    }
}
