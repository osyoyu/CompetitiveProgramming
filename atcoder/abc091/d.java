import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int list1[] = new int[N];
        int list2[] = new int[N];

        for (int i = 0; i < N; i++) {
            list1[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            list2[i] = sc.nextInt();
        }

        List<Integer> sums = new ArrayList<>();
        for (int a : list1) {
            for (int b : list2) {
                sums.add(a + b);
            }
        }

        throw new java.lang.RuntimeException("RE");
    }
}
