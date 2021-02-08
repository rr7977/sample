package com.example.sample.sort.practice;

public class MergeSortPractice {

  private MergeSortPractice() {
  }

  private static int[] aux;

  public static int[] sort(int[] a) {

    aux = new int[a.length];
    sort(a, 0, a.length - 1);

    return a;
  }

  static void sort(int[] a, int lo, int hi) {

    if (lo == hi) {
      return;
    }

    int mid = (lo + hi) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, hi);

  }

  static void merge(int[] a, int lo, int hi) {
    int mid = (lo + hi) / 2;
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        aux[k] = a[j++];
      } else if (j > hi) {
        aux[k] = a[i++];
      } else if (a[i] <= a[j]) {
        aux[k] = a[i++];
      } else {
        aux[k] = a[j++];
      }
    }

    System.arraycopy(aux, lo, a, lo, hi - lo + 1);

  }

}
