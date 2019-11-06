package org.pg4200.ExamAlgorithms.Streams;


public interface MinStreamCollection<T> extends Iterable<T> {

    MinStream<T> stream();
}