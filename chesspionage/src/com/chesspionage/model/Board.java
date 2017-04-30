package com.chesspionage.model;

import java.util.Arrays;

public class Board {
  //Fields
  public Square[][] squares;

  //Constructors
  public Board() {
    //Initialize board fields
    squares = new Square[8][8];
    for (int i = 0; i < 8; i++) {
      for(int j = 0; j < 8; j++){
        squares[i][j] = new Square(i + 1, j + 1);
      }
    }
  }

  //Methods
  public void addPiece(Piece piece) {
    squares[piece.getFile()][piece.getRank()].setPiece(piece);
  }

  public Square[][] getBoardState() {
    //Return the contents of all squares on the board
    return squares;
  }

  public boolean isValidStartingPosition(RankAndFile coordinate) {
    if (Arrays.asList(1, 2, 7, 8).contains(coordinate.getRank())) {
      if (coordinate.getFile() > 0 && coordinate.getFile() <= 8) {
        return true;
      }
    }
    return false;
  }

  public boolean squareIsEmpty(RankAndFile coordinate) {
    if (squares[coordinate.getRank()][coordinate.getFile()].getPiece() == null) {
      return true;
    }
    return false;
  }
}
