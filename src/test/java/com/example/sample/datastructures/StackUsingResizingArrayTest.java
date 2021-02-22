package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Random;
import org.junit.jupiter.api.Test;

class StackUsingResizingArrayTest {

  @Test
  void test() {
    StackUsingResizingArray<Integer> s = new StackUsingResizingArray<>();

    Integer[] integers = new Random().ints(100).boxed().toArray(Integer[]::new);

    for (Integer integer : integers) {
      s.push(integer);
    }

    assertEquals(s.size(), integers.length);

  }

  @Test
  void testPractice() {
    StackUsingResizingArrayPractice<Integer> s = new StackUsingResizingArrayPractice<>();

    Integer[] integers = new Random().ints(100).boxed().toArray(Integer[]::new);

    for (Integer integer : integers) {
      s.push(integer);
    }

    assertEquals(s.size(), integers.length);

  }

  private static class StackUsingResizingArrayPractice<E> implements Iterable<E> {

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

    @Override
    public Iterator<E> iterator() {
      return new Iterator<>() {

        private int current = StackUsingResizingArrayPractice.this.top;

        @Override
        public boolean hasNext() {
          return this.current >= 0;
        }

        @Override
        public E next() {
          return StackUsingResizingArrayPractice.this.a[this.current--];
        }

      };
    }
  }

}
