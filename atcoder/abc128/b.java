import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Rest {
    public int id;
    public String name;
    public int score;

    public Rest(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Rest> rests = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Rest r = new Rest(i+1, sc.next(), sc.nextInt());
            rests.add(r);
        }

        Collections.sort(rests, (a, b) -> -Integer.compare(a.score, b.score));
        Collections.sort(rests, (a, b) -> a.name.compareTo(b.name));

        for (Rest r : rests) {
            System.out.println(r.id);
        }
    }
}
