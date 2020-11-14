package com.example.sample.web.sedgewick;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Ex1dot1Test {

  @Test
  void ex1dot1dot19() {
    String result = "";
    int N = 23;
    for (int n = N; n > 0; n /= 2) {
      result = n % 2 + result;
    }
    assertEquals("10111", result);
  }
}