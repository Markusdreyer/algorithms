package org.pg4200.ex03;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class OptimizedBubbleSortTest {

    private static OptimizedBubbleSort sorter = new OptimizedBubbleSort();

    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }

    @Test
    public void sortGameUser() {
        GameUser[] gameUsers = new GameUser[] {
                new GameUser("Foo", 10),
                new GameUser("Bar", 5),
                new GameUser("Xavier", 20),
                new GameUser("Aasgard", 20),
        };

        sorter.sort(gameUsers, new GameUserComparator(), false);
        //Arrays.stream(gameUsers).forEach(s -> System.out.println("UserId: " + s.getUserId() + "\nPoints: " + s.getPoints() + "\n"));
        assert(gameUsers[0].getUserId().equals("Aasgard"));
        assert(gameUsers[2].getUserId().equals("Bar"));
    }

    @Test
    public void unoptimizedSort() {
        String[] array = {"c", "b", "a", "d", "e", "f"};
        int numberOfComparisons = sorter.sort(array, new StringComparator(), false);

        assert(array[0].equals("a"));
        assert(array[5].equals("f"));
        assert(numberOfComparisons == 15);
    }

    @Test
    public void optimizedSort() {
        String[] array = {"c", "b", "a", "d", "e", "f"};
        int numberOfComparisons = sorter.sort(array, new StringComparator(), true);

        assert(array[0].equals("a"));
        assert(array[5].equals("f"));
        assert(numberOfComparisons == 6);
    }
}
