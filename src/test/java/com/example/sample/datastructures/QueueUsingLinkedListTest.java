package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class QueueUsingLinkedListTest {

  @Test
  void test() {
    QueueUsingLinkedList<Integer> queue = new QueueUsingLinkedList<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(3, queue.size());
    StringBuilder sb = new StringBuilder();
    for (Integer item : queue) {
      sb.append(item);
    }
    assertEquals("123", sb.toString());
    StringBuilder sb2 = new StringBuilder();
    try {
      for (Integer item = queue.dequeue(); item != null; item = queue.dequeue()) {
        sb2.append(item);
      }
    } catch (NoSuchElementException e) {
      // Ignore. This means the queue is empty
    }
    assertEquals("123", sb2.toString());
    assertTrue(queue.isEmpty());
  }

  @Test
  void testPractice() {
    QueueUsingLinkedListPractice<Integer> queue = new QueueUsingLinkedListPractice<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    assertEquals(3, queue.size());
    StringBuilder sb = new StringBuilder();
    for (Integer item : queue) {
      sb.append(item);
    }
    assertEquals("123", sb.toString());
    StringBuilder sb2 = new StringBuilder();
    try {
      for (Integer item = queue.dequeue(); item != null; item = queue.dequeue()) {
        sb2.append(item);
      }
    } catch (NoSuchElementException e) {
      // Ignore. This means the queue is empty
    }
    assertEquals("123", sb2.toString());
    assertTrue(queue.isEmpty());
  }

  private class QueueUsingLinkedListPractice<E> implements Iterable<E> {

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
        Node<E> current = QueueUsingLinkedListPractice.this.first;

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

    private class Node<T> {

      T item;
      Node<T> next;

      Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
      }
    }

  }

}
