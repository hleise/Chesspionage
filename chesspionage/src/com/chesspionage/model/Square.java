package com.chesspionage.model;

public class Square {
  //Fields
  private int rank;
  private int file;
  private String coordinate;
  private boolean isHighlighted;
  private Piece piece;

  //Constructors
  public Square() {
    isHighlighted = false;
    piece = null;
  }

  //Methods

  public boolean isHighlighted() {
    return isHighlighted;
  }

  public void setHighlighted(boolean highlighted) {
    isHighlighted = highlighted;
  }

  public Piece getPiece() {
    return piece;
  }

  public String getCoordinate() { return coordinate; }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }
}
