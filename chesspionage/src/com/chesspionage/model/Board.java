package com.chesspionage.model;

import java.util.ArrayList;

/* Board is essentially comprised of a 2d array of squares and contains relevant board methods */
public class Board {
  //Fields
  private Square[][] squares;
  private ArrayList<Piece> capturedPieces;

  //Constructors
  public Board() {
    //Initialize board fields
    squares = new Square[8][8];
    for (int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++){
        squares[i][j] = new Square(i, j);
      }
    }
    capturedPieces = new ArrayList<Piece>();
  }

  //Methods
  /* Adds a piece to the board */
  public void addPiece(Piece piece) {
    squares[piece.getFile()][piece.getRank()].setPiece(piece);
  }

  /* Returns the 2d array of squares */
  public Square[][] getBoardState() {
    //Return the contents of all squares on the board
    return squares;
  }

  public void setBoardState(Square[][] squares) {
    this.squares = squares;
  }

  public ArrayList<Piece> getCapturedPieces() {
    return capturedPieces;
  }

  public void addCapturedPiece(Piece piece) {
    this.capturedPieces.add(piece);
  }

  /* Returns whether a given coordinate is a valid starting position for a given player color */
  public boolean isValidStartingPosition(RankAndFile coordinate, PieceColor playerColor) {
    ArrayList<RankAndFile> validStartingPositions = getValidStartingPositions(playerColor);
    for (RankAndFile position: validStartingPositions) {
      if (coordinate.equals(position)) {
        return true;
      }
    }
    return false;
  }

  /* Returns an array of valid starting positions for a given player color */
  public ArrayList<RankAndFile> getValidStartingPositions(PieceColor playerColor) {
    ArrayList<RankAndFile> validPositions = new ArrayList<RankAndFile>();
    if (playerColor == PieceColor.LIGHT) {
      for (int rank = 0; rank < 2; rank++) {
        for (int file = 0; file < 8; file++) {
          RankAndFile coordinate = new RankAndFile(rank, file);
          if (squareIsEmpty(coordinate)) {
            validPositions.add(coordinate);
          }
        }
      }
    } else if (playerColor == PieceColor.DARK) {
      for (int rank = 6; rank < 8; rank++) {
        for (int file = 0; file < 8; file++) {
          RankAndFile coordinate = new RankAndFile(rank, file);
          if (squareIsEmpty(coordinate)) {
            validPositions.add(coordinate);
          }
        }
      }
    } else {
      System.out.println("getValidStartingPositions received non-valid PieceColor");
      System.exit(-1);
    }
    return validPositions;
  }

  /* Returns whether a square is empty or not. */
  public boolean squareIsEmpty(RankAndFile coordinate) {
    if (squares[coordinate.getRank()][coordinate.getFile()].getPiece() == null) {
      return true;
    }
    return false;
  }
}
