import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int D = sc.nextInt();
        int X = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            X = R * X - D;
            System.out.println(X);
        }
    }
}
