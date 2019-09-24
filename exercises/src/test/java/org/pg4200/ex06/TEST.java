package org.pg4200.ex06;

public class TEST {

    public static void main(String[] args) {
        HashMapLinearProbe hashMap = new HashMapLinearProbe();

        hashMap.put("foo", 1);
        hashMap.put("bar", 2);

        System.out.println(hashMap.size());
        System.out.println(hashMap.get("foo"));
    }
}
