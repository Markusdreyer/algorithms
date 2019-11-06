package org.pg4200.ExamAlgorithms.Streams;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MinStreamSupport {

    public static <T, C extends Iterable<T>> MinStream<T> createStream(C collection) {
        return new Pipeline<T, T, T>(collection.iterator());
    }


    protected static abstract class ChainedReference<IN, OUT> implements Consumer<IN> {
        protected final Consumer<OUT> downstream;

        public ChainedReference(Consumer<OUT> downstream){
            this.downstream = Objects.requireNonNull(downstream);
        }
    }

    protected static class Pipeline<IN, OUT, T> implements MinStream<OUT> {

        protected final Iterator<T> iterator;
        protected final Pipeline<?, IN, T> previousStage;
        protected final int depth;

        //This is for a new pipeline,
        //This is only pipeline directly called on the collection
        public Pipeline(Iterator<T> iterator) {
            this.iterator = iterator;
            this.previousStage = null;
            this.depth = 0;
        }

        //This is for pipeline with previousStages
        //This is called with output from previous pipe
        public Pipeline(Pipeline<?, IN, T> previousStage) {
            this.iterator = previousStage.iterator;
            this.previousStage = previousStage;
            this.depth = previousStage.depth + 1;
        }

        protected Consumer<T> chainAllConsumersInThePipeline(Consumer<OUT> consumer) {
            Objects.requireNonNull(consumer);

            Pipeline p = this;

            while(p.depth > 0) {
                consumer = p.chainConsumerToCurrentPipe(consumer);
                p = p.previousStage;
            }

            return (Consumer<T>) consumer;
        }

        protected ChainedReference<IN, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
            throw new IllegalStateException();
        }


        @Override
        public MinStream<OUT> filter(Predicate<OUT> predicate) {
            Objects.requireNonNull(predicate);

            return new Pipeline<OUT, OUT, T>(this) {
                @Override
                public ChainedReference<OUT, OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
                    return new ChainedReference<OUT, OUT>(consumer){
                        @Override
                        public void accept(OUT out) {
                            if(predicate.test(out)) {
                                downstream.accept(out);
                            }
                        }
                    };
                }
            };
        }

        @Override
        public <R> MinStream<R> map(Function<OUT, R> mapper) {
            Objects.requireNonNull(mapper);

            return new Pipeline<OUT, R, T>(this) {

                @Override
                public ChainedReference<OUT, R> chainConsumerToCurrentPipe(Consumer<R> consumer) {
                    return new ChainedReference<OUT, R>(consumer){

                        @Override
                        public void accept(OUT out) {
                            downstream.accept(mapper.apply(out));
                        }
                    };
                }
            };
        }

        @Override
        public <R> MinStream<R> flatMap(Function<OUT, MinStream<R>> mapper) {
            Objects.requireNonNull(mapper);

            return new Pipeline<OUT, R, T>(this) {

                @Override
                public ChainedReference<OUT, R> chainConsumerToCurrentPipe(Consumer<R> consumer) {
                    return new ChainedReference<OUT, R>(consumer) {
                        @Override
                        public void accept(OUT out) {

                            MinStream<R> result = mapper.apply(out);

                            if(result != null) {
                                result.forEach(downstream);
                            }
                        }
                    };
                }
            };
        }

        @Override
        public void forEach(Consumer<OUT> action) {
            Consumer<T> chain = chainAllConsumersInThePipeline(action);

            while(iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }

        }

        @Override
        public MinStreamCollectionList<OUT> collectToList() {
            MinStreamCollectionList<OUT> list = new MinStreamCollectionList<>();

            Consumer<OUT> collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    list.add(out);
                }
            };


            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while(iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }

            return list;
        }
    }


}
