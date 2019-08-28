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
      if(isEmpty()) {
          head = 0;
          tail = 0;
      } else if (head <= tail) { //normal case
          if(tail < data.length - 1) {
              //still empty spaces available
              tail++;
          } else {
              if(head != 0) {
                  //if head is no longer == 0, then a deque has been performed, and therefore it is space available to the left of head
                  tail = 0;
              } else {
                  //no more spaces, so we create an array twice the size of the original
                  Object[] tempArray = new Object[data.length * 2];

                  for(int i = 0; i < data.length; i++) {
                      tempArray[i] = data[i];
                  }
                  tail = data.length; //or tail++
                  data = tempArray;
              }
          }
      } else {
          //circle array
          //head is no longer at 0, so there might be empty spaces before head
          //tail should now be < head

          if(tail < head - 1) {
              //means that there are empty spaces left before head
              tail++;
          } else {
              //circle array is full and should be moved to larger array
              Object[] tempArray = new Object[data.length * 2];

              //loop to move all elements from head -> data.length
              int k = data.length - head;
              for(int i = 0; i < k; i++) {
                  tempArray[i] = data[head + i];
              }

              //loop to move all remaining elements from tail -> head
              for(int i = 0; i < head; i++) { //NB: MAYBE CHANGE  "i < head" to "i < (tail +1)"
                  tempArray[k + i] = data[i];
              }

              head = 0;
              tail = data.length; //since data.length still refers to old array, tail would now be == size of old array/data.length
              data = tempArray;
          }
      }
      data[tail] = value;

    }

    @Override
    public T dequeue() {

        if(isEmpty()){
            throw new RuntimeException();
        }

        T value = (T) data[head];
        data[head] = null; //to visualize the empty slots


        if(size() == 1){
            //now it'll be empty
            head = -1;
            tail = -1;
        } else {
            head++;
            if(head >= data.length){
                head = 0;
            }
        }
        System.out.println(Arrays.deepToString(data));

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

       if(head < 0) {
           return 0;
       } else if(head == tail) {
           return 1;
       } else if(head < tail) {
           //normal case
           return (tail - head) + 1;
       } else {
           //tail is left of head
           int size = 0;

           size += data.length - head;
           size += tail + 1;

           return size;
       }
    }
}
