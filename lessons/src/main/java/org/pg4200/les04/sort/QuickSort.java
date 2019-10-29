package org.pg4200.les04.sort;

// WARNING: this is one of the 12 classes you need to study and know by heart


import org.pg4200.les03.sort.MySort;

/**
 * Created by arcuri82 on 21-Aug-17.
 */
public class QuickSort implements MySort {


    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        if(array == null){
            return;
        }

        quicksort(0, array.length-1, array);
    }

    private <T extends Comparable<T>> void quicksort(int low, int high, T[] array) {

        int currentlLow = low;
        int currentHigh = high;

        /*
            Choice of pivot is critical for the performance
            of the algorithm.
            Another option here would be to take it at random.
         */
        T pivot = array[low + (high-low)/2];

        while (currentlLow <= currentHigh) {

            //Sjekker at alt fra low til pivot er sortert
            while (array[currentlLow].compareTo(pivot) < 0) {
                currentlLow++;
            }

            //Sjekker at alt fra high til pivot er sortert
            while (array[currentHigh].compareTo(pivot) > 0) {
                currentHigh--;
            }

            //Bytter plass på elementer som er usortert
            if (currentlLow <= currentHigh) {
                T tmp = array[currentlLow];
                array[currentlLow] = array[currentHigh];
                array[currentHigh] = tmp;
                currentlLow++;
                currentHigh--;
            }
        }

        if (currentHigh > low) {
            quicksort(low, currentHigh, array);
        }

        if (currentlLow < high) {
            quicksort(currentlLow, high, array);
        }
    }
}
