package org.pg4200.sol02;

import java.util.Arrays;

public class Test {
    private static MyArrayListResizable list = new MyArrayListResizable();

    //SOLUTION

    private static String[] stringArray = new String[5];

    public static void main(String[] args) {
        list.add(0, 2);

        System.out.println(stringArray.length);
        System.out.println(Arrays.deepToString(stringArray));

    }
}
