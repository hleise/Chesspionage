package com.chesspionage.model;

import java.util.LinkedList;

public class Piece {
  //Fields
  protected boolean isCaptured;
  protected boolean isVisible;
  protected boolean hasMoved;
  protected PieceColor pieceColor;
  protected PieceType pieceType;
  protected RankAndFile coordinate;

  //Constructors
  public Piece(PieceColor pieceColor, PieceType pieceType) {
    this.coordinate = new RankAndFile(-1, -1);
    this.pieceColor = pieceColor;
    this.pieceType = pieceType;
    isCaptured = false;
    isVisible = false;
    hasMoved = false;
  }

  public Piece(PieceColor pieceColor, PieceType pieceType, RankAndFile rankAndFile){
    this.coordinate = rankAndFile;
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

  public LinkedList<RankAndFile> getValidMoves(Square[][] squares){
    LinkedList<RankAndFile> validMoves = new LinkedList<RankAndFile>();
    switch(pieceType){
      case PAWN:
        int verticalMovement;
        if(pieceColor == PieceColor.LIGHT){verticalMovement = 1;}
        else {verticalMovement = -1; }

        if(squares[coordinate.getRank()+verticalMovement][coordinate.getFile()].getPiece() == null) {
          validMoves.add(new RankAndFile(coordinate.getRank()+verticalMovement,coordinate.getFile()));
          if (!hasMoved && squares[coordinate.getRank() + 2 * verticalMovement][coordinate.getFile()].getPiece() == null) {
            validMoves.add(new RankAndFile(coordinate.getRank() + 2 * verticalMovement, coordinate.getFile()));
          }
        }
        if(squares[coordinate.getRank()+verticalMovement][coordinate.getFile()-1].getPiece() != null && squares[coordinate.getRank()+verticalMovement][coordinate.getFile()-1].getPiece().getPieceColor() != pieceColor){
          validMoves.add(new RankAndFile(coordinate.getRank()+verticalMovement,coordinate.getFile()-1));
        }
        if(squares[coordinate.getRank()+verticalMovement][coordinate.getFile()+1].getPiece() != null && squares[coordinate.getRank()+verticalMovement][coordinate.getFile()+1].getPiece().getPieceColor() != pieceColor){
          validMoves.add(new RankAndFile(coordinate.getRank()+verticalMovement,coordinate.getFile()+1));
        }
        //Add logic for trapping
        break;
      case QUEEN:
      case ROOK:
        //Check Ranks
        for(int i = coordinate.getRank()+1; i < 8; i++){
          if(squares[i][coordinate.getFile()].getPiece() == null){
            validMoves.add(new RankAndFile(i,coordinate.getFile()));
          } else if(squares[i][coordinate.getFile()].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,coordinate.getFile()));
            break;
          } else {
            break;
          }
        }
        for(int i = coordinate.getRank()-1; i >= 0; i--){
          if(squares[i][coordinate.getFile()].getPiece() == null){
            validMoves.add(new RankAndFile(i,coordinate.getFile()));
          } else if(squares[i][coordinate.getFile()].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,coordinate.getFile()));
            break;
          } else {
            break;
          }
        }
        //Check Files
        for(int i = coordinate.getFile()+1; i > 8; i++){
          if(squares[coordinate.getRank()][i].getPiece() == null){
            validMoves.add(new RankAndFile(coordinate.getRank(),i));
          } else if(squares[coordinate.getRank()][i].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(coordinate.getRank(),i));
            break;
          } else {
            break;
          }
        }
        for(int i = coordinate.getFile()-1; i <=0; i--){
          if(squares[coordinate.getRank()][i].getPiece() == null){
            validMoves.add(new RankAndFile(coordinate.getRank(),i));
          } else if(squares[coordinate.getRank()][i].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(coordinate.getRank(),i));
            break;
          } else {
            break;
          }
        }
        if(pieceType != PieceType.QUEEN){
          //Add logic for castling
          break;
        }
      case BISHOP:
        //Up and right
        int i = coordinate.getRank()+1;
        int j = coordinate.getFile()+1;
        while(i < 8 && j < 8){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j));
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j));
            break;
          } else {
            break;
          }
          i++;
          j++;
        }
        //Up and left
        i = coordinate.getRank()+1;
        j = coordinate.getFile()-1;
        while(i < 8 && j >= 0){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j));
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j));
            break;
          } else {
            break;
          }
          i++;
          j--;
        }
        //Down and left
        i = coordinate.getRank()-1;
        j = coordinate.getFile()-1;
        while(i >= 0 && j >= 0){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j));
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j));
            break;
          } else {
            break;
          }
          i--;
          j--;
        }
        //Down and right
        i = coordinate.getRank()-1;
        j = coordinate.getFile()+1;
        while(i >= 0 && j < 8){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j));
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j));
            break;
          } else {
            break;
          }
          i--;
          j++;
        }
        break;
      case KNIGHT:
        //Up and right
        int longLeg = 2;
        int shortLeg = 1;
        if(squares[coordinate.getRank()+longLeg][coordinate.getFile()+shortLeg].getPiece()== null || squares[coordinate.getRank()+longLeg][coordinate.getFile()+shortLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()+longLeg,coordinate.getFile()+shortLeg));
        if(squares[coordinate.getRank()+shortLeg][coordinate.getFile()+longLeg].getPiece() == null || squares[coordinate.getRank()+shortLeg][coordinate.getFile()+longLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()+shortLeg,coordinate.getFile()+longLeg));
        //Up and left
        if(squares[coordinate.getRank()+longLeg][coordinate.getFile()-shortLeg].getPiece() == null || squares[coordinate.getRank()+longLeg][coordinate.getFile()-shortLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()+longLeg,coordinate.getFile()-shortLeg));
        if(squares[coordinate.getRank()+shortLeg][coordinate.getFile()-longLeg].getPiece() == null || squares[coordinate.getRank()+shortLeg][coordinate.getFile()-longLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()+shortLeg,coordinate.getFile()-longLeg));
        //Down and left
        if(squares[coordinate.getRank()-longLeg][coordinate.getFile()-shortLeg].getPiece() == null || squares[coordinate.getRank()-longLeg][coordinate.getFile()-shortLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()-longLeg,coordinate.getFile()-shortLeg));
        if(squares[coordinate.getRank()-shortLeg][coordinate.getFile()-longLeg].getPiece() == null || squares[coordinate.getRank()-shortLeg][coordinate.getFile()-longLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()-shortLeg,coordinate.getFile()-longLeg));
        //Down and right
        if(squares[coordinate.getRank()-longLeg][coordinate.getFile()+shortLeg].getPiece() == null || squares[coordinate.getRank()-longLeg][coordinate.getFile()+shortLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()-longLeg,coordinate.getFile()+shortLeg));
        if(squares[coordinate.getRank()-shortLeg][coordinate.getFile()+longLeg].getPiece() == null || squares[coordinate.getRank()-shortLeg][coordinate.getFile()+longLeg].getPiece().pieceColor != pieceColor)
          validMoves.add(new RankAndFile(coordinate.getRank()-shortLeg,coordinate.getFile()+longLeg));
        break;
      case KING:
        for(int x = -1; x < 2; x++){
          for(int y = -1; y < 2; y++){
            if(x != 0 && y != 0){
              if(squares[coordinate.getRank()+x][coordinate.getFile()+y].getPiece() == null || squares[coordinate.getRank()+x][coordinate.getFile()+y].getPiece().getPieceColor() != pieceColor){
                validMoves.add(new RankAndFile(coordinate.getRank()+x,coordinate.getFile()+y));
              }
            }
          }
        }
        break;
    }
    return validMoves;
  }
}
