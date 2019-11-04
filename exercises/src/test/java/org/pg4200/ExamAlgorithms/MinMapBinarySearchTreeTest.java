package org.pg4200.ExamAlgorithms;

import org.pg4200.ex05.BinaryTreeLeftMaxDelete;
import org.pg4200.les05.MyMapBinarySearchTreeTest;
import org.pg4200.les05.MyMapTreeBased;

public class MinMapBinarySearchTreeTest extends MyMapBinarySearchTreeTest {

    @Override
    protected <K extends Comparable<K>, V> MyMapTreeBased<K, V> getTreeInstance() {
        return new MinMapBinarySearchTree<>();
    }
}
