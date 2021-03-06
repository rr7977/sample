package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

class HeapSortTest {
  
  @Test
  void test() {
    int[] a = new Random().ints(100000).toArray();
    HeapSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }
  
  @Test
  void testPractice() {
    int[] a = new Random().ints(100000).toArray();
    sortPractice(a);
    assertTrue(ArrayUtils.isSorted(a));
  }
  
  static void sortPractice(int[] a) {
    int last = a.length - 1;
    
    // Build max heap
    for (int k = a.length / 2; k >= 0; k--) {
      siftDown(a, k, last);
    }
    
    // Sort
    while (last > 0) {
      ArrayUtils.swap(a, 0, last--);
      siftDown(a, 0, last);
    }
    
  }
  
  static void siftDown(int[] a, int k, int last) {
    int greaterChild;
    while (2 * k + 1 <= last) {
      if (2 * k + 1 == last) {
        greaterChild = 2 * k + 1;
      } else {
        greaterChild = a[2 * k + 1] >= a[2 * k + 2] ? 2 * k + 1 : 2 * k + 2;
      }
      if (a[k] < a[greaterChild]) {
        ArrayUtils.swap(a, k, greaterChild);
        k = greaterChild;
      } else {
        break;
      }
    }
  }
}
