package org.pg4200.ExamAlgorithms;

import org.pg4200.les07.stream.MyStream;
import org.pg4200.les07.stream.MyStreamCollectionList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MinStreamSupport {


    protected static class Pipeline<IN, OUT, T> implements MyStream<OUT> {

        @Override
        public MyStream<OUT> filter(Predicate<OUT> predicate) {
            return null;
        }

        @Override
        public <R> MyStream<R> map(Function<OUT, R> mapper) {
            return null;
        }

        @Override
        public <R> MyStream<R> flatMap(Function<OUT, MyStream<R>> mapper) {
            return null;
        }

        @Override
        public void forEach(Consumer<OUT> action) {

        }

        @Override
        public MyStreamCollectionList<OUT> collectToList() {
            return null;
        }
    }


}
