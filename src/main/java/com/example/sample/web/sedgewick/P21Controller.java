package com.example.sample.web.sedgewick;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sedgewick/p21")
public class P21Controller {

  @GetMapping("/maximumOfArrayValues/{commaSeparatedValues}")
  public Double maximumOfArrayValues(@PathVariable String commaSeparatedValues) {
    String[] values = commaSeparatedValues.split(",");
    Double maxValue = Double.valueOf(values[0]);
    for (String value : values) {
      Double doubleValue = Double.valueOf(value);
      if (doubleValue > maxValue) {
        maxValue = doubleValue;
      }
    }
    return maxValue;
  }

  @GetMapping("/averageOfArrayValues/{commaSeparatedValues}")
  public Double averageOfArrayValues(@PathVariable String commaSeparatedValues) {
    String[] values = commaSeparatedValues.split(",");
    double N = values.length;
    double sum = 0D;
    for (String value : values) {
      sum = sum + Double.parseDouble(value);
    }
    return sum / N;
  }

  @GetMapping("/copyToAnotherArray/{charArrayString}")
  public char[] copyToAnotherArray(@PathVariable String charArrayString) {
    char[] charArray = charArrayString.toCharArray();
    int N = charArray.length;
    char[] anotherCharArray = new char[N];
    for (int i = 0; i < N; i++) {
      anotherCharArray[i] = charArray[i];
    }
    return anotherCharArray;
  }

  @GetMapping("/reverseArrayElements/{charArrayString}")
  public char[] reverseArrayElements(@PathVariable String charArrayString) {
    char[] charArray = charArrayString.toCharArray();
    int N = charArray.length;
    for (int i = 0; i < N / 2; i++) {
      char temp = charArray[i];
      charArray[i] = charArray[N - 1 - i];
      charArray[N - 1 - i] = temp;

    }
    return charArray;
  }

  @GetMapping("/arrayMatrixMultiplication")
  public int[][] arrayMatrixMultiplication(int[][] a, int[][] b) {

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