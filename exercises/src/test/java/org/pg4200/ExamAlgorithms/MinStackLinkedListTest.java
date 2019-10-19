package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.stack.MyStack;
import org.pg4200.les02.stack.MyStackTestTemplate;

public class MinStackLinkedListTest extends MyStackTestTemplate {
    @Override
    protected <T> MyStack<T> getInstance(Class<T> klass) {
        return new MinStackLinkedList();
    }
}
