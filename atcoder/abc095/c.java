import java.lang.Math;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int answer = 0;
        if (A/2 + B/2 >= C) {
            if (X >= Y) {
                answer += C * Y * 2;  // 要求数が少ない方を先に充足させる
                if (A*(X-Y) < C*2*(X-Y)) {  // 要求数が多い方の要求数も, 少ない方の要求数だけ減っている
                    answer += A * (X-Y);
                }
                else {
                    answer += C*2 * (X-Y);
                }
            }
            else {
                answer += C * X * 2;
                if (B*(Y-X) < C*2*(Y-X)) {
                    answer += B * (Y-X);
                }
                else {
                    answer += C*2 * (Y-X);
                }
            }
        }
        else {
            answer += A * X + B * Y;
        }

        System.out.println(answer);
    }
}
