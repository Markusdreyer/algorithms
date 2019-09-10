package org.pg4200.ex04;

import org.pg4200.les03.sort.MySort;

public class MixedSort implements MySort {

    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        T[] buffer = (T[]) new Comparable[array.length];

        mergeSort(array, buffer, 0, array.length - 1);
    }

    public <T extends Comparable<T>> void mergeSort(T[] array, T[] buffer, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, buffer, leftStart, middle); //Sort left half
        mergeSort(array, buffer, middle + 1, rightEnd); // Sort right half
        merge(array, buffer, leftStart, middle, rightEnd);
    }

    public <T extends Comparable<T>> void merge(T[] array, T[] buffer, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;

        for(int k = low; i <= high; i++) {
            buffer[k] = array[k];
        }

        for(int k = low; k <= high; k++ ) {
            if(i > middle ) {
                array[k] = buffer[j++];
            } else if(j > high) {
                array[k] = buffer[i++];
            } else if(buffer[j].compareTo(buffer[i]) < 0) {
                array[k] = buffer[j];
            } else {
                array[k] = buffer[i++];
            }
        }
    }
}
