package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.list.MyList;

/**
 * {@link org.pg4200.les02.list.MyLinkedList}
 */


public class MinLinkedList<T> implements MyList<T> {

    private class ListNode{
        T value;
        ListNode next;
    }

    /**
     * The first element in the list
     */
    private ListNode head;

    /**
     *  The last element in the list
     */
    private ListNode tail;

    /**
     *  The number of elements contained in this container
     */
    private int size;

    @Override
    public void delete(int index) {
        int counter = index - 1;
        ListNode previous = head; //starts at head

        if(index == 0) {
            if(head.next != null) {
                head = head.next;
            } else {
                //no more items in list
                head = null;
                tail = null;
            }
        } else {
            while(counter > 0) {
                previous = previous.next;
                counter--;
            }

            previous.next = previous.next.next;
        }

        size--;
    }

    @Override
    public T get(int index) {
        if(index < 0 ||index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            return head.value;
        }

        int counter = index - 1;
        ListNode previous = head; //starts at head

        while(counter > 0) {
            previous = previous.next;
            counter--;
        }

        return previous.next.value;
    }

    @Override
    public void add(int index, T value) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode node = new ListNode();
        node.value = value;

        if(head == null) {
            head = node;
            tail = node;
        } else if(index == 0) {

            node.next = head;
            head = node;
        } else if (index == size) {

            tail.next = node;
            tail = node;
        } else {
            int counter = index - 1;
            ListNode previous = head; //starts at head


            while(counter > 0) {
                previous = previous.next;
                counter--;
            }

            node.next = previous.next;
            previous.next = node;

        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }
}
