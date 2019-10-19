package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.queue.MyQueue;

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
            //there is space
            tail++;
        } else {
            if(size() < data.length / 5) {
                //Empty slots available so we perform a left shift
                int size = size();
                for(int i = 0; i < size; i++) {
                    data[i] = data[i + head];//[i + head] because there might have been dequed elements, which would result in head != 0
                }
                head = 0;
                tail = size;
            } else {
                Object[] temp = new Object[data.length * 2];

                int size = size(); //so as to not call size() every iteration
                for (int i = 0; i < size; i++) {
                    temp[i] = data[i + head]; //[i + head] because there might have been dequed elements, which would result in head != 0
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

        return (tail - head) + 1;//+1 because arrays start at 0
    }
}
