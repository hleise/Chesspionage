package com.chesspionage.model;

public class Piece {
  //Fields
  private int rank;
  private int file;
  private boolean isCaptured;
  private boolean isVisible;
  private boolean hasMoved;
  private PieceColor pieceColor;
  private PieceType pieceType;

  //Constructor;
  public Piece(PieceColor pieceColor, PieceType pieceType) {
    this.pieceColor = pieceColor;
    this.pieceType = pieceType;
    isCaptured = false;
    isVisible = false;
    hasMoved = false;
  }

  //Methods
  public int getRank() {
    return rank;
  }

  public int getFile() {
    return file;
  }

  public void setRankAndFile(int rank, int file) {
    this.rank = rank;
    this.file = file;
  }

  public boolean isCaptured() {
    return isCaptured;
  }

  public void setCaptured() {
    isCaptured = true;
  }

  public boolean isVisible() {
    return isVisible;
  }

  public void toggleVisible(boolean visible) {
    isVisible = visible;
  }

  public PieceType getPieceType() {
    return pieceType;
  }

  public void setPieceType(PieceType pieceType) {
    if (pieceType == PieceType.PAWN) {
      this.pieceType = pieceType;
    }
  }

  public PieceColor getPieceColor(){
    return pieceColor;
  }

  public void setHasMoved(){
    if(!hasMoved){
      hasMoved = true;
    }
  }
}
