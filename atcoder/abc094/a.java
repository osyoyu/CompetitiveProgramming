import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int x = sc.nextInt();

    if ((x - a) >= 0 && (x - a) <= b) {
      System.out.println("YES");
    }
    else {
      System.out.println("NO");
    }
  }
}
