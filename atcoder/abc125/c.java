import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
      }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] rangeGCDFromFront = new int[N];
        int[] rangeGCDFromBack = new int[N];

        rangeGCDFromFront[0] = A[0];
        for (int i = 1; i < N; i++) {
            rangeGCDFromFront[i] = gcd(rangeGCDFromFront[i-1], A[i]);
        }
        rangeGCDFromBack[N-1] = A[N-1];
        for (int i = N-2; i >= 0; i--) {
            rangeGCDFromBack[i] = gcd(rangeGCDFromBack[i+1], A[i]);
        }

        // System.out.println(Arrays.toString(rangeGCDFromFront));
        // System.out.println(Arrays.toString(rangeGCDFromBack));

        int maxGCD = Math.max(rangeGCDFromFront[N-2], rangeGCDFromBack[1]);
        for (int i = 1; i < N-1; i++) {
            int gcd = gcd(rangeGCDFromFront[i-1], rangeGCDFromBack[i+1]);
            if (gcd > maxGCD) { maxGCD = gcd; }
        }

        System.out.println(maxGCD);
    }
}
