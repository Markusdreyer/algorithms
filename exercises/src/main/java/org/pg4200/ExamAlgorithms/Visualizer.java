package org.pg4200.ExamAlgorithms;

import java.util.Arrays;

public class Visualizer  {

    public static void main(String[] args) {
        MinInsertionSort insertionSort = new MinInsertionSort();

        Integer[] array = {7, 6, 3, 9, 5};

        insertionSort.sort(array);

        System.out.println(Arrays.deepToString(array));
    }
}
