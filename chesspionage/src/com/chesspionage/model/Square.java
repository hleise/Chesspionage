package com.chesspionage.model;

import com.chesspionage.model.RankAndFile;
import com.chesspionage.Utilities;

/* Square is comprised of a coordinate and an optional piece at that coordinate. */
public class Square {
  //Fields
  private RankAndFile coordinate;
  private Piece piece;

  //Constructors
  public Square(int rank, int file) {
    this.coordinate = new RankAndFile(rank, file);
    this.coordinate.setRankAndFile(coordinate.intToString.get(file) + (rank+1));
    this.piece = null;
  }

  //Methods

  /* Gets the piece located at the square. Returns null if one is not present. */
  public Piece getPiece() {
    return piece;
  }

  /* Returns the chess notation for the square coordinate */
  public String getCoordinate() { return this.coordinate.getRankAndFile(); }

  /* Sets the piece located at the square */
  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}
