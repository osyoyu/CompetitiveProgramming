import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int board[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int h_answer = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) { answer++; continue; }

            // i が N の約数でないならスキップ
            if (N % i != 0) { answer++; continue}
        }

        System.out.println(answer);
    }
}
