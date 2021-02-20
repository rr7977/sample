package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Iterator;
import java.util.Random;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StackUsingResizingArrayTest {

  @Test
  @Disabled
  void test() {
    StackUsingResizingArray<Integer> s = new StackUsingResizingArray<>();

    Integer[] integers = new Random().ints(100).boxed().toArray(Integer[]::new);

    for (Integer integer : integers) {
      s.push(integer);
    }

    assertEquals(s.size(), integers.length);

  }

  @Test
  @Disabled
  void testPractice() {
    StackUsingResizingArrayPractice<Integer> s = new StackUsingResizingArrayPractice<>();

    Integer[] integers = new Random().ints(100).boxed().toArray(Integer[]::new);

    for (Integer integer : integers) {
      s.push(integer);
    }

    assertEquals(s.size(), integers.length);

  }

  class StackUsingResizingArrayPractice<E> implements Iterable<E> {

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
      E temp = a[top--];
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
      return new Iterator<>() {

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

}
