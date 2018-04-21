import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

class Point implements Comparable {
    public Integer x;
    public Integer y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println(x + ", " + y);
    }

    @Override
    public int compareTo(Object o) {
        Point p = (Point) o;

        if (x.equals(p.x)) {
            return y.compareTo(p.y);
        }
        else {
            return x.compareTo(p.x);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Point> reds = new ArrayList<>();
        List<Point> blues = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            reds.add(new Point(x, y));
        }

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            blues.add(new Point(x, y));
        }

        for (Point red : reds) {
            TreeMap<Point, double> distances =
            for (Point blue : blues) {
                if (!isNakayoshi(red, blue)) return;
            }
        }

        // Collections.sort(reds, Collections.reverseOrder());
        // Collections.sort(blues, Collections.reverseOrder());

        // int answer = 0;

        // Iterator<Point> it = reds.iterator();
        // while (it.hasNext()) {
        //     Point red = it.next();

        //     for (int j = 0; j < blues.size(); j++) {
        //         if (isNakayoshi(red, blues.get(j))) {
        //             answer++;
        //             blues.remove(blues.get(j));
        //             break;
        //         }
        //     }
        // }

        System.out.println(answer);
    }

    public static boolean isNakayoshi(Point red, Point blue) {
        return (red.compareTo(blue) == -1);
    }
}
