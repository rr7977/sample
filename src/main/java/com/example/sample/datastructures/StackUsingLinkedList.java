package com.example.sample.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackUsingLinkedList<E> implements Iterable<E> {

  private Node<E> first;
  private long size = 0;

  public void push(E item) {
    this.first = new Node<>(item, this.first);
    this.size++;
  }

  public E pop() {
    if (this.first == null) {
      return null;
    }
    E firstItem = this.first.item;
    this.first = this.first.next;
    this.size--;
    return firstItem;
  }

  public long size() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<>() {

      Node<E> current = StackUsingLinkedList.this.first;

      @Override
      public boolean hasNext() {
        return this.current != null;
      }

      @Override
      public E next() {
        if (this.current == null) {
          throw new NoSuchElementException();
        }
        E currentItem = this.current.item;
        this.current = this.current.next;
        return currentItem;
      }
    };
  }

  private class Node<T> {

    T item;
    Node<T> next;

    Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }

  }
}
