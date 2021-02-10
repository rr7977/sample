package com.example.sample.matrix;

public class MatrixMultiplication {

  private MatrixMultiplication() {
    throw new IllegalStateException("Utility class");
  }

  public static int[][] arrayMatrixMultiplication(int[][] a, int[][] b) {

    int[][] c = new int[a.length][b[0].length];

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        c[i][j] = 0;
        for (int k = 0; k < a[i].length; k++) {
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }

    return c;
  }

}
