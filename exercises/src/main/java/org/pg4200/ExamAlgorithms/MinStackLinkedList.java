package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.stack.MyStack;

public class MinStackLinkedList<T> implements MyStack<T> {

    private class StackNode {
        T value;
        StackNode previous;
    }

    private StackNode tail;

    private int size;

    @Override
    public void push(T value) {
        StackNode node = new StackNode();
        node.value = value;

        if(tail == null) {
            //first element in list
            tail = node;
        } else {
            node.previous = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public T peek() {
        if(tail == null) {
            throw new RuntimeException();
        }

        return tail.value;
    }

    @Override
    public T pop() {
        if(tail == null) {
            throw new RuntimeException();
        }

        T value = tail.value;
        tail = tail.previous;

        size--;

        return value;
    }

    @Override
    public int size() {
        return this.size;
    }
}
