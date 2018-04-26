import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grid[][] = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 横方向を見る
        for (int i = 0; i < 2; i++) {
            int a = (grid[i][0] - grid[i+1][0]);
            int b = (grid[i][1] - grid[i+1][1]);
            int c = (grid[i][2] - grid[i+1][2]);
            if (a != b || b != c) { System.out.println("No"); return; }
        }

        // 横方向を見る
        for (int i = 0; i < 2; i++) {
            int a = (grid[0][i] - grid[0][i+1]);
            int b = (grid[1][i] - grid[1][i+1]);
            int c = (grid[2][i] - grid[2][i+1]);
            if (a != b || b != c) { System.out.println("No"); return; }
        }

        System.out.println("Yes");
    }
}
