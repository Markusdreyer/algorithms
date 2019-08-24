package org.pg4200.ex02;

import org.pg4200.les02.queue.MyQueue;

import java.util.Arrays;

public class MyRingArrayQueue<T> implements MyQueue<T> {
    protected Object[] data;

    private int head = -1;
    private int tail = -1;


    public MyRingArrayQueue(){
        this(10);
    }

    public MyRingArrayQueue(int capacity){
        data = new Object[capacity];
    }

    @Override
    public void enqueue(T value) {

        if(isEmpty()){
            head = 0;
            tail = 0;
        } else {
            if(head == tail) {
                tail = data.length - size();
            }
            if(size() > data.length) {
                Object[] tmp = new Object[data.length * 2];

                int  size = size() - 1;

                for(int i = 0; i < size; i++){
                    if(head <= data.length) {
                        tmp[i] = data[head];
                        head++;
                    }
                    if(tail < head && head >= data.length) {
                        tmp[i] = data[tail];
                        tail++;
                    }
                }
                head = 0;
                tail = size() -1 ; //Value is not yet added to data array, so index of tail is not yet == to size()
                data = tmp;

            }
        }

        data[tail] = value;
        if(head < tail) {   //wtf?
            head = 0;
            tail = size();
        } else {
            tail++;
        }
        System.out.println(Arrays.deepToString(data));
    }

    @Override
    public T dequeue() {

        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head];

        data[head] = null; //to visualize the empty slots

        if(size() == 1){
            //now it ll be empty
            head = -1;
            tail = -1;
        } else {
            if(tail + 1 == data.length) {
                tail = head;
            }
            head++;
        }

        System.out.println("Index of head: " + head);
        System.out.println("Index of tail: " + tail);
        return value;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new RuntimeException();
        }

        return (T) data[head];
    }

    @Override
    public int size() {

        if(head < 0){
            return 0;
        }

        int availableIndexes;
        int value;

        if(tail < head) {
            if(tail == 0) {
                availableIndexes = head;
            } else {
                availableIndexes = head - tail + 1;
            }
            value = data.length - availableIndexes;
            return value;
        }

        return (tail - head ) + 1;
    }
}
