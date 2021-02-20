package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

  @Test
  @Disabled
  void testBubbleSort() {
    int[] a = new Random().ints(100000).toArray();
    BubbleSort.sort(a);
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

    // Following solution can be enhanced by adding a swapped flag to break outer for loop if no
    // swaps were made during any of the inner loops.

    for (int i = a.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (a[j] > a[j + 1]) {
          ArrayUtils.swap(a, j, j + 1);
        }
      }
    }
    return a;
  }

}
