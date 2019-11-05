package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;

/**
 * {@link org.pg4200.les03.sort.InsertionSort}
 */


public class MinInsertionSort implements MySort {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null) {
            return;
        }

        for(int i = 1; i < array.length; i++) {

            for(int j = i - 1; j >= 0; j--) {
                if(array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
