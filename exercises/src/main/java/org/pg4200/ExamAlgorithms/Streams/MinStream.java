package org.pg4200.ExamAlgorithms.Streams;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface MinStream<T> {

    /**
     * Pipeline current stream into a new stream where elements are skipped
     * if they do not satisfy the given predicate
     */
    MinStream<T> filter(Predicate<T> predicate);

    /**
     * Pipeline current stream into a new stream where the input values of
     * type T are transformed into new values of type R, according to the
     * given mapping function.
     *
     * Note: the term "map" here is NOT related to the Map collection type.
     */
    <R> MinStream<R> map(Function<T, R> mapper);

    /**
     *  Pipeline current stream into a new stream where, for each input x
     *  coming from the current stream, a new stream of type R is opened,
     *  and all elements from such stream are propagated into the current
     *  stream.
     *  In other words, this is a way to flatten/combine k different streams
     *  into a single one.
     *
     *  Note: this is a bit tricky to grasp at first. Easier to understand
     *  it with some working examples.
     */
    <R> MinStream<R> flatMap(Function<T, MinStream<R>> mapper);

    /*
        Terminal Operations are what start the stream and retrieve
        all values from it.
      */

    /**
     *  For each value coming from the stream, execute the given action.
     */
    void forEach(Consumer<T> action);

    /**
     *  Create a list. Add all elements coming from the stream
     *  into this list.
     * @return
     */
    MinStreamCollectionList collectToList();
}
