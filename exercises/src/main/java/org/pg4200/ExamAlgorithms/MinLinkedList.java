package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.list.MyList;

/**
 * {@link org.pg4200.les02.list.MyLinkedList}
 */


public class MinLinkedList<T> implements MyList<T> {

    private class ListNode {
        T value;
        ListNode next;
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    @Override
    public void delete(int index) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode node = new ListNode();
        node.value = value;


        if(head == null) {
            if(head.next != null) {
                head = head.next;
            } else {
                head = node;
                tail = node;
            }
        } else if(index == 0) {

            head = node;
        }

        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
