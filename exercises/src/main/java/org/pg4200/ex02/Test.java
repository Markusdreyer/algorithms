package org.pg4200.ex02;

public class Test {
    private static MyArrayListResizable list = new MyArrayListResizable();
    private static MyRingArrayQueue queue = new MyRingArrayQueue(5);

    //EXERCISE

    public static void main(String[] args) {
        //list.add(0, 2);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();

    }
}
