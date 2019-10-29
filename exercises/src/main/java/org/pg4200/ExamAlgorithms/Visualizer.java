package org.pg4200.ExamAlgorithms;

import org.pg4200.les04.sort.MergeSort;
import org.pg4200.les04.sort.QuickSort;

import java.util.Arrays;

public class Visualizer {

    public static void main(String[] args) {
        MinQuickSort quickSort = new MinQuickSort();
        Integer[] array = {0, 1, 2};

        quickSort.sort(array);

        System.out.println(Arrays.deepToString(array));

    }

}
