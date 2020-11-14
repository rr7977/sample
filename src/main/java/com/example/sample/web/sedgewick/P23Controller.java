package com.example.sample.web.sedgewick;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sedgewick/p23")
public class P23Controller {

  @GetMapping("/isPrime/{n}")
  public boolean isPrime(@PathVariable int n) {
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

  @GetMapping("/squareRoot/{n}")
  public double squareRoot(@PathVariable double c) {

    // TODO /sedgewick/p23/squareRoot

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

  @GetMapping("/hypotenuse/{a}/{b}")
  public double hypotenuse(@PathVariable double a, @PathVariable double b) {
    return Math.sqrt(a * a + b * b);
  }

  @GetMapping("/harmonicNumber/{n}")
  public double harmonicNumber(@PathVariable int n) {
    double harmonicNumber = 0;
    for (double i = 1; i <= n; i++) {
      harmonicNumber += 1 / i;
    }
    return harmonicNumber;
  }

}