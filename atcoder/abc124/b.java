import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] mountains = new int[N];
        for (int i = 0; i < N; i++) {
            mountains[i] = sc.nextInt();
        }

        int answer = 0;

        int highest = 0;
        for (int i = 0; i < N; i++) {
            if (highest <= mountains[i]) {
                answer++;
                highest = mountains[i];
            }
        }

        System.out.println(answer);
    }
}
