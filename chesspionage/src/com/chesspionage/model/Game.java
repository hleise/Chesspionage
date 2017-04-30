package com.chesspionage.model;

import java.util.*;
import java.util.regex.*;

import com.chesspionage.Utilities;
import com.chesspionage.View;

public class Game {
  //Fields
  public Board gameBoard;
  public Player[] players;
  public int playerTurn;
  public int winner;

  //Constructors
  public Game(int numPlayers) {
    gameBoard = new Board();

    setPieces(PieceColor.LIGHT);

    if (numPlayers == 2) { // Human Player
      setPieces(PieceColor.DARK);
    } else { // CPU Player
      aiSetPieces();
    }
  }

  //Methods

  public void setPieces(PieceColor playerColor)
  {
    int totalPieces = 16;
    Map<Character, Integer> pieceCounts = new HashMap<Character, Integer>() {{
      put('p', 8);
      put('r', 2);
      put('n', 2);
      put('b', 2);
      put('q', 1);
      put('k', 1);
    }};
    Map<Character, PieceType> pieceType = new HashMap<Character, PieceType>() {{
      put('p', PieceType.PAWN);
      put('r', PieceType.ROOK);
      put('n', PieceType.KNIGHT);
      put('b', PieceType.BISHOP);
      put('q', PieceType.QUEEN);
      put('k', PieceType.KING);
    }};

    while (totalPieces != 0)
    {
      Utilities.clearScreen();
      View.drawVisibleBoard(gameBoard.getBoardState(), playerColor);

      boolean set = false;
      Scanner reader = new Scanner(System.in);

      System.out.println();
      System.out.println("********************************");
      System.out.println("        Available Pieces        ");
      System.out.println("********************************");
      System.out.println("  P: " + pieceCounts.get('p'));
      System.out.println("  R: " + pieceCounts.get('r'));
      System.out.println("  N: " + pieceCounts.get('n'));
      System.out.println("  B: " + pieceCounts.get('b'));
      System.out.println("  Q: " + pieceCounts.get('q'));
      System.out.println("  K: " + pieceCounts.get('k'));

      while (!set) {
        PieceType currPiece = null;

        System.out.println("Enter a piece and position (ex: p->a2): ");
        String position = reader.next().toLowerCase();

        if (!Pattern.matches("[prnbqk]->[a-h][1-8]$", position)) {
          System.out.println("Invalid command (ex: p->h1)");
        } else {
          if (pieceCounts.get(position.charAt(0)) == null) {
            System.out.println("The piece you entered does not exist");
          } else {
            if (pieceCounts.get(position.charAt(0)) == 0) {
              System.out.println("You've already placed all of that piece type");
            } else {
              RankAndFile coordinate = new RankAndFile(position.substring(3, 5));
              if (gameBoard.isValidStartingPosition(coordinate) && gameBoard.squareIsEmpty(coordinate)) {
                currPiece = pieceType.get(position.charAt(0));
                pieceCounts.put(position.charAt(0), pieceCounts.get(position.charAt(0)) - 1);

                Piece piece = new Piece(playerColor, currPiece, coordinate);
                piece.setRankAndFile(coordinate.getRank(), coordinate.getFile());
                gameBoard.squares[coordinate.getRank()][coordinate.getFile()].setPiece(piece);

                set = true;
                totalPieces--;
              } else {
                System.out.println("Invalid coordinate: rank = " + coordinate.getRank() + " file = " + coordinate.getFile());
              }
            }
          }
        }
      }
    }
  }

  public void aiSetPieces() {
    PieceType aiSet[] = {
      PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN,
      PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN,
      PieceType.ROOK, PieceType.ROOK, PieceType.KNIGHT, PieceType.KNIGHT,
      PieceType.BISHOP, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING
    };

    Collections.shuffle(Arrays.asList(aiSet));
  }

  public void endGame() {
    //Do something
  }
}
