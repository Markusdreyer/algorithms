package org.pg4200.les09.search;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        matrix[0][0] = 0;

        matrix[1][0] = 1;
        matrix[2][0] = 2;
        matrix[3][0] = 3;
        matrix[4][0] = 4;

        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 3;
        matrix[0][4] = 4;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
