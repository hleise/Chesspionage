package com.chesspionage.model;

public class Piece {
  //Fields
  protected boolean isCaptured;
  protected boolean isVisible;
  protected boolean hasMoved;
  protected PieceColor pieceColor;
  protected PieceType pieceType;
  protected RankAndFile coordinate;

  //Constructor;
  public Piece(PieceColor pieceColor, PieceType pieceType) {
    this.coordinate = new RankAndFile(-1, -1);
    this.pieceColor = pieceColor;
    this.pieceType = pieceType;
    isCaptured = false;
    isVisible = false;
    hasMoved = false;
  }

  //Methods
  public int getRank() {
    return coordinate.getRank();
  }

  public int getFile() {
    return coordinate.getFile();
  }

  public void setRankAndFile(int rank, int file) {
    coordinate.setRank(rank);
    coordinate.setFile(file);
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

  public boolean getHasMoved(){
    return hasMoved;
  }
}
