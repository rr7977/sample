package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

  @Test
  @Disabled
  void testSelectionSort() {
    int[] a = new Random().ints(100000).toArray();
    SelectionSort.sort(a);
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

    for (int i = a.length - 1; i > 0; i--) {
      int maxIndex = i;
      for (int j = 0; j < i; j++) {
        if (a[j] > a[maxIndex]) {
          maxIndex = j;
        }
      }
      ArrayUtils.swap(a, i, maxIndex);
    }
    return a;
  }
}
