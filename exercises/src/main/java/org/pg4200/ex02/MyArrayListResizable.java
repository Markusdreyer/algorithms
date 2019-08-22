package org.pg4200.ex02;

import org.pg4200.les02.list.MyArrayList;

import java.util.Arrays;

public class MyArrayListResizable<T> extends MyArrayList<T> {

    public MyArrayListResizable(){
        super();
    }

    public MyArrayListResizable(int capacity){
        super(capacity);
    }

    @Override
    public void add(int index, T value) {
        if(size >= data.length) {
            Object[] newArray = new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newArray[i] = data[i];
            }
            data = newArray;
            newArray[index] = value;
        }

        super.add(index, value);
        System.out.println(Arrays.deepToString(data));
    }

}
