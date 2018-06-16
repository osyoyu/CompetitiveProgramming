import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] ary = new int[N];

        for (int i = 0; i < N; i++) {
            ary[i] = sc.nextInt();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            while (true) {
                if (ary[i] % 2 == 0) {
                    ary[i] /= 2;
                    answer += 1;
                }
                else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
