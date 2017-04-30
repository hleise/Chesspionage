package com.chesspionage;

import java.util.Map;

public class Utilities {
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  public static void quitChesspionage() {
    System.out.println("Thanks for playing Chesspionage!");
    System.exit(0);
  }
}
