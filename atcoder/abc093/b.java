import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> answers = new ArrayList<>(4);

        for (int i = a; i <= Math.min(b, a + k - 1); i++) {
            System.out.println(i);
        }
        for (int i = Math.max(a + k, b - k + 1); i <= b; i++) {
            System.out.println(i);
        }
    }
}
