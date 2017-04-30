package com.chesspionage.tests;

import java.util.regex.*;

/**
 * Created by Raymond on 4/22/17.
 */
public class TestDriver {
  //Used for test driven development
  public static void main(String[] args) {
    UserTests.main(null);
    BoardTests.main(null);

    String string = "e1->e4";
    Pattern pattern = Pattern.compile("->");
    pattern = Pattern.compile("->||[ ]");
    for(String str: pattern.split(string)){
      System.out.println(str);
    }
  }
}
