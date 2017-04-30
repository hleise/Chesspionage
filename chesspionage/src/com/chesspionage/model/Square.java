package com.chesspionage.model;

import com.chesspionage.model.RankAndFile;
import com.chesspionage.Utilities;

public class Square {
  //Fields
  private RankAndFile coordinate;
  private Piece piece;

  //Constructors
  public Square(int rank, int file) {
    this.coordinate = new RankAndFile(rank, file);
    this.coordinate.setRankAndFile(coordinate.intToString.get(file) + rank);
    this.piece = null;
  }

  //Methods

  public Piece getPiece() {
    return piece;
  }

  public String getCoordinate() { return this.coordinate.getRankAndFile(); }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}
