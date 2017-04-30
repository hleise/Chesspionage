package com.chesspionage.model;
import com.sun.xml.internal.bind.v2.model.core.NonElement;

import java.util.*;

/**
 * Created by Raymond on 4/22/17.
 */
public class Game {
  //Fields
  public Board gameboard;
  public Player[] players;
  public int playerTurn;
  public int winner;

  //Constructors
  public Game(int numPlayers) {
    //Initialize fields
  }

  //Methods

  public PieceType[] setPieces()
  {
    int pieceCount = 16;
    int pawnCount = 8;
    int rookCount = 2;
    int knightCount = 2;
    int bishopCount = 2;
    int queenCount = 1;
    int kingCount = 1;

    PieceType[] pieceSet = new PieceType[16];
    String position = "x99";

    while (pieceCount != 0)
    {
      boolean set = false;
      PieceType currPiece = PieceType.NONE;
      Scanner reader = new Scanner(System.in);

      while (!set) {
        System.out.println(
          "P: " + pawnCount +
          "\nR: " + rookCount +
          "\nN: " + knightCount +
          "\nB: " + bishopCount +
          "\nQ: " + queenCount +
          "\nK: " + kingCount
        );

        System.out.println("Enter a piece and position: ");
        position = reader.next();

        switch (position.charAt(0)) {
          case 'p':
            if (pawnCount == 0) {
              System.out.println("No more pawns to place.");
              break;
            }
            currPiece = PieceType.PAWN;
            pawnCount--;
            set = true;
            break;
          case 'k':
            if (kingCount == 0) {
              System.out.println("King already placed.");
              break;
            }
            currPiece = PieceType.KING;
            kingCount--;
            set = true;
            break;
          case 'q':
            if (queenCount == 0) {
              System.out.println("Queen already placed.");
              break;
            }
            currPiece = PieceType.QUEEN;
            queenCount--;
            set = true;
            break;
          case 'n':
            if (knightCount == 0) {
              System.out.println("No more knights to place.");
              break;
            }
            currPiece = PieceType.KNIGHT;
            knightCount--;
            set = true;
            break;
          case 'b':
            if (bishopCount == 0) {
              System.out.println("No more bishops to place.");
              break;
            }
            currPiece = PieceType.BISHOP;
            bishopCount--;
            set = true;
            break;
          case 'r':
            if (rookCount == 0) {
              System.out.println("No more rooks to place.");
              break;
            }
            currPiece = PieceType.ROOK;
            rookCount--;
            set = true;
            break;
          default:
            System.out.println("Piece entered does not exist.");
        }
      }
      pieceSet[Character.getNumericValue(position.charAt(1))] = currPiece;
      pieceCount--;
    }

    return pieceSet;
  }
  public void createGame(int player2Type) {
    System.out.println("Place yer pieces:");
    PieceType[] p1PieceSet = new PieceType[16];
    PieceType[] p2PieceSet = new PieceType[16];
    p1PieceSet = setPieces();

    if (player2Type == 1) // Human player
    {
      System.out.println("Place yer pieces:");
      p2PieceSet = setPieces();
    }
    else // CPU Player
    {
      PieceType aiSet[] = {
                           PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN,
                           PieceType.PAWN, PieceType.PAWN, PieceType.PAWN, PieceType.PAWN,
                           PieceType.ROOK, PieceType.ROOK, PieceType.KNIGHT, PieceType.KNIGHT,
                           PieceType.BISHOP, PieceType.BISHOP, PieceType.QUEEN, PieceType.KING
                          };
      Collections.shuffle(Arrays.asList(aiSet));
      p2PieceSet = aiSet;
    }

    Board gameBoard = new Board();
    gameBoard.setupBoard(0, p1PieceSet);
    gameBoard.setupBoard(1, p2PieceSet);
  }

  public void endGame() {
    //Do something
  }
}
