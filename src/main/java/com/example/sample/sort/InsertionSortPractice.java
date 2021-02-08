package com.example.sample.sort;

import org.apache.commons.lang3.ArrayUtils;

public class InsertionSortPractice {

  private InsertionSortPractice() {
  }

  // 2,6,7,1,9,4,8,3,9,1,3,5,3,2

  public static int[] sort(int[] a) {

    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        ArrayUtils.swap(a, j, j - 1);
      }
    }

    return a;
  }

}
