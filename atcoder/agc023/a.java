import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Main {
    public static int combination(int n, int k) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < k; i++) {
            a *= n - i;
            b *= k - i;
        }
        return (a / b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();

        // 累積和
        Map<Integer, Integer> sums = new HashMap<>();
        int currentSum = 0;
        for (int i = 0; i < N; i++) {
            currentSum += A[i];
            int count = sums.getOrDefault(currentSum, 0) + 1;
            sums.put(currentSum, count);
        }

        int answer = 0;
        for (Map.Entry<Integer, Integer> entry : sums.entrySet()) {
            answer += combination(entry.getValue(), 2);
        }

        System.out.println(answer);
    }
}
