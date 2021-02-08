package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class ShellSortPractice {

  private ShellSortPractice() {
  }

  public static void sort(int[] a) {

    int n = a.length;

    // calculate the interval
    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
          ArrayUtils.swap(a, j, j - h);
        }
      }

      h /= 3;
    }

  }
}
