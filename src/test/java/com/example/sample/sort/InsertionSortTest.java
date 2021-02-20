package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

  @Test
  @Disabled
  void testInsertionSort() {
    int[] a = new Random().ints(100000).toArray();
    InsertionSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  @Disabled
  void testPractice() {
    int[] a = new Random().ints(100000).toArray();
    sortPractice(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  static int[] sortPractice(int[] a) {

    // 2,6,7,1,9,4,8,3,9,1,3,5,3,2

    for (int i = 1; i < a.length; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        ArrayUtils.swap(a, j, j - 1);
      }
    }

    return a;
  }

}
