package org.pg4200.ExamAlgorithms;

import org.pg4200.les04.sort.MergeSort;

import java.util.Arrays;

public class Visualizer  {

    public static void main(String[] args) {
         MergeSort sorter = new MergeSort();

        Integer[] array = {7, 6, 3, 9, 5};

        sorter.sort(array);

        System.out.println(Arrays.deepToString(array));
    }
}
