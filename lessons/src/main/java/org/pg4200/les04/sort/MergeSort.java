package org.pg4200.les04.sort;

// WARNING: this is one of the 12 classes you need to study and know by heart


import org.pg4200.les03.sort.MySort;

/**
 * Created by arcuri82 on 21-Aug-17.
 */
public class MergeSort implements MySort {


    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) {
            return;
        }

        T[] buffer = (T[]) new Comparable[array.length];

        mergesort(0, array.length - 1, array, buffer);
    }

    private <T extends Comparable<T>> void mergesort(int low, int high, T[] array, T[] buffer) {

        if (low >= high) {
            /*
                This means we are in a subarea of array with 1 or less elements.
                As such subarray is sorted by definition (ie less than 2 elements),
                we do not need to do anything
             */
            return;
        }

        int middle = low + (high - low) / 2;

        mergesort(low, middle, array, buffer);

        mergesort(middle + 1, high, array, buffer);

        merge(low, middle, high, array, buffer);
    }

    private <T extends Comparable<T>> void merge(int low, int middle, int high, T[] array, T[] buffer) {

        for (int i = low; i <= high; i++) {
            buffer[i] = array[i];
        }

        //index over the left half, before middle
        int beforeMiddle = low;

        //index over the right half, after middle
        int afterMiddle = middle + 1;

        for (int j = low; j <= high; j++) {
            if (beforeMiddle > middle) {
                //done with left half, just copy over the right
                array[j] = buffer[afterMiddle++];
            } else if (afterMiddle > high) {
                //done with right half, just copy over the left
                array[j] = buffer[beforeMiddle++];
            } else if (buffer[afterMiddle].compareTo(buffer[beforeMiddle]) < 0) {
                array[j] = buffer[afterMiddle++];
            } else {
                array[j] = buffer[beforeMiddle++];
            }
        }
    }
}