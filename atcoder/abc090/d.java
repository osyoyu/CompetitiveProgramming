import java.lang.Math;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();

    long answer = 0;
    for (int b = K+1; b <= N; b++) {
      answer += (N/b) * (b-K) + Math.max(0, (N%b-K+1));
    }

    if (K == 0) { answer -= N; }

    System.out.println(answer);
  }
}
