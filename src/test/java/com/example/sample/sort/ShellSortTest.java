package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

class ShellSortTest {

  @Test
  void testShellSort() {
    int[] a = new Random().ints(100000).toArray();
    ShellSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void testPractice() {
    int[] a = new Random().ints(100000).toArray();
    sortPractice(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  static void sortPractice(int[] a) {

    int n = a.length;

    // calculate the interval
    int h = 1;
    while (h < n / 3) {
      h = 3 * h + 1;
    }

    while (h >= 1) {
      for (int i = h; i < n; i++) {
        for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
          ArrayUtils.swap(a, j, j - h);
        }
      }

      h /= 3;
    }

  }
}
