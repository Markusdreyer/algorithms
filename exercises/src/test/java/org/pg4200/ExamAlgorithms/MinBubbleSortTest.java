package org.pg4200.ExamAlgorithms;

import org.pg4200.les03.sort.MySort;
import org.pg4200.les03.sort.SortTestTemplate;

public class MinBubbleSortTest extends SortTestTemplate {
    @Override
    protected MySort getInstance() {
        return new MinBubbleSort();
    }
}
