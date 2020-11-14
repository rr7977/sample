package com.example.sample.web.sedgewick.sort;

import org.apache.commons.lang3.ArrayUtils;

public class ShellSort {

  private ShellSort() {
  }

  public static String sort(String s) {

    char[] a = s.toCharArray();
    int n = a.length;
    int h = 1;

    // 1, 4, 13, 40, 121, 364, 1093, ...
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    // h-sort the array.
    while (h >= 1) {
      // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]...
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && (a[j] < a[j - h]); j -= h) {
          ArrayUtils.swap(a, j, j - h);
        }
      }
      h = h / 3;
    }

    return String.valueOf(a);
  }
}