package com.chesspionage.model;

public class PieceFactory {
  public Piece createPiece(PieceType pieceType, PieceColor pieceColor) {
    Piece newPiece = null;
    switch(pieceType){
      case PAWN:
        newPiece = new Pawn(pieceColor);
        break;
      case ROOK:
        newPiece = new Rook(pieceColor);
        break;
      case KNIGHT:
        newPiece = new Knight(pieceColor);
        break;
      case BISHOP:
        newPiece = new Bishop(pieceColor);
        break;
      case QUEEN:
        newPiece = new Queen(pieceColor);
        break;
      case KING:
        newPiece = new King(pieceColor);
    }
    return newPiece;
  }
}
