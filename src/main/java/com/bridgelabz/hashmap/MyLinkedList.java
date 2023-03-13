package com.bridgelabz.hashmap;

public class MyLinkedList<K, V> {
    public INode head;
    public INode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(INode newNode) {
        size++;
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            INode tempNode = this.tail;
            tempNode.setNext(newNode);
            this.tail = newNode;
        }
    }

    public INode search(K key) {
        if (this.head == null) {
        } else {
            INode tempNode = head;
            while (!tempNode.equals(this.tail)) {
                if (tempNode.getKey().equals(key)) {
                    return tempNode;
                } else {
                    tempNode = tempNode.getNext();
                }
            }
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" + head + '}';
    }
}
