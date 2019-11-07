package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.list.MyLinkedList;

public class Visualizer {

    public static void main(String[] args) {
        MinLinkedList list = new MinLinkedList();

        list.add(0, "Hei");
        list.add(1, "på");
        list.add(2, "deg");

        list.delete(0);

        System.out.println(list.get(1));
    }
}
