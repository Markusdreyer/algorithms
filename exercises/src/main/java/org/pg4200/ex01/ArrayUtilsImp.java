package org.pg4200.ex01;

public class ArrayUtilsImp implements ArrayUtils{

    @Override
    public int min(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int lowestValue = array[0];
        for (int item : array) {
            if(item < lowestValue) {
                lowestValue = item;
            }
        }

        return lowestValue;
    }

    @Override
    public int max(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int highestValue = array[0];
        for (int item : array) {
            if(item > highestValue) {
                highestValue = item;
            }
        }

        return highestValue;
    }

    @Override
    public double mean(int[] array) throws IllegalArgumentException {
        checkArray(array);

        int averageValue = array[0];
        for (int item : array) {
            averageValue += item;
        }

        return averageValue / array.length;
    }

    private void checkArray(int[] array) {
        if (array == null || array.length == 0 ) {
            throw new IllegalArgumentException();
        }
    }


}
