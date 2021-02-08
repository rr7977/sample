package com.example.sample.sort.practice;

import org.apache.commons.lang3.ArrayUtils;

public class SelectionSortPractice {

  private SelectionSortPractice() {
  }

  public static int[] sort(int[] a) {

    for (int i = a.length - 1; i > 0; i--) {
      int maxIndex = i;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[maxIndex]) {
          maxIndex = j;
        }
      }
      ArrayUtils.swap(a, i, maxIndex);
    }
    return a;
  }
}
