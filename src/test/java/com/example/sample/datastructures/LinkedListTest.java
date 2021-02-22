package com.example.sample.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

  @Test
  void testAddFirst() {
    LinkedList<String> linkedList = new LinkedList<>();
    linkedList.addFirst("one");
    linkedList.addFirst("two");
    linkedList.addFirst("three");

    StringBuilder sb = new StringBuilder();
    for (LinkedList.Node node = linkedList.first; node != null; node = node.next) {
      sb.append(node.item);
    }
    Assertions.assertEquals("threetwoone", sb.toString());
  }

  @Test
  void testAddFirstPractice() {
    LinkedListPractice<String> linkedListPractice = new LinkedListPractice<>();
    linkedListPractice.addFirst("one");
    linkedListPractice.addFirst("two");
    linkedListPractice.addFirst("three");

    StringBuilder sb = new StringBuilder();
    for (LinkedListPractice.Node node = linkedListPractice.first; node != null; node = node.next) {
      sb.append(node.item);
    }
    Assertions.assertEquals("threetwoone", sb.toString());
  }

  private static class LinkedListPractice<E> {

    Node<E> first;

    void addFirst(E item) {
      this.first = new Node<>(item, this.first);
    }

    private static class Node<T> {

      T item;
      Node<T> next;

      Node(T item, Node<T> next) {
        this.item = item;
        this.next = next;
      }
    }

  }
}
