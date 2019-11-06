package org.pg4200.ExamAlgorithms.Streams;

import org.pg4200.les07.iterator.MyIterableLinkedList;
import org.pg4200.les07.stream.MyStream;
import org.pg4200.les07.stream.MyStreamCollection;

public class MinStreamCollectionList<T> extends MyIterableLinkedList<T> implements MinStreamCollection<T> {

    @Override
    public MinStream<T> stream() {
        return MinStreamSupport.createStream(this);
    }
}

