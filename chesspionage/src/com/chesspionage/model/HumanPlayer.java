package com.chesspionage.model;

import com.chesspionage.Utilities;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Raymond on 4/23/17.
 */
public class HumanPlayer implements Player {
  /*
    Player's Control over the game
   */
  //Fields
  private PieceColor pieceColor;
  private Scanner user_input = new Scanner(System.in);
  private Map<String,Integer> columnToInt;

  //Constructor
  public HumanPlayer(PieceColor pieceColor){
    this.pieceColor = pieceColor;
    columnToInt.put("a",0);
    columnToInt.put("b",1);
    columnToInt.put("c",2);
    columnToInt.put("d",3);
    columnToInt.put("e",4);
    columnToInt.put("f",5);
    columnToInt.put("g",6);
    columnToInt.put("h",7);
  }

  //Methods
  public void makeMove(Square[][] squares) {
    String command = user_input.next();
    while(true){
      switch(command.toLowerCase()){
        case("commands"):
          printOptions();
        case("2"):
          //Toggle piece logic
          break;
        case("3"):
        case("captured"):
          //Show captured logic
          break;
        case("4"):
        case("quit"):
          //Game exit logic
          break;
        case("1"):
          System.out.println("Enter a string of the form [origin]->[destination] using the coordinates of the board");
          command = user_input.next().toLowerCase();
        default:
          Pattern pattern = Pattern.compile("[a-h][1-8]->[a-h][1-8]");
          Matcher matcher = pattern.matcher(command);
          boolean validCommand = matcher.matches();
          if(!validCommand){
            System.out.println("Invalid command. Please try again");
            break;
          }
          //Move logic
          pattern = Pattern.compile("");
          String[] splitCommand = Pattern.compile("").split(command);
          Square fromSquare = squares[Integer.parseInt(splitCommand[1])-1][columnToInt.get(splitCommand[0])];
          Square toSquare = squares[Integer.parseInt(splitCommand[5])-1][columnToInt.get(splitCommand[4])];
          Piece playerPiece = fromSquare.getPiece();
          Piece enemyPiece = toSquare.getPiece();
          if (playerPiece == null || playerPiece.getPieceColor() != pieceColor || (enemyPiece != null && enemyPiece.getPieceColor() == pieceColor)) {
            System.out.println("Invalid command. Please try again");
            break;
          }
//          if(playerPiece.validMoves(squares).contains(fromSquare))
          return;
      }

    }
  }

  private void printOptions(){
    System.out.println("Choose an action");
    System.out.println("  1. Move Piece");
    System.out.println("  2. Show Piece");
    System.out.println("  3. Show Captured");
    System.out.println("  4. Quit to Menu");
  }
}
