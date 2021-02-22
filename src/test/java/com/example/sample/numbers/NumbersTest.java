package com.example.sample.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

class NumbersTest {

  @Test
  void test_isPrime() {
    assertFalse(Numbers.isPrime(1000033 * 101));
    assertTrue(Numbers.isPrime(1000003));
  }

  @Test
  void test_squareRoot() {
    assertEquals(25, Numbers.squareRoot(625));
    assertEquals(Precision.round(Math.sqrt(2), 10), Precision.round(Numbers.squareRoot(2), 10));
  }

  @Test
  void test_getBinaryString() {
    assertEquals("10111", Numbers.getBinaryString(23));
  }

}
