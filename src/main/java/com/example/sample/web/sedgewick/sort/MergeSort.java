package com.example.sample.web.sedgewick.sort;

public class MergeSort {

  private MergeSort() {
  }

  /** auxiliary array for merges */
  private static int[] aux;

  public static void sort(int[] a) {
    aux = new int[a.length]; // Allocate space just once.
    sort(a, 0, a.length - 1);
  }

  // Sort a[lo..hi]
  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid); // Sort left half.
    sort(a, mid + 1, hi); // Sort right half.
    merge(a, lo, mid, hi); // Merge results (code on page 271).
  }

  /** Merge a[lo..mid] with a[mid+1..hi] */
  public static void merge(int[] a, int lo, int mid, int hi) {

    int i = lo;
    int j = mid + 1;

    // Copy a[lo..hi] to aux[lo..hi]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    // Merge back to a[lo..hi]
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
    }

  }

}