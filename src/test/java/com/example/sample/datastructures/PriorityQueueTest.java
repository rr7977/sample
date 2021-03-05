package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {
  
  @Test
  void testPriorityQueue() {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    assertEquals(0, pq.size());
    assertNull(pq.peek());
    assertNull(pq.poll());
    for (int i = 0; i < 10; i++) {
      pq.add(i);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb.append(pq.peek());
    }
    assertEquals(10, pq.size());
    assertEquals("9999999999", sb.toString());
    assertEquals(10, pq.size());
    StringBuilder sb2 = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb2.append(pq.poll());
    }
    assertEquals("9876543210", sb2.toString());
    assertEquals(0, pq.size());
    for (int i : new Random().ints(100000).toArray()) {
      pq.add(i);
    }
    assertEquals(100000, pq.size());
    for (int i = 0; i < 100000; i++) {
      pq.poll();
    }
    assertEquals(0, pq.size());
  }
  
  @Test
  void testPriorityQueuePractice() {
    PriorityQueuePractice<Integer> pq = new PriorityQueuePractice<>();
    assertEquals(0, pq.size());
    assertNull(pq.peek());
    assertNull(pq.poll());
    for (int i = 0; i < 10; i++) {
      pq.add(i);
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb.append(pq.peek());
    }
    assertEquals(10, pq.size());
    assertEquals("9999999999", sb.toString());
    assertEquals(10, pq.size());
    StringBuilder sb2 = new StringBuilder();
    for (int i = 0; i < 10; i++) {
      sb2.append(pq.poll());
    }
    assertEquals("9876543210", sb2.toString());
    assertEquals(0, pq.size());
    for (int i : new Random().ints(100000).toArray()) {
      pq.add(i);
    }
    assertEquals(100000, pq.size());
    for (int i = 0; i < 100000; i++) {
      pq.poll();
    }
    assertEquals(0, pq.size());
  }
  
  /**
   * Max priority queue
   *
   * @param <E> the element type
   */
  class PriorityQueuePractice<E extends Comparable<E>> {
    
    // Initialize queue to a default capacity of 10
    private Object[] queue = new Object[10];
    private int last = -1;
    
    void add(E item) {
      if (item == null) {
        throw new NullPointerException();
      }
      if (last == queue.length - 1) {
        resizeArray(2 * queue.length);
      }
      queue[++last] = item;
      siftUp(last);
    }
    
    E peek() {
      return (E) queue[0];
    }
    
    E poll() {
      if (last < 0) {
        return null;
      }
      E item = (E) queue[0];
      queue[0] = queue[last];
      queue[last--] = null;
      siftDown(0);
      if (last == queue.length / 4) {
        resizeArray(queue.length / 2);
      }
      return item;
    }
    
    int size() {
      return last + 1;
    }
    
    private void siftDown(int k) {
      if (2 * k > last) {
        return;
      }
      int greaterChild =
          2 * k == last || ((E) queue[2 * k]).compareTo((E) queue[2 * k + 1]) >= 0 ? 2 * k
              : 2 * k + 1;
      if (((E) queue[k]).compareTo((E) queue[greaterChild]) < 0) {
        ArrayUtils.swap(queue, k, greaterChild);
        siftDown(greaterChild);
      }
    }
    
    private void siftUp(int k) {
      if (((E) queue[k]).compareTo((E) queue[k / 2]) > 0) {
        ArrayUtils.swap(queue, k, k / 2);
        siftUp(k / 2);
      }
    }
    
    private void resizeArray(int length) {
      Object[] temp = new Object[length];
      System.arraycopy(queue, 0, temp, 0, size());
      this.queue = temp;
    }
    
  }
}
