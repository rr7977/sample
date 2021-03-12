package com.example.sample.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
  
  @Test
  void test() {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
    Integer[] integers = new Random().ints(100000).distinct().boxed().toArray(Integer[]::new);
    for (Integer integer : integers) {
      bst.put(integer, integer);
    }
    assertEquals(integers.length, bst.size());
    integers = new Integer[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
    bst = new BinarySearchTree<>();
    for (Integer integer : integers) {
      bst.put(integer, integer);
    }
    assertEquals(3, bst.size());
    assertEquals(3, bst.get(3));
  }
  
}
