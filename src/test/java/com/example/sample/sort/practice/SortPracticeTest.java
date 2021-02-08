package com.example.sample.sort.practice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SortPracticeTest {

  static int[] a = new Random().ints(100000).toArray();

  @BeforeEach
  void beforeEach() {
    ArrayUtils.shuffle(a);
  }

  @Test
  void bubbleSortPracticeTest() {
    BubbleSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void selectionSortPracticeTest() {
    SelectionSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void insertionSortPracticeTest() {
    InsertionSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void shellSortPracticeTest() {
    ShellSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void mergeSortPracticeTest() {
    MergeSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }


  @Test
  void quickSortPracticeTest() {
    QuickSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

}
