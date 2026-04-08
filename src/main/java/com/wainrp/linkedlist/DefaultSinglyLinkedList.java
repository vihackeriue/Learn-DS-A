package com.wainrp.linkedlist;

import org.w3c.dom.Node;

public class DefaultSinglyLinkedList<T> implements SinglyLinkedList<T> {


    SinglyNode<T> head;
    int size;

    @Override
    public void clear() {
        SinglyNode<T> crrNode =  head;
        while (crrNode.getNext() != null) {
            SinglyNode<T> nextNode = crrNode.getNext();
            crrNode.setNext(null);
            crrNode.setData(null);
            crrNode = nextNode;
        }
        head = null;
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
        if(isEmpty()) {
            SinglyNode<T> newNode = new SinglyNode<>(element, null);
            head = newNode;
        }else {
            SinglyNode<T> newNode = new SinglyNode<>(element, head);
            head = newNode;
        }
        size++;

    }

    @Override
    public void addLast(T element) {
        if(isEmpty()) {
            head = new SinglyNode<>(element, null);
        }else {
            SinglyNode<T> crrNode = head;
            while (crrNode.getNext() != null) {
                crrNode = crrNode.getNext();
            }
            crrNode.setNext(new SinglyNode<>(element, null));
        }
        size++;
    }

    @Override
    public T peekFirst() {
        return head.getData();
    }

    @Override
    public T peekLast() {
        SinglyNode<T> crrNode = head;

        while (crrNode.getNext() != null) {
            crrNode = crrNode.getNext();
        }

        return crrNode.getData();
    }

    @Override
    public T removeFirst() {
        if(isEmpty()) throw  new RuntimeException("Empty list");
        T data = head.getData();
        head = head.getNext();
        size--;

        return data;
    }

    @Override
    public T removeLast() {
        SinglyNode<T> crrNode = head;
        while (crrNode.getNext().getNext() != null) {
            crrNode = crrNode.getNext();
        }
        crrNode.setNext(null);
        size--;
        return crrNode.getData();
    }

    @Override
    public T remove(SinglyNode<T> singlyNode) {
//        if(singlyNode.getNext() == null) return removeLast();
        T data = singlyNode.getData();
        SinglyNode<T> crrNode = head;
        while (crrNode.getNext() != null) {
            if(crrNode == singlyNode) {
                crrNode.setNext(crrNode.getNext().getNext());
            }

            crrNode = crrNode.getNext();
        }

        size--;
        return data;
    }

    @Override
    public boolean remove(Object object) {
        SinglyNode<T> crrNode = head;
        if(object == null){
            while(crrNode != null){
                if(crrNode.getData() == null){
                    remove(crrNode);
                    return true;
                }
                crrNode = crrNode.getNext();
            }
        }else {
            while(crrNode!= null){
                if(object.equals(crrNode.getData())){
                    remove(crrNode);
                    return true;
                }
                crrNode = crrNode.getNext();
            }
        }
        return false;
    }

    @Override
    public T removeAt(int index) {
        return null;
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        SinglyNode<T> crrNode = head;

        if(object == null){
            while (crrNode.getNext() != null) {
                if(crrNode.getData() == null){
                    return index;
                }
                index++;

                crrNode = crrNode.getNext();
            }
        }else {
            while (crrNode.getNext() != null) {
                if(object.equals(crrNode.getData())){
                    return index;
                }
                index++;

                crrNode = crrNode.getNext();
            }
        }

        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            SinglyNode<T> crrNode = head;

            while (crrNode != null) {
                sb.append(crrNode.getData());
                if(crrNode.getNext() != null) sb.append(", ");
                crrNode = crrNode.getNext();

            }
            sb.append("]");
            return sb.toString();
        }

    }
}
