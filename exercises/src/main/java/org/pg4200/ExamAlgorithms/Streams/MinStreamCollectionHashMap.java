package org.pg4200.ExamAlgorithms.Streams;

import org.pg4200.les07.iterator.MyIterableHashMap;
import org.pg4200.les07.stream.MyStream;
import org.pg4200.les07.stream.MyStreamCollection;

public class MinStreamCollectionHashMap<K,V> extends MyIterableHashMap<K,V> implements MinStreamCollection<V> {

    @Override
    public MinStream<V> stream() {
        return MinStreamSupport.createStream(this);
    }
}
