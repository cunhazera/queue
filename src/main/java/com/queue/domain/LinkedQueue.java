package com.queue.domain;

import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void enqueue(E e) {
        list.add(e);
    }

    @Override
    public E dequeue() {
        return list.poll();
    }

    @Override
    public E front() {
        return list.peek();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public LinkedList<E> values() {
        return list;
    }

}
