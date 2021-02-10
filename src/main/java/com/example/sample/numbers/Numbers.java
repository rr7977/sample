package com.example.sample.numbers;

public class Numbers {

  private Numbers() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i * i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static double squareRoot(double c) {

    if (c < 0) {
      return Double.NaN;
    }
    double err = 1e-15;
    double t = c;
    while (Math.abs(t - c / t) > err * t) {
      t = (c / t + t) / 2.0;
    }
    return t;
  }

  public static String getBinaryString(int n) {
    String result = "";
    for (int i = n; i > 0; i /= 2) {
      result = i % 2 + result;
    }
    return result;
  }

}
