package com.example.sample.datastructures;

public class BinarySearchTree<K extends Comparable<K>, V> {
  
  private Node root;
  
  private class Node {
    
    private K key;
    private V value;
    private Node left;
    private Node right;
    private int n;
    
    public Node(K key, V value, int n) {
      this.key = key;
      this.value = value;
      this.n = n;
    }
    
  }
  
  public int size() {
    return size(root);
  }
  
  public V get(K key) {
    return get(root, key);
  }
  
  public void put(K key, V value) {
    root = put(root, key, value);
  }
  
  public K minimum() {
    return minimum(root);
  }
  
  // Code for maximum is similar, but from the right sub tree
  K minimum(Node node) {
    if (node == null) {
      return null;
    }
    if (node.left == null) {
      return node.key;
    }
    return minimum(node.left);
  }
  
  V get(Node node, K key) {
    if (node == null || key == null) {
      return null;
    }
    int compare = key.compareTo(node.key);
    if (compare < 0) {
      return get(node.left, key);
    }
    if (compare > 0) {
      return get(node.right, key);
    }
    return node.value;
  }
  
  Node put(Node node, K key, V value) {
    if (node == null) {
      return new Node(key, value, 1);
    }
    int compare = key.compareTo(node.key);
    if (compare < 0) {
      node.left = put(node.left, key, value);
    } else if (compare > 0) {
      node.right = put(node.right, key, value);
    } else {
      node.value = value;
    }
    node.n = size(node.left) + size(node.right) + 1;
    return node;
  }
  
  int size(Node node) {
    if (node == null) {
      return 0;
    }
    return node.n;
  }
  
}
