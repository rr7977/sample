package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class SelectionSort {

  private SelectionSort() {
  }

  // 4 seconds for 100,000 sample of integers
  public static void sort(int[] a) {

    for (int i = 0; i < a.length; i++) {
      int min = i;
      for (int j = i + 1; j < a.length; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      ArrayUtils.swap(a, i, min);
    }
  }
}
