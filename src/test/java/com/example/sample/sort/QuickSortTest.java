package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

class QuickSortTest {

  @Test
  void testQuickSort() {
    int[] a = new Random().ints(100000).toArray();
    QuickSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void testPractice() {
    int[] a = new Random().ints(100000).toArray();
    sortPractice(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  static int[] sortPractice(int[] a) {
    sort(a, 0, a.length - 1);
    return a;
  }

  static void sort(int[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }
    int pivotIndex = partition(a, lo, hi);
    sort(a, lo, pivotIndex - 1);
    sort(a, pivotIndex + 1, hi);
  }

  static int partition(int[] a, int lo, int hi) {

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
