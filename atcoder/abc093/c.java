import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] inputs = {a, b, c};
        Arrays.sort(inputs);

        int da = inputs[2] - inputs[0];
        int db = inputs[2] - inputs[1];

        if (da % 2 == 0 && db % 2 == 0) {  // even & even
            System.out.println((da / 2) + (db / 2));
        }
        else if (da % 2 == 1 && db % 2 == 1) {  // odd & odd
            System.out.println(((da - 1) / 2) + ((db - 1) / 2) + 1);
        }
        else {  // odd & even
            System.out.println((da / 2) + (db / 2) + 2);
        }
    }
}
