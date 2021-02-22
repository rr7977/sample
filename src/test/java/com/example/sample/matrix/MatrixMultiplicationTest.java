package com.example.sample.matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MatrixMultiplicationTest {

  @Test
  void test_arrayMatrixMultiplication_squareMatrix() {
    int[][] a = new int[3][3];
    int[][] b = new int[3][3];
    int counter = 1;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = counter;
        b[i][j] = counter;
        counter++;
      }
    }
    System.out.println(Arrays.deepToString(a));
    System.out.println(Arrays.deepToString(b));
    int[][] expected = new int[3][3];
    expected[0] = new int[]{30, 36, 42};
    expected[1] = new int[]{66, 81, 96};
    expected[2] = new int[]{102, 126, 150};
    int[][] actual = MatrixMultiplication.arrayMatrixMultiplication(a, b);
    System.out.println(Arrays.deepToString(actual));
    assertArrayEquals(expected, actual);
  }

  @Test
  void test_arrayMatrixMultiplication_rectangularMatrix() {
    int[][] a = new int[2][3];
    int[][] b = new int[3][1];
    int counter = 1;
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        a[i][j] = counter;
        counter++;
      }
    }
    System.out.println(Arrays.deepToString(a));
    counter = 1;
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[i].length; j++) {
        b[i][j] = counter;
        counter++;
      }
    }
    System.out.println(Arrays.deepToString(b));
    int[][] expected = new int[2][1];
    expected[0] = new int[]{14};
    expected[1] = new int[]{32};
    int[][] actual = MatrixMultiplication.arrayMatrixMultiplication(a, b);
    System.out.println(Arrays.deepToString(actual));
    assertArrayEquals(expected, actual);
  }
}
