import java.util.Scanner;

import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] V = new int[N];

        List<Integer> lefts = new ArrayList<>();
        List<Integer> rights = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int currentL = Math.min(N, K) - 1;
            int currentR = N;

            while (currentL != currentR) {
                lefts.add(currentL);
                rights.add(currentR);
                currentL--;
                currentR--;
                if (currentL == -1) { break; }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < lefts.size(); i++) {
            int[] subaryL, subaryR;
            int left = lefts.get(i);
            int right = rights.get(i);

            if (left > 0) {
                subaryL = Arrays.copyOfRange(V, 0, left-1);
            }
            else {
                subaryL = new int[0];
            }

            if (right < N) {
                subaryR = Arrays.copyOfRange(V, right, N);
            }
            else {
                subaryR = new int[0];
            }

            int[] ary = new int[subaryL.length+subaryR.length];
            System.arraycopy(subaryL, 0, ary, 0, subaryL.length);
            System.arraycopy(subaryR, 0, ary, subaryL.length, subaryR.length);
            ArrayList<Integer> aryls = new ArrayList<Integer>();
            for (int x : ary) {
                aryls.add(x);
            }
            int rem = (K - aryls.size()) / 2;
            for (int j = 0; j < rem; j++) {
                aryls.remove(0);
            }
            answer = Math.max(answer, aryls.stream().mapToInt(Integer::intValue).sum());
        }


        System.out.println(answer);
    }
}
