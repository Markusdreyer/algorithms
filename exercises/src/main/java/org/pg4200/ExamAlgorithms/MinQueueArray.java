package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.queue.MyQueue;

/**
 * {@link org.pg4200.les02.queue.MyQueueArray}
 */


public class MinQueueArray<T> implements MyQueue<T> {
    private Object[] data;
    private int head = -1;
    private int tail = -1;
    private int size = 0;

    public MinQueueArray() {
        this(10);
    }

    public MinQueueArray(int capacity) {
        data = new Object[capacity];
    }


    @Override
    public void enqueue(T value) {
        if(isEmpty()) {
            head = 0;
            tail = 0;
        } else if(tail < data.length -1) {
            tail++;
        } else if(size < data.length / 5) {
            for(int i = 0; i < size; i++) {
                data[i] = data[i + head];
            }
            head = 0;
            tail = size;
        } else {
            Object[] tmp = new Object[data.length * 2];

            for(int i = 0; i < size; i++) {
                tmp[i] = data[i + head];
            }

            head = 0;
            tail = size;
            data = tmp;
        }

        size++;
        data[tail] = value;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException();
        }

        if(head < 0) {
            return null;
        }

        T value = (T) data[head];
        head++;
        size--;

        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException();
        }
        return (T) data[head];
    }

    @Override
    public int size() {
        return size;
    }

}
