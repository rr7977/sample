package com.example.sample.web.sedgewick;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class P23ControllerTest {

  @Autowired
  private P23Controller p23Controller;

  @Test
  void test_isPrime() {
    assertFalse(this.p23Controller.isPrime(1000033 * 101));
    assertTrue(this.p23Controller.isPrime(1000003));
  }

  @Test
  void test_squareRoot() {
    assertEquals(25, this.p23Controller.squareRoot(625));
    assertEquals(Precision.round(Math.sqrt(2), 10), Precision.round(this.p23Controller.squareRoot(2), 10));
  }

  @Test
  void test_hypotenuse() {
    assertEquals(5, this.p23Controller.hypotenuse(3, 4));
  }

  @Test
  void test_harmonicNumber() {
    assertEquals(2.92897, Precision.round(this.p23Controller.harmonicNumber(10), 5));
  }

}