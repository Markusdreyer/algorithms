package org.pg4200.ex03;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    private static OptimizedBubbleSort sorter = new OptimizedBubbleSort();

    private static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    public static void main(String[] args) {
        String[] array = {"c", "b", "a", "d", "e", "f"};
        System.out.println(sorter.sort(array, new StringComparator(), false));
        System.out.println(Arrays.deepToString(array));


    }
}
