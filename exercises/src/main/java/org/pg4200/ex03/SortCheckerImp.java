package org.pg4200.ex03;

public class SortCheckerImp implements SortChecker {
    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {

        if(original == null && sorted == null) {
            return true;
        }

        if(original == null || sorted == null) {
            return false;
        }

        if(original.length != sorted.length) {
            return false;
        }

        for(int i = 0; i < original.length; i++) {
            if(original[i] == null || sorted[i] == null) {
                return false;
            }
        }

        //unsorted
        for(int i = 0; i < sorted.length - 1; i++) {
            if(sorted[i].compareTo(sorted[i + 1]) > 0) {
                return false;
            }
        }

        //sorted
        for(int i = 0; i < sorted.length - 1; i++) {
            if(sorted[i].compareTo(sorted[i+1]) < 0) {
                return true;
            }
        }

        return true;
    }
}
