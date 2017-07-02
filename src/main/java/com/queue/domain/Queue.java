package com.queue.domain;

import java.util.Collection;

public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E front();

    boolean isEmpty();

    int getSize();

    Collection<E> values();

}
