package com.example.sample.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SortTest {

  static int[] a = new Random().ints(100000).toArray();

  @BeforeEach
  void beforeEach() {
    ArrayUtils.shuffle(a);
  }

  @Test
  void bubbleSortTest() {
    BubbleSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void bubbleSortPracticeTest() {
    BubbleSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void selectionSortTest() {
    SelectionSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void selectionSortPracticeTest() {
    SelectionSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void insertionSortTest() {
    InsertionSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void insertionSortPracticeTest() {
    InsertionSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void shellSortTest() {
    ShellSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void shellSortPracticeTest() {
    ShellSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void mergeSortTest() {
    MergeSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void mergeSortPracticeTest() {
    MergeSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }


  @Test
  void quickSortTest() {
    QuickSort.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

  @Test
  void quickSortPracticeTest() {
    QuickSortPractice.sort(a);
    assertTrue(ArrayUtils.isSorted(a));
  }

}
