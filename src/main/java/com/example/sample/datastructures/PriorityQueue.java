package com.example.sample.datastructures;

import org.apache.commons.lang3.ArrayUtils;

public class PriorityQueue<E extends Comparable<E>> {
  
  private Object[] queue = new Object[10];
  private int n = 0;
  
  public void add(E item) {
    if (n == queue.length - 1) {
      resizeArray(2 * queue.length);
    }
    queue[++n] = item;
    siftUpLastItem();
  }
  
  public E peek() {
    return (E) queue[1];
  }
  
  public E poll() {
    if (n == 0) {
      return null;
    }
    E item = (E) queue[1];
    queue[1] = queue[n];
    queue[n--] = null;
    siftDownFirstItem();
    return item;
  }
  
  public int size() {
    return n;
  }
  
  private void siftUpLastItem() {
    int k = n;
    while (k > 1) {
      if (((E) queue[k]).compareTo((E) queue[k / 2]) > 0) {
        ArrayUtils.swap(queue, k, k / 2);
        k /= 2;
      } else {
        break;
      }
    }
  }
  
  private void siftDownFirstItem() {
    int k = 1;
    while (2 * k <= n) {
      int greaterChild;
      if (2 * k == n || ((E) queue[2 * k]).compareTo((E) queue[2 * k + 1]) >= 0) {
        greaterChild = 2 * k;
      } else {
        greaterChild = 2 * k + 1;
      }
      if (((E) queue[k]).compareTo((E) queue[greaterChild]) < 0) {
        ArrayUtils.swap(queue, k, greaterChild);
        k = greaterChild;
      } else {
        break;
      }
    }
  }
  
  private void resizeArray(int capacity) {
    Object[] temp = new Object[capacity];
    System.arraycopy(queue, 1, temp, 1, n);
    queue = temp;
  }
  
}
