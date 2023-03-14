package com.bridgelabz.hashmap;

public class MyBinaryTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return new MyBinaryNode<>(key);
        int compareResult = key.compareTo(current.key);
        if (compareResult == 0) return current;
        if (compareResult < 0)
            current.left = addRecursively(current.left, key);
        else
            current.right = addRecursively(current.right, key);
        return current;
    }

    public int getSize() {
        return this.getSizeRecursively(root);
    }

    public int getSizeRecursively(MyBinaryNode<K> current) {
        return current == null ? 0 : 1 + this.getSizeRecursively(current.left) + this.getSizeRecursively(current.right);
    }

    public boolean searchNode(K key) {
        return this.searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null)
            return false;
        else {
            int compareResult = key.compareTo(current.key);
            if (compareResult == 0) return true;
            if (compareResult < 0)
                return searchRecursively(current.left, key);
            else
                return searchRecursively(current.right, key);

        }
    }
}