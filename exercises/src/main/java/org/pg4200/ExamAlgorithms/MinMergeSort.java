package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;

/**
 * {@link org.pg4200.les04.sort.MergeSort}
 */


public class MinMergeSort implements MySort {


    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergesort(0, array.length - 1, array, buffer);
    }

    public <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {
        if(low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;

        mergesort(low, middle, array, buffer);
        mergesort(middle +1, high, array, buffer);
        merge(low, middle, high, array, buffer);
    }

    public<T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer ) {
        for(int i = low;  i <= high; i++) {
            buffer[i] = array[i];
        }

        int beforeMiddle = low;
        int afterMiddle = middle + 1;

        for(int i = low; i <= high; i++) {
            if(beforeMiddle > middle){

                array[i] = buffer[afterMiddle++];
            } else if (afterMiddle > high) {

                array[i] = buffer[beforeMiddle++];
            } else if(buffer[afterMiddle].compareTo(buffer[beforeMiddle]) < 0) {
                array[i] = buffer[afterMiddle++];
            } else {
                array[i] = buffer[beforeMiddle++];
            }
        }
    }
}
