package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class InsertionSort {

  private InsertionSort() {}

  /**
   * Implementation in Sedgewick - takes 12 seconds for an array of 100,000 random integers
   */
  public static void sort(int[] a) {

    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        ArrayUtils.swap(a, j, j - 1);
      }
    }
  }

  /**
   * Implementation 2 - takes 4 seconds for an array of 100,000 random integers
   */
  static void sort2(int[] a) {
    for (int i = 1; i < a.length; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] < a[j]) {
          insertIntoSortedSubArray(a, i, j);
          break;
        }
      }
    }
  }

  static void insertIntoSortedSubArray(int[] a, int fromIndex, int toIndex) {
    int elementToInsert = a[fromIndex];
    for (int i = fromIndex; i > toIndex; i--) {
      a[i] = a[i - 1];
    }
    a[toIndex] = elementToInsert;
  }
}
