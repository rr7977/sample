package com.example.sample.datastructures;

public class LinkedList<E> {

  Node<E> first;

  public void addFirst(E item) {
    this.first = new Node<>(item, this.first);
  }

  class Node<T> {

    T item;
    Node<T> next;

    Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }

  }

}
