package org.pg4200.ex09;

import org.pg4200.les09.search.TextSearch;

public class MyTextSearchKMP {
    private String pattern;
    private int[][] dfa;

    public MyTextSearchKMP(String pattern) {
        this.pattern = pattern;
        int patternLength = pattern.length();
        int matrixDepth = 256;

        dfa = new int[matrixDepth][patternLength];

        dfa[pattern.charAt(0)][0] = 1;

        for (int x = 0, j = 1; j < patternLength; j++) {
            for (int c = 0; c < matrixDepth; c++) {
                dfa[c][j] = dfa[c][x];
            }

            dfa[pattern.charAt(j)][j] = j+1;
            x = dfa[pattern.charAt(j)][x];
        }
    }

    public int search(String text) {
        int i, j, n = text.length(), matrixDepth = pattern.length();
        for(i = 0, j = 0; i < n && j < matrixDepth; i++) {
            j = dfa[text.charAt(i)][j];
        }
        if (j == matrixDepth) {
            return i - matrixDepth;
        } else {
            return n;
        }
    }

 }
