package com.example.sample.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueUsingLinkedList<E> implements Iterable<E> {

  private Node<E> first;
  private Node<E> last;
  private long size = 0;

  public void enqueue(E item) {
    if (this.last == null) {
      this.last = new Node<>(item, null);
      this.first = this.last;
    } else {
      this.last.next = new Node<>(item, null);
      this.last = this.last.next;
    }
    this.size++;
  }

  public E dequeue() {
    if (this.first == null) {
      throw new NoSuchElementException();
    }
    E item = this.first.item;
    this.first = this.first.next;
    this.size--;
    return item;
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
      Node<E> current = QueueUsingLinkedList.this.first;

      @Override
      public boolean hasNext() {
        return this.current != null;
      }

      @Override
      public E next() {
        if (this.current == null) {
          throw new NoSuchElementException();
        }
        E item = this.current.item;
        this.current = this.current.next;
        return item;
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
