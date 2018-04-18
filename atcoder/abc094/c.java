import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int list[] = new int[n];
        int sortedList[] = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
            sortedList[i] = list[i];
        }

        Arrays.sort(sortedList);

        int median_l = sortedList[n / 2 - 1];
        int median_r = sortedList[n / 2];

        for (int i = 0; i < n; i++) {
            if (list[i] > median_l) {
                System.out.println(median_l);
            }
            else {
                System.out.println(median_r);
            }
        }
    }
}
