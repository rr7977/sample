package com.example.sample.sort.practice;

import org.apache.commons.lang3.ArrayUtils;

public class BubbleSortPractice {

  private BubbleSortPractice() {
  }

  public static int[] sort(int[] a) {

    // Following solution can be enhanced by adding a swapped flag to break outer for loop if no
    // swaps were made during any of the inner loops.

    for (int i = a.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          ArrayUtils.swap(a, j, j + 1);
        }
      }
    }
    return a;
  }

}
