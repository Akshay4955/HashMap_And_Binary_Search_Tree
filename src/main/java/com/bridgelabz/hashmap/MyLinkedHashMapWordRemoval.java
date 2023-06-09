package com.bridgelabz.hashmap;

import java.util.ArrayList;

public class MyLinkedHashMapWordRemoval<K, V> {
    private final int numOfBuckets;
    ArrayList<MyLinkedList<K, V>> myBucketArray;

    public MyLinkedHashMapWordRemoval() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>(numOfBuckets);
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    private int getBucketIndex(K key) {
        int hashcode = Math.abs(key.hashCode());
        int index = hashcode % numOfBuckets;
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    public void remove(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K, V> myLinkedList = this.myBucketArray.get(index);
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        Integer value = 0;
        myMapNode.setValue((V) value);
    }

    @Override
    public String toString() {
        return "MyLinkedHashMap {" + myBucketArray + '}';
    }
}
