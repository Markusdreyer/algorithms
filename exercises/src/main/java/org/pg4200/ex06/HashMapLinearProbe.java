package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapWithLists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HashMapLinearProbe<K,V> implements MyHashMap {
    private final int M = 10_000_000;
    private int size = 0;

    private class Entry{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);


    @Override
    public void put(Object key, Object value) {
        int i = index(key);

        //if there is nothing on the index, then its okey to add new value
        if(data[i] == null){
            data[i] = new HashMapLinearProbe.Entry(key, value);
            size++;
            return;
        }


        //check if key already exist and overwrite
        if(data[i].key != null || key.equals(data[i].key)){
            data[i].value = (V) value;
            return;
        }


        //if we get this far, it means that the index is already occupied by another key and we have to find new index
        for(int j = i+1; j < size(); j++) {
            if(data[j].key == null) {
                data[j] = new HashMapLinearProbe.Entry(key, value);
                size++;
            }
        }
    }

    private int index(Object key){
        int positiveHash = key.hashCode() & 0xfffffff;
        return positiveHash % M;
    }

    @Override
    public void delete(Object key) {
        int i = index(key);

        if(data[i] == null){
            return;
        }


        if(key.equals(data[i].key)){
            data[i].key = null;
            size--;
            return;
        }
    }

    @Override
    public Object get(Object key) {
        int i = index(key);

        if(data[i] == null){
            return null;
        }

        if(data[i].key == null) {
            return null;
        }

        return data[i].value;
    }

    @Override
    public int size() {
        return this.size;
    }
}
