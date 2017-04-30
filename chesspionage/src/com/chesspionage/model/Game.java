package com.chesspionage.model;

import java.lang.reflect.Array;
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
  private Map<Character, Integer> pieceCounts;
  private Map<Character, PieceType> pieceType;

  //Constructors
  public Game(int numPlayers) {
    gameBoard = new Board();

    this.pieceCounts = new HashMap<Character, Integer>() {{
      put('t', 16); // Total piece count
      put('p', 8);
      put('r', 2);
      put('n', 2);
      put('b', 2);
      put('q', 1);
      put('k', 1);
    }};

    this.pieceType = new HashMap<Character, PieceType>() {{
      put('p', PieceType.PAWN);
      put('r', PieceType.ROOK);
      put('n', PieceType.KNIGHT);
      put('b', PieceType.BISHOP);
      put('q', PieceType.QUEEN);
      put('k', PieceType.KING);
    }};

    setPieces(PieceColor.LIGHT, pieceCounts);

    if (numPlayers == 2) { // Human Player
      setPieces(PieceColor.DARK, pieceCounts);
    } else { // CPU Player
      //autoSetPieces(PieceColor.DARK, pieceCounts);
    }
  }

  //Methods

  public void setPieces(PieceColor playerColor, Map<Character, Integer> pieceCounts)
  {
    while (pieceCounts.get('t') != 0)
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

        if (position.equals("random")) {
          autoSetPieces(playerColor, pieceCounts);
          pieceCounts.put('t', 0);
          set = true;
        } else {
          if (!Pattern.matches("^[prnbqk]->[a-h][1-8]$", position)) {
            System.out.println("Invalid command (ex: p->h1)");
          } else {
            if (pieceCounts.get(position.charAt(0)) == null) {
              System.out.println("The piece you entered does not exist");
            } else {
              if (pieceCounts.get(position.charAt(0)) == 0) {
                System.out.println("You've already placed all of that piece type");
              } else {
                RankAndFile coordinate = new RankAndFile(position.substring(3, 5));
                if (gameBoard.isValidStartingPosition(coordinate, playerColor) && gameBoard.squareIsEmpty(coordinate)) {
                  currPiece = pieceType.get(position.charAt(0));
                  pieceCounts.put(position.charAt(0), pieceCounts.get(position.charAt(0)) - 1);

                  Piece piece = new Piece(playerColor, currPiece, coordinate);
                  piece.setRankAndFile(coordinate.getRank(), coordinate.getFile());
                  gameBoard.squares[coordinate.getRank()][coordinate.getFile()].setPiece(piece);

                  set = true;
                  pieceCounts.put('t', pieceCounts.get('t') - 1);
                } else {
                  System.out.println("Invalid coordinate: rank = " + coordinate.getRank() + " file = " + coordinate.getFile());
                }
              }
            }
          }
        }
      }
    }
  }

  public void autoSetPieces(PieceColor playerColor, Map<Character, Integer> pieceCounts) {
    while (pieceCounts.get('t') != 0) {
      ArrayList<PieceType> pieceArray = pieceMapToArray(pieceCounts);
      ArrayList<RankAndFile> startingPositions = gameBoard.getValidStartingPositions(playerColor);
      Collections.shuffle(startingPositions);

      for (RankAndFile position: startingPositions) {
        Piece piece = new Piece(playerColor, pieceArray.get(0), position);
        piece.setRankAndFile(position.getRank(), position.getFile());
        gameBoard.squares[position.getRank()][position.getFile()].setPiece(piece);
        pieceArray.remove(0);
      }
    }

    System.out.println("Press Enter to return to confirm piece placements");
    new Scanner(System.in).nextLine();
  }

  private ArrayList<PieceType> pieceMapToArray(Map<Character, Integer> pieceMap) {
    ArrayList<PieceType> pieceArray = new ArrayList<PieceType>();
    for (Character key: pieceMap.keySet()) {
      if (key != 't') {
        while (pieceMap.get(key) > 0) {
          pieceArray.add(pieceType.get(key));
          pieceMap.put(key, pieceMap.get(key) - 1);
        }
      }
    }
    return pieceArray;
  }

  public void endGame() {
    //Do something
  }
}
