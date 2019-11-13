package org.pg4200.ExamAlgorithms;

import com.sun.source.tree.Tree;
import org.pg4200.les05.MyMapTreeBased;

/**
 * {@link org.pg4200.les05.MyMapBinarySearchTree}
 */

public class MinMapBinarySearchTree<K extends Comparable<K>, V> implements MyMapTreeBased<K,V> {


    @Override
    public int getMaxTreeDepth() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public void delete(K key) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
