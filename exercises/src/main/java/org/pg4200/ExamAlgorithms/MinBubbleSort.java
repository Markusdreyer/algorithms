package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;

/**
 * {@link org.pg4200.les03.sort.BubbleSort}
 */


public class MinBubbleSort implements MySort {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null) {
            return;
        }

        boolean swapped = true;

        while(swapped) {

            swapped = false;

            for(int i = 0; i < array.length -1; i++) {
                if(array[i].compareTo(array[i + 1]) > 0) {
                    T temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
}
