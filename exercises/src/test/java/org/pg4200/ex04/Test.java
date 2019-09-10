package org.pg4200.ex04;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        Integer[] array = {4, 6, 1, 7, 0, 2};
        MixedSort mixedSort = new MixedSort();

        mixedSort.sort(array);
        System.out.println(Arrays.deepToString(array));
    }
}
