package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Best case: nlogn Worst case: n^2 (quadratic) if input is alread sorted. Shuffle the array before
 * sorting to avoid this.
 */
public class QuickSort {

  private QuickSort() {
  }

  public static int[] sort(int[] a) {

    // Eliminate dependence on input by doing a random shuffle.
    // This will avoid quadratic running times like when the input is already sorted.
    ArrayUtils.shuffle(a);

    sort(a, 0, a.length - 1);
    return a;
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int pivotIndex = partition(a, lo, hi);
    sort(a, lo, pivotIndex - 1);
    sort(a, pivotIndex + 1, hi);
  }

  private static int partition(int[] a, int lo, int hi) {

    // 4,7,1,8,9,3,1,5,6,1,2

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
