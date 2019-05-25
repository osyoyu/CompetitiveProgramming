import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt();

        List<Integer> as = new ArrayList<>();
        long bs = 0;


        for (int i = 0; i < F; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                as.add(a);
                bs += b;
            }
            else {
                Collections.sort(as);
                System.out.println(as);
                int x = (as.size % 2 == 0) ? as.size() / 2 - 1: as.size();
                int minX = as.get(x);
                long sum = bs;
                for (int a : as) {
                    sum += Math.abs(minX - a);
                }

                System.out.print(minX);
                System.out.print(" ");
                System.out.println(sum);
            }
        }
    }
}
