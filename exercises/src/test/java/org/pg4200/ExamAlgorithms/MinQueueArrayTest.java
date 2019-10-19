package org.pg4200.ExamAlgorithms;

import org.pg4200.les02.queue.MyQueue;
import org.pg4200.les02.queue.MyQueueTestTemplate;

public class MinQueueArrayTest extends MyQueueTestTemplate {
    @Override
    protected <T> MyQueue<T> getNewInstance(Class<T> klass) {
        return new MinQueueArray<>();
    }
}
