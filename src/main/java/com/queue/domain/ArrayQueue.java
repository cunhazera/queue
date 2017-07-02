package com.queue.domain;

import java.util.Arrays;
import java.util.Collection;

public class ArrayQueue<E> implements Queue<E> {

    private E[] array;

    private int head = 0;

    private int tail = 0;

    private int size = 0;

    public ArrayQueue() {
        array = (E[]) new Object[20];
    }

    public ArrayQueue(int size) {
        array = (E[]) new Object[size];
    }

    @Override
    public synchronized void enqueue(E e) {
        if (isFull()) {
            E[] temp = (E[]) new Object[array.length * 2];

            int n = head;
            for (int i = 0; i < array.length; i++) {
                n = n % array.length;
                temp[i] = array[n];
                n++;
            }
            head = 0;
            tail = array.length;
            array = temp;
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    private boolean isFull() {
        return getSize() == array.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E aux = array[head];
            array[head] = null;
            head = (head + 1) % array.length;
            size--;
            return aux;
        }
    }

    @Override
    public E front() {
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Collection<E> values() {
        return Arrays.asList(array);
    }
}
