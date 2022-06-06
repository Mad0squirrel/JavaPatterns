package Task1;

import java.lang.Math;

public class Main implements Comparator<Integer> {

    public static void main(String[] args) {
        Comparator<Integer> comparator = (a, b) -> Integer.compare(Math.abs(a), Math.abs(b));
        System.out.println(comparator.compare(11, -11));
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
