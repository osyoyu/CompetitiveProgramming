import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class SortedList<E> extends AbstractList<E> {

    private ArrayList<E> internalList = new ArrayList<E>();

    // Note that add(E e) in AbstractList is calling this one
    public void add2(E e) {
        internalList.add(e);
        Collections.sort(internalList, null);
    }

    @Override
    public E get(int i) {
        return internalList.get(i);
    }

    @Override
    public int size() {
        return internalList.size();
    }

}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt();

        SortedList<Integer> as = new SortedList<>();
        long bs = 0;


        for (int i = 0; i < F; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                as.add2(a);
                bs += b;
            }
            else {
                int minX = as.get(as.size()/2);
                long sum = bs;
                for (int j = 0; i < as.size(); j++) {
                    sum += Math.abs(minX - as.get(j));
                }

                System.out.print(minX);
                System.out.print(" ");
                System.out.println(sum);
            }
        }
    }
}
