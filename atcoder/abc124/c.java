import java.lang.Integer;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        Integer[] tiles = Stream.of(S.split("")).map(Integer::valueOf).toArray(Integer[]::new);

        if (tiles.length == 1) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        for (int i = 1; i < tiles.length; i++) {
            // flip if next tile has the same color
            if (tiles[i] == tiles[i-1]) {
                answer++;

                switch (tiles[i]) {
                case 0:
                    tiles[i] = 1;
                    break;
                case 1:
                    tiles[i] = 0;
                    break;
                }
            }
        }

        System.out.println(Math.min(answer, tiles.length-answer));
    }
}
