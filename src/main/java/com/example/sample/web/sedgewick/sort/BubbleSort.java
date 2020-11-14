package com.example.sample.web.sedgewick.sort;

public class BubbleSort {

  private BubbleSort() {
  }

  public static void sort(int[] a) {

    int hi = a.length - 1;
    int temp;

    for (int i = 0; i < hi + 1; i++, hi--) {
      for (int j = 0; j < hi; j++) {
        if (a[j] > a[j + 1]) {
          temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
  }
}