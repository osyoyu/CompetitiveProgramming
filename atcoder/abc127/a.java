import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int answer;
        if (A <= 5) {
            answer = 0;
        }
        else if (A <= 12) {
            answer = B / 2;
        }
        else {
            answer = B;
        }

        System.out.println(answer);
    }
}
