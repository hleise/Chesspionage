package com.chesspionage.model;

import com.chesspionage.Utilities;

import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanPlayer implements Player {
  /*
    Player's Control over the game
   */
  //Fields
  private PieceColor pieceColor;
  private Scanner user_input = new Scanner(System.in);

  //Constructor
  public HumanPlayer(PieceColor pieceColor){
    this.pieceColor = pieceColor;
  }

  //Methods
  public PlayerAction makeMove(Square[][] squares) {

    while(true){
      String command = user_input.next();
      switch(command.toLowerCase()){
        case("commands"):
          printOptions();
          break;
        case("2"):
          //Toggle piece logic
          return PlayerAction.TOGGLE;
        case("3"):
        case("captured"):
          //Show captured logic

          break;
        case("4"):
        case("quit"):
          //Game exit logic
          System.out.println("Goodbye!");
          return PlayerAction.QUIT;
        case("1"):
          System.out.println("Enter a string of the form [origin]->[destination] using the coordinates of the board");
          command = user_input.next().toLowerCase();
        default:
          Pattern pattern = Pattern.compile("^[a-h][1-8]->[a-h][1-8]$");
          Matcher matcher = pattern.matcher(command);
          boolean validCommand = matcher.matches();
          if(!validCommand){
            System.out.println("Invalid command: " + command + " Please try again");
            break;
          }
          //Move logic
          String[] splitCommand = Pattern.compile("->").split(command);
          RankAndFile fromSquare = new RankAndFile(splitCommand[0]);
          RankAndFile toSquare = new RankAndFile(splitCommand[1]);
          Piece playerPiece = squares[fromSquare.getRank()][fromSquare.getFile()].getPiece();
          Piece enemyPiece = squares[toSquare.getRank()][toSquare.getRank()].getPiece();
          if (playerPiece == null || playerPiece.getPieceColor() != pieceColor || (enemyPiece != null && enemyPiece.getPieceColor() == pieceColor)) {
            System.out.println("Invalid command. Please try again");
            break;
          }
          if(!playerPiece.getValidMoves(squares).contains(toSquare.rankAndFile)){
            System.out.println("Not a valid move. Please try again");
            break;
          }
          else{
            playerPiece.setRankAndFile(toSquare.getRank(),toSquare.getFile());
            squares[fromSquare.getRank()][fromSquare.getFile()].setPiece(null);
            squares[toSquare.getRank()][toSquare.getFile()].setPiece(playerPiece);
            if(enemyPiece != null){
              enemyPiece.setCaptured();
              System.out.println(enemyPiece.getPieceColor() + " " + enemyPiece.getPieceType() + " captured");
            }
          }
          return PlayerAction.PLAY;
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
