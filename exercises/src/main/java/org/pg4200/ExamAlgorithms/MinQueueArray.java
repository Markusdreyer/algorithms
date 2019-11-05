package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.queue.MyQueue;

/**
 * {@link org.pg4200.les02.queue.MyQueueArray}
 */


public class MinQueueArray<T> implements MyQueue<T> {

    private Object[] data;

    private int head = -1;
    private int tail = -1;

    public MinQueueArray(){
        this(10);
    }

    public MinQueueArray(int capacity){
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        if(isEmpty()) {
            head = 0;
            tail = 0;
        } else if(tail < data.length - 1) {

            tail++;
        } else {
            if(size() < data.length / 5) {

                int size = size();
                for(int i = 0; i < size; i++) {
                    data[i] = data[i + head];
                }
                head = 0;
                tail = size;
            } else {
                Object[] temp = new Object[data.length * 2];

                int size = size();
                for (int i = 0; i < size; i++) {
                    temp[i] = data[i + head];
                }
                head = 0;
                tail = size;
                data = temp;
            }
        }
        data[tail] = value;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) {
            throw new RuntimeException();
        }

        T value = (T) data[head];
        if(size() == 1) {
            head = -1;
            tail = -1;
        } else {
            head++;
        }

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
        if(head < 0) {
            return 0;
        }

        return (tail - head) + 1;
    }
}
