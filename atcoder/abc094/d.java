import java.lang.Math;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> a = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        int answer_n = a.last();
        a.remove(a.last());

        int answer_r = 0;
        if (a.size() == 1) {
            answer_r = a.first();
        }
        else {
            int middle = answer_n / 2;
            int f = a.floor(middle);
            int c = a.ceiling(middle);

            int df = Math.abs(f - middle);
            int dc = Math.abs(c - middle);
            if (df == dc) {
                answer_r = c;
            }
            else {
                answer_r = df < dc ? f : c;
            }
        }

        System.out.println(answer_n + " " + answer_r);
    }
}
