import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int board[][] = new int[2][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 上は左側からの累積和, 下は右側からの累積和を取っておく
        int sumUp[] = new int[N];
        sumUp[0] = board[0][0];
        for (int i = 1; i < N; i++) {
            sumUp[i] = sumUp[i-1] + board[0][i];
        }
        int sumDown[] = new int[N];
        sumDown[N-1] = board[1][N-1];
        for (int i = N-2; i >= 0; i--) {
            sumDown[i] = sumDown[i+1] + board[1][i];
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, (sumUp[i] + sumDown[i]));
        }

        System.out.println(answer);
    }
}
