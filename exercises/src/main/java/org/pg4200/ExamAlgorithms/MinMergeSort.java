package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;

public class MinMergeSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergesort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {
        if(high <= low) {
            return;
        }

        int middle = low + (high - low) / 2;
        mergesort(low, middle, array, buffer);
        mergesort(middle + 1, high, array, buffer);
        merge(low, middle, high, array, buffer);
    }

    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {
        int beforeMiddle = low;
        int afterMiddle = middle + 1;

        for(int k = low; k <= high; k++) {
            buffer[k] = array[k];
        }

        for(int k = low; k <= high; k++) {
            if(beforeMiddle > middle) {
                array[k] = buffer[afterMiddle++];
            } else if(afterMiddle > high) {
                array[k] = buffer[beforeMiddle++];
            } else if(buffer[afterMiddle].compareTo(buffer[beforeMiddle]) < 0) {
                array[k] = buffer[afterMiddle++];
            } else {
                array[k] = buffer[beforeMiddle++];
            }
        }
    }
}
