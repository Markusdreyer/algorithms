package org.pg4200.sol02;

public class Test {
    private static MyArrayListResizable list = new MyArrayListResizable();
    private static MyRingArrayQueue queue = new MyRingArrayQueue(5);

    //SOLUTION

    private static String[] stringArray = new String[5];

    public static void main(String[] args) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(5);
        queue.enqueue(7);
    }
}
