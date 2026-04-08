package com.wainrp.stack;


import com.wainrp.linkedlist.DefaultDoublyLinkedList;
import com.wainrp.linkedlist.DoublyLinkedList;

import java.util.EmptyStackException;
import java.util.Iterator;


public class LinkedListBaseStack<T> implements StackADT<T> {
    private DoublyLinkedList<T> list = new DefaultDoublyLinkedList<>();
    private int index = -1;

    public LinkedListBaseStack() {}

    public LinkedListBaseStack(T element) {
        push(element);
    }

    @Override
    public void push(T element) {
        list.addFirst(element);
    }

    @Override
    public T pop() {
        if(isEmpty()) throw new EmptyStackException();
        return list.removeFirst();
    }

    @Override
    public T top() {
        if(isEmpty()) throw new EmptyStackException();
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
