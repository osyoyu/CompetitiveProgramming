import java.lang.Math;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int points[] = new int[N+2];
        points[0] = 0;
        points[N + 1] = 0;  // last
        int costs[] = new int[N+1];

        for (int i = 1; i < N + 1; i++) {
            points[i] = sc.nextInt();
        }

        for (int i = 0; i < costs.length; i++) {
            costs[i] = Math.abs(points[i] - points[i+1]);
        }

        int cost_sum = IntStream.of(costs).sum();
        for (int i = 0; i < N; i++) {
            System.out.println(cost_sum + Math.abs(points[i] - points[i+2]) - costs[i] - costs[i+1]);
        }
    }
}
