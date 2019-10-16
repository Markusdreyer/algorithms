package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.list.MyListTestTemplate;

public class MinLinkedListTests extends MyListTestTemplate {
    @Override
    protected <T> MinLinkedList<T> getNewInstance(Class<T> klass) {
        return new MinLinkedList<>();
    }
}