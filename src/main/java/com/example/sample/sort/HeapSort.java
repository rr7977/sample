package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class HeapSort {
  
  public static int[] sort(int[] a) {
    int last = a.length - 1;
    // Build max heap
    for (int i = a.length / 2; i >= 0; i--) {
      siftDown(a, i, last);
    }
    // Sort
    while (last > 0) {
      ArrayUtils.swap(a, 0, last--);
      siftDown(a, 0, last);
    }
    return a;
  }
  
  static void siftDown(int[] a, int i, int last) {
    while (2 * i + 1 <= last) {
      int greaterChild;
      if (2 * i + 1 == last) {
        greaterChild = 2 * i + 1;
      } else {
        greaterChild = a[2 * i + 1] >= a[2 * i + 2] ? 2 * i + 1 : 2 * i + 2;
      }
      if (a[i] < a[greaterChild]) {
        ArrayUtils.swap(a, i, greaterChild);
        i = greaterChild;
      } else {
        break;
      }
    }
  }
  
}
