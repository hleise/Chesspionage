package com.chesspionage;

import com.chesspionage.model.Game;
import com.chesspionage.model.User;
import com.chesspionage.Utilities;

import java.util.Scanner;

public abstract class Application {
  static Scanner user_input = new Scanner(System.in);
  private User user;

  private Application() {
    user = new User();
  }

  private static void printMenu() {
    System.out.println("****************************************************");
    System.out.println("             Welcome to Chesspionage!               ");
    System.out.println("****************************************************");
    System.out.println("  1. Single Player");
    System.out.println("  2. Two Player");
    System.out.println("  3. How to Play");
    System.out.println("  4. Quit");
  }

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

  private static void printRules() {
    System.out.println("This is the rules screen");
    System.out.println();
    System.out.println("Press Enter to return to the menu");

    new Scanner(System.in).nextLine();
  }

  public static void main(String[] args) {
    while(true) {
      Utilities.clearScreen();
      printMenu();
      getMenuInput();
    }
  }
}
