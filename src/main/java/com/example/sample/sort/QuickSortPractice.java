package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class QuickSortPractice {

  private QuickSortPractice() {
  }

  public static int[] sort(int[] a) {
    sort(a, 0, a.length - 1);
    return a;
  }

  private static void sort(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int pivotIndex = partition(a, lo, hi);
    sort(a, lo, pivotIndex - 1);
    sort(a, pivotIndex + 1, hi);
  }

  private static int partition(int[] a, int lo, int hi) {

    int pivot = a[lo];
    int i = lo;
    int j = hi + 1;

    while (true) {

      while (a[++i] < pivot) {
        if (i == hi) {
          break;
        }
      }

      while (a[--j] > pivot) {
        if (j == lo) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      ArrayUtils.swap(a, i, j);
    }

    ArrayUtils.swap(a, lo, j);

    return j;
  }

}
