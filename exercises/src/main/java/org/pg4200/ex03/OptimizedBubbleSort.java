package org.pg4200.ex03;

import java.util.Comparator;

public class OptimizedBubbleSort {

    public <T> int sort(T[] array, Comparator<T> comparator, boolean optimized) {
        int numberOfComparisons = 0;
        boolean swapped = true;
        int limit = array.length - 1;
        int lastSwap = limit;

        while(swapped) {
            swapped = false;

            if(optimized) {
                limit = lastSwap;
            }

            for(int i = 0; i < limit; i++) {
                numberOfComparisons++;

                if(comparator.compare((array[i]), array[i+1]) > 0) {
                    T tmp;
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                    lastSwap = i;
                }
            }
        }
        return numberOfComparisons;
    }
}
