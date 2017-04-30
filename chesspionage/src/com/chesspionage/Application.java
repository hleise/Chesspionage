package com.chesspionage;

import com.chesspionage.model.Game;
import com.chesspionage.Utilities;

import java.util.Scanner;

/* Application is the main controller for Chesspionage */
public abstract class Application {
  static Scanner user_input = new Scanner(System.in);

  /* Prints the main Chesspionage menu */
  private static void printMenu() {
    System.out.println("****************************************************");
    System.out.println("             Welcome to Chesspionage!               ");
    System.out.println("****************************************************");
    System.out.println("  1. Single Player");
    System.out.println("  2. Two Player");
    System.out.println("  3. How to Play");
    System.out.println("  4. Quit");
  }

  /* Listens for menu user input and performs the correct action. */
  private static void getMenuInput() {
    String command = user_input.next();

    switch(command) {
      case("1"):
        Utilities.clearScreen();
        Game onePlayerGame = new Game(1);
        break;
      case("2"):
        Utilities.clearScreen();
        Game twoPlayerGame = new Game(2);
        break;
      case("3"):
        Utilities.clearScreen();
        printRules();
        break;
      case("4"):
        Utilities.quitChesspionage();
        break;
    }
  }

  /* Prints the rules for Chesspionage */
  private static void printRules() {
    System.out.println("Chesspionage Rules:");
    System.out.println();
    System.out.println("1. Chesspionage is a chess variant in which players cannot see the identity of their opponent's pieces.");
    System.out.println("2. Players begin the game by choosing the locations of their pieces in the first two rows of their side of the board.");
    System.out.println("3. Then, just like normal chess, players take turns moving their pieces.");
    System.out.println("4. Based on the way the opponent’s pieces move, players can begin to infer said pieces’ identities");
    System.out.println("5. The game ends once a king is captured");
    System.out.println();


    System.out.println("Press Enter to return to the menu");
    new Scanner(System.in).nextLine();
  }

  /* Loops back to the menu until the user decides to quit */
  public static void main(String[] args) {
    while(true) {
      Utilities.clearScreen();
      printMenu();
      getMenuInput();
    }
  }
}
