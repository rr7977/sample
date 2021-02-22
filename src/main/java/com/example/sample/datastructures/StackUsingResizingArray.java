package com.example.sample.datastructures;

import java.util.Iterator;

public class StackUsingResizingArray<E> {

  private static final int DEFAULT_CAPACITY = 10;

  private E[] a = (E[]) new Object[DEFAULT_CAPACITY];
  private int top = -1;

  void push(E e) {
    if (this.top == this.a.length - 1) {
      this.resizeArray(2 * this.a.length);
    }
    this.a[++this.top] = e;
  }

  E pop() {
    if (this.top == -1) {
      return null;
    }
    if (this.top == this.a.length / 4) {
      this.resizeArray(this.a.length / 2);
    }
    E temp = this.a[this.top--];
    this.a[this.top] = null;
    return temp;
  }

  int size() {
    return this.top + 1;
  }

  boolean isEmpty() {
    return this.top == -1;
  }

  private void resizeArray(int capacity) {
    E[] temp = (E[]) new Object[capacity];
    for (int i = 0; i < this.a.length; i++) {
      temp[i] = this.a[i];
    }
    this.a = temp;
  }

  public Iterator<E> iterator() {
    return new Iterator<>() {

      private int current = StackUsingResizingArray.this.top;

      @Override
      public boolean hasNext() {
        return this.current >= 0;
      }

      @Override
      public E next() {
        return StackUsingResizingArray.this.a[this.current--];
      }

    };
  }

}
