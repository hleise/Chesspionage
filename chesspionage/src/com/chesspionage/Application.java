package com.chesspionage;

import com.chesspionage.model.Game;
import com.chesspionage.model.Piece;
import com.chesspionage.model.User;
import com.chesspionage.Utilities;
import com.chesspionage.model.PieceType;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by Raymond on 4/22/17.
 */

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
    System.out.println("  4. Profile");
    System.out.println("  5. Quit");
  }

  private static void getMenuInput() {
    String command = user_input.next();

    PieceType[] whitePieces = new PieceType[16];

    for (int i = 0; i < 16; i++) {
      whitePieces[i] = PieceType.PAWN;
    }

    PieceType[] blackPieces = new PieceType[16];

    for (int i = 0; i < 16; i++) {
      blackPieces[i] = PieceType.PAWN;
    }

    switch(command) {
      case("1"):
        Utilities.clearScreen();
        View.drawStartBoard(whitePieces, blackPieces);
        // Game onePlayerGame = new Game(1);
        break;
      case("2"):
        Utilities.clearScreen();
        View.drawStartBoard(whitePieces, blackPieces);
        // Game twoPlayerGame = new Game(2);
        break;
      case("3"):
        Utilities.clearScreen();
        printRules();
        break;
      case("4"):
        Utilities.clearScreen();
        profile();
        break;
      case("5"):
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

  private static void profile() {
    System.out.println("I'll figure this out later");
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
