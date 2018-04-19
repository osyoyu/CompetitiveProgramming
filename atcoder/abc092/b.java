import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int X = sc.nextInt();

        int sum = X;

        for (int i = 0; i < N; i++) {
            int A_n = sc.nextInt();
            sum += ((D - 1) / A_n) + 1;
        }

        System.out.println(sum);
    }
}
