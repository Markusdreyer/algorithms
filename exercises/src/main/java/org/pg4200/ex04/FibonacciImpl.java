package org.pg4200.ex04;

public class FibonacciImpl implements Fibonacci {
    @Override
    public int compute(int n) throws IllegalArgumentException {

        if(n==0 || n==1) {
            return n;
        }

        return compute(n-1) + compute(n-2);
    }

    //f(n) = f(n-2) + f(n-1)
}
