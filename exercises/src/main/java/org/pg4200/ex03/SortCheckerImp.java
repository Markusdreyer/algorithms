package org.pg4200.ex03;

public class SortCheckerImp implements SortChecker {
    @Override
    public <T extends Comparable<T>> boolean isSortedCopy(T[] original, T[] sorted) {
        return true;
    }
}
