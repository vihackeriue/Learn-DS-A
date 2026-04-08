package com.wainrp.linkedlist;

import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {

    private int size;
    private DoublyNode<T> head = null;
    private DoublyNode<T> tail = null;
    @Override
    public void clear() {
        DoublyNode<T> currentDoublyNode = head;
        while(currentDoublyNode != null) {
            DoublyNode<T> nextDoublyNode = currentDoublyNode.getNext();
            currentDoublyNode.setNext(null);
            currentDoublyNode.setNext(null);
            currentDoublyNode.setData(null);
            currentDoublyNode = nextDoublyNode;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(T element) {
        addLast(element);
    }

    @Override
    public void addFirst(T element) {
        if(isEmpty()){
            head = tail = new DoublyNode<>(element, null, null);
        }else {
            DoublyNode<T> newDoublyNode = new DoublyNode<>(element, null, head);
            head.setPrev(newDoublyNode);
            head = head.getPrev();
        }
        size++;
    }

    @Override
    public void addLast(T element) {
        if(isEmpty()){
            head = tail = new DoublyNode<>(element, null, null);
        }else {
            DoublyNode<T> newDoublyNode = new DoublyNode<>(element, tail, null);
            tail.setNext(newDoublyNode);
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public T peekFirst() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        return head.getData();
    }

    @Override
    public T peekLast() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        return tail.getData();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        T data = head.getData();
        head = head.getNext();
        size--;
       if(isEmpty()) tail = null;
       else head.setPrev(null);
       return data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()) throw new RuntimeException("List is empty");
        T data = tail.getData();
        tail = tail.getPrev();
        size--;
        if(isEmpty()) head = null;
        else tail.setNext(null);
        return data;
    }

    @Override
    public T remove(DoublyNode<T> doublyNode) {
        if(doublyNode.getNext() == null) return removeLast();
        if(doublyNode.getPrev() == null) return removeFirst();
        doublyNode.getPrev().setNext(doublyNode.getNext());
        doublyNode.getNext().setPrev(doublyNode.getPrev());

        T data = doublyNode.getData();
        size --;
        clearMemory(doublyNode);

        return data;
    }
    private void clearMemory(DoublyNode<T> doublyNode){
        doublyNode.setData(null);
        doublyNode.setNext(null);
        doublyNode.setPrev(null);
        doublyNode = null;
    }
    @Override
    public boolean remove(Object object) {
        DoublyNode<T> currentDoublyNode = head;

        if(object == null){
            while (currentDoublyNode != null) {
                if(currentDoublyNode.getData() == null){
                    remove(currentDoublyNode);
                    return true;
                }
                currentDoublyNode = currentDoublyNode.getNext();
            }
        }
        else {
            while (currentDoublyNode != null) {
                if(currentDoublyNode.getData() == object){
                    remove(currentDoublyNode);
                    return true;

                }
                currentDoublyNode = currentDoublyNode.getNext();
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        if(index < 0 || index >= size()) throw new IllegalArgumentException("Index out of bounds");

        DoublyNode<T> currentDoublyNode;
        int i ;
        if(index < size/2){
            i = 0;
            currentDoublyNode = head;
            while (i != index){
                currentDoublyNode = currentDoublyNode.getNext();
                i++;
            }
        }else {
            i = size-1;
            currentDoublyNode = tail;
            while (i != index){
                currentDoublyNode = currentDoublyNode.getPrev();
                i--;
            }
        }

        return remove(currentDoublyNode);
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;

        DoublyNode<T> currentDoublyNode = head;

        if(object == null){
            while (currentDoublyNode != null) {
                if(currentDoublyNode.getData() == null){
                    return index;
                }
                index++;
                currentDoublyNode = currentDoublyNode.getNext();
            }
        }else {
            while (currentDoublyNode != null) {
                if(currentDoublyNode.getData() == object){
                    return index;
                }
                index++;
                currentDoublyNode = currentDoublyNode.getNext();
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            DoublyNode<T> currentDoublyNode = head;
            @Override
            public boolean hasNext() {
                return currentDoublyNode != null;
            }

            @Override
            public T next() {
                T data = currentDoublyNode.getData();
                currentDoublyNode = currentDoublyNode.getNext();
                return data;
            }
        };
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        else{
            StringBuilder sb = new StringBuilder(size);
            sb.append("[ ");

            DoublyNode<T> currentDoublyNode = head;

            while (currentDoublyNode !=null){
                sb.append(currentDoublyNode.getData());
                if(currentDoublyNode.getNext()!=null) sb.append(", ");
                currentDoublyNode = currentDoublyNode.getNext();
            }
            sb.append(" ]");
            return sb.toString();
        }
    }
}
