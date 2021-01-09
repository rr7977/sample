package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class BubbleSort {

  private BubbleSort() {}

  /**
   * 28 seconds for 100,000 random integers
   */
  public static void sort(int[] a) {

    for (int i = a.length - 1; i > 0; i--) {
      boolean swapped = false;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          ArrayUtils.swap(a, j, j + 1);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
  }

}
