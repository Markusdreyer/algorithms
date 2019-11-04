package org.pg4200.ExamAlgorithms;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapWithListsTest;

public class MinHashMapWithListsTest extends MyHashMapWithListsTest {
    @Override
    protected <K, V> MyHashMap<K, V> getInstance() {
        return new MinHashMapWithLists<>();
    }

}
