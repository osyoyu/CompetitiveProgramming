    import java.lang.Math;
    import java.util.Scanner;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.stream.*;

    class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int A = sc.nextInt();  // white, '.', false
            int B = sc.nextInt();  // black, '#', true
            boolean map[] = new boolean[99*49];

            Arrays.fill(map, false);

            for (int i = 99*25; i < 99*49; i++) {
                map[i] = true;
            }

            for (int i = 0; i < A - 1; i++) {
                map[i*2] = true;
            }

            for (int i = 0; i < B - 1; i++) {
                map[99*49 - i*2 - 1] = false;
            }

            String whiteLine = "...................................................................................................";
            String blackLine = "###################################################################################################";

            System.out.println("98 99");
            for (int i = 0; i < 49; i++) {
                for (int j = 0; j < 99; j++) {
                    System.out.print(map[i*99 + j] ? "." : "#");
                }
                System.out.println("");
                if (i < 25) {
                    System.out.println(blackLine);
                }
                else {
                    System.out.println(whiteLine);
                }
            }
        }
    }
