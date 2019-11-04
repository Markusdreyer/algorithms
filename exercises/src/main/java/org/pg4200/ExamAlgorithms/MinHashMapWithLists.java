package org.pg4200.ExamAlgorithms;

import org.pg4200.les06.hash.MyHashMap;
import java.util.ArrayList;
import java.util.List;

public class MinHashMapWithLists<K,V> implements MyHashMap<K, V> {

    private final int M = 10_000_000; //997
    private int size = 0;

    private class Entry{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry>[] data = new ArrayList[M];

    @Override
    public void put(K key, V value) {
        int i = index(key);

        if(data[i] == null) {
            data[i] = new ArrayList<>();
        }

        List<Entry> list = data[i];

        for(int j = 0; j < list.size(); j++){
            Entry entry = list.get(j);
            if(key.equals(entry.key)){
                entry.value = value;
                return;
            }
        }

        list.add(new Entry(key, value));
        size++;
    }

    private int index(K key) {
        int positiveHash = key.hashCode() & 0x7f_ff_ff_ff;
        return positiveHash % M;
    }

    @Override
    public void delete(K key) {
        int i = index(key);

        if(data[i] == null) {
            return;
        }

        List<Entry> list = data[i];

        for(int j = 0; j < list.size(); j++) {
            Entry entry = list.get(j);
            if(key.equals(entry.key)){
                list.remove(j);
                size--;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int i = index(key);

        if(data[i] == null) {
            return null;
        }

        List<Entry> list = data[i];

        for(int j = 0; j < list.size(); j++) {
            Entry entry = list.get(j);
            if(key.equals(entry.key)) {
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
