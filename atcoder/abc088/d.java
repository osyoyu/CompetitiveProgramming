import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayDeque;

class Square implements Comparable {
    public int x;
    public int y;
    public int cost;

    public Square(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public int compareTo(Object o) {
        Square s = (Square)o;
        return (cost > s.cost) ? 1 : (cost < s.cost) ? -1 : 0;
    }
}

class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int H;
    static int W;
    static int grid[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        grid = new int[H][W];

        Square squares[][] = new Square[H][W];
        Queue<Square> queue = new ArrayDeque<>(H*W);

        int blacks = 0;

        for (int i = 0; i < H; i++) {
            String n = sc.next();
            for (int j = 0; j < W; j++) {
                char nn = n.charAt(j);
                if (nn == '.') {
                    squares[i][j] = new Square(i, j, Integer.MAX_VALUE);

                }
                else {
                    blacks++;
                }
            }
        }
        squares[0][0].cost = 0;
        queue.add(squares[0][0]);

        // BFS
        while (true) {
            Square s = queue.poll();
            if (s == null) { break; }

            for (int i = 0; i < 4; i++) {
                int nx = s.x + dx[i];
                int ny = s.y + dy[i];

                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    Square next = squares[nx][ny];
                    if (next != null && next.cost == Integer.MAX_VALUE) {
                        // System.out.println("(x, y) = " + nx + ", " + ny);
                        next.cost = s.cost + 1;
                        queue.offer(next);
                    }
                }
            }
        }

        if (squares[H-1][W-1].cost == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(H*W - squares[H-1][W-1].cost - blacks - 1);
        }
    }
}
