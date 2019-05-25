import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[][] rewrites = new int[M][2];  // [num, target]

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            rewrites[i][0] = sc.nextInt();
            rewrites[i][1] = sc.nextInt();
        }

        // reverse
        Arrays.sort(A);
        Arrays.sort(rewrites, (a, b) -> -Integer.compare(a[1], b[1]));

        // System.out.println(Arrays.deepToString(rewrites));

        long answer = 0;
        int pos = 0;
        for (int i = 0; i < M; i++) {
            boolean breakOuter = false;
            for (int j = 0; j < rewrites[i][0]; j++) {
                if (pos >= A.length) {
                    breakOuter = true;
                    break;
                }

                if (rewrites[i][1] > A[pos]) {
                    answer += rewrites[i][1];
                    pos++;
                }
                else {
                    breakOuter = true;
                    break;
                }
            }
            if (breakOuter) { break; }
        }

        for (int i = pos; i < A.length; i++) {
            answer += A[i];
        }

        System.out.println(answer);
    }
}
