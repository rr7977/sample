package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import org.junit.jupiter.api.Test;

class StackUsingLinkedListTest {

  @Test
  void testStackUsingLinkedList() {
    StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.size());
    StringBuilder sb = new StringBuilder();
    for (Integer item : stack) {
      sb.append(item);
    }
    assertEquals("321", sb.toString());
    StringBuilder sb2 = new StringBuilder();
    for (Integer item = stack.pop(); item != null; item = stack.pop()) {
      sb2.append(item);
    }
    assertEquals("321", sb2.toString());
    assertTrue(stack.isEmpty());
  }

  @Test
  void testStackUsingLinkedListPractice() {
    StackUsingLinkedListPractice<Integer> stack = new StackUsingLinkedListPractice<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.size());
    StringBuilder sb = new StringBuilder();
    for (Integer item : stack) {
      sb.append(item);
    }
    assertEquals("321", sb.toString());
    StringBuilder sb2 = new StringBuilder();
    for (Integer item = stack.pop(); item != null; item = stack.pop()) {
      sb2.append(item);
    }
    assertEquals("321", sb2.toString());
    assertTrue(stack.isEmpty());
  }

  private class StackUsingLinkedListPractice<E> implements Iterable<E> {

    Node<E> first;
    private long size = 0;

    public void push(E item) {
      this.first = new Node(item, this.first);
      this.size++;
    }

    public E pop() {
      if (this.first == null) {
        return null;
      } else {
        E firstItem = this.first.item;
        this.first = this.first.next;
        this.size--;
        return firstItem;
      }
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

        Node<E> current = StackUsingLinkedListPractice.this.first;

        @Override
        public boolean hasNext() {
          return this.current != null;
        }

        @Override
        public E next() {
          E item = this.current.item;
          this.current = this.current.next;
          return item;
        }
      };
    }

    private class Node<E> {

      E item;
      Node<E> next;

      Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
      }

    }

  }

}
