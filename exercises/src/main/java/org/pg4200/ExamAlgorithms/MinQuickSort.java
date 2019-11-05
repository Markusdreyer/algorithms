package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;

/**
 * {@link org.pg4200.les04.sort.QuickSort}
 */


public class MinQuickSort implements MySort {


    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null) {
            return;
        }

        quicksort(0, array.length - 1, array);
    }

    private <T extends  Comparable<T>> void quicksort(int low, int high, T[] array) {
        int currentLow = low;
        int currentHigh = high;

        T pivot = array[low + (high - low) / 2];

        while(currentLow <= currentHigh) {
            while(array[currentLow].compareTo(pivot) < 0) {
                currentLow++;
            }

            while(array[currentHigh].compareTo(pivot) > 0) {
                currentHigh--;
            }

            if(currentLow <= currentHigh) {
                T tmp = array[currentLow];
                array[currentLow] = array[currentHigh];
                array[currentHigh] = tmp;
                currentLow++;
                currentHigh--;

            }
        }

        if(currentHigh > low) {
            quicksort(low, currentHigh, array);
        }

        if(currentLow < high) {
            quicksort(currentLow, high, array);
        }

    }
}
