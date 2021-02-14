package com.example.sample.datastructures;

import java.util.Iterator;

public class StackUsingResizingArray<E> {

  private static final int DEFAULT_CAPACITY = 10;

  private E[] a = (E[]) new Object[DEFAULT_CAPACITY];
  private int top = -1;

  void push(E e) {
    if (top == a.length - 1) {
      resizeArray(2 * a.length);
    }
    a[++top] = e;
  }

  E pop() {
    if (top == -1) {
      return null;
    }
    if (top == a.length / 4) {
      resizeArray(a.length / 2);
    }
    E temp = (E) a[top--];
    a[top] = null;
    return temp;
  }

  int size() {
    return top + 1;
  }

  boolean isEmpty() {
    return top == -1;
  }

  private void resizeArray(int capacity) {
    E[] temp = (E[]) new Object[capacity];
    for (int i = 0; i < a.length; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public Iterator<E> iterator() {
    return new Iterator<E>() {

      private int current = top;

      @Override
      public boolean hasNext() {
        return current >= 0;
      }

      @Override
      public E next() {
        return a[current--];
      }

    };
  }

}
