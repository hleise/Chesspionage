package com.chesspionage;

import java.util.Map;

/* Holds general utility functions used throughout Chesspionage */
public class Utilities {
  /* Clears the terminal screen so the graphics seem to happen in place */
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /* Quits Chesspionage, but gives a goodbye message first */
  public static void quitChesspionage() {
    System.out.println("Thanks for playing Chesspionage!");
    System.exit(0);
  }
}
