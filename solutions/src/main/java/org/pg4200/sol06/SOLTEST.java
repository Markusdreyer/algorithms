package org.pg4200.sol06;

public class SOLTEST {
    public static void main(String[] args) {
        HashMapLinearProbe hashMap = new HashMapLinearProbe();

        long putStartTime = System.nanoTime();

        // ... the code being measured starts ...

        for (int i = 0; i < 10_000_000; i++) {
            hashMap.put(i, 0);
        }

        // ... the code being measured ends ...

        long putEndTime = System.nanoTime();

        long putTimeElapsed = putEndTime - putStartTime;

        System.out.println("10,000,000 puts time elapsed in nanoseconds: " + putTimeElapsed);

        long sizeStartTime = System.nanoTime();

        // ... the code being measured starts ...

        hashMap.size();

        // ... the code being measured ends ...

        long sizeEndTime = System.nanoTime();

        long sizeTimeElapsed = sizeEndTime - sizeStartTime;

        System.out.println("size of 10,000,000 elements time elapsed in nanoseconds: " + sizeTimeElapsed);

        long getStartTime = System.nanoTime();

        // ... the code being measured starts ...

        for (int i = 0; i < 10_000_000; i++) {
            hashMap.get(i);
        }

        // ... the code being measured ends ...

        long getEndTime = System.nanoTime();

        long getTimeElapsed = getEndTime - getStartTime;

        System.out.println("10,000,000 gets time elapsed in nanoseconds: " + getTimeElapsed);

        long deleteStartTime = System.nanoTime();

        // ... the code being measured starts ...

        for (int i = 0; i < 10_000_000; i++) {
            hashMap.delete(i);
        }

        // ... the code being measured ends ...

        long deleteEndTime = System.nanoTime();

        long deleteTimeElapsed = deleteEndTime - deleteStartTime;

        System.out.println("10,000,000 deletes time elapsed in nanoseconds: " + deleteTimeElapsed);

    }
}
