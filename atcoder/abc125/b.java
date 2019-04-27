import java.lang.Math;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] V = new int[N];
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.max((V[i] - C[i]), 0);
        }

        System.out.println(answer);
    }
}
