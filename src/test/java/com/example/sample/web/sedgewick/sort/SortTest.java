package com.example.sample.web.sedgewick.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SortTest {

  @Test
  void bubbleSortTest() {
    int[] a = new int[] { 34, 464, 782, 79, 46, 8269, 8976, 24, 6, 74524, 745, 7621, 1, 2, 3, 7, 5, 8, 0, 3, 5, 23, 5 };
    BubbleSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }
}