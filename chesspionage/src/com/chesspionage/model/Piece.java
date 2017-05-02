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

  public LinkedList<String> getValidMoves(Square[][] squares){
    LinkedList<String> validMoves = new LinkedList<String>();
    int X,Y;
    X = coordinate.getRank();
    Y = coordinate.getFile();
    switch(pieceType){
      case PAWN:
        int verticalMovement;
        if(pieceColor == PieceColor.LIGHT){verticalMovement = 1;}
        else {verticalMovement = -1; }

        for(int i = -1; i < 2; i++){
          try{
            if (squares[X+verticalMovement][Y+i].getPiece() == null){
              if(i == 0){
                if(!hasMoved && squares[X+(2*verticalMovement)][Y].getPiece() == null){
                  //Starting move
                  validMoves.add(new RankAndFile(X+(2*verticalMovement),Y).getRankAndFile());
                }
                //Forward movement
                validMoves.add(new RankAndFile(X+verticalMovement,Y).getRankAndFile());
              }
            } else if(i != 0 && squares[X+verticalMovement][Y+i].getPiece().getPieceColor() != pieceColor){
              //Capturing
              validMoves.add(new RankAndFile(X+verticalMovement, Y+i).getRankAndFile());
            }

          } catch (ArrayIndexOutOfBoundsException e){
            continue;
          }
        }
        break;
      case QUEEN:
      case ROOK:
        //Check Ranks
        for(int i = X+1; i < 8; i++){
          if(squares[i][Y].getPiece() == null){
            validMoves.add(new RankAndFile(i,Y).rankAndFile);
          } else if(squares[i][Y].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,Y).rankAndFile);
            break;
          } else {
            break;
          }
        }
        for(int i = X-1; i >= 0; i--){
          if(squares[i][Y].getPiece() == null){
            validMoves.add(new RankAndFile(i,Y).rankAndFile);
          } else if(squares[i][Y].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,Y).rankAndFile);
            break;
          } else {
            break;
          }
        }
        //Check Files
        for(int i = Y+1; i < 8; i++){
          int t;
          if(squares[X][i].getPiece() == null){
            validMoves.add(new RankAndFile(X,i).rankAndFile);
          } else if(squares[X][i].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(X,i).rankAndFile);
            break;
          } else {
            break;
          }
        }
        for(int i = Y-1; i >=0; i--){
          int t;
          if(squares[X][i].getPiece() == null){
            validMoves.add(new RankAndFile(X,i).rankAndFile);
          } else if(squares[X][i].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(X,i).rankAndFile);
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
        int i = X+1;
        int j = Y+1;
        while(i < 8 && j < 8){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
            break;
          } else {
            break;
          }
          i++;
          j++;
        }
        //Up and left
        i = X+1;
        j = Y-1;
        while(i < 8 && j >= 0){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
            break;
          } else {
            break;
          }
          i++;
          j--;
        }
        //Down and left
        i = X-1;
        j = Y-1;
        while(i >= 0 && j >= 0){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
            break;
          } else {
            break;
          }
          i--;
          j--;
        }
        //Down and right
        i = X-1;
        j = Y+1;
        while(i >= 0 && j < 8){
          if(squares[i][j].getPiece() == null){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
          } else if(squares[i][j].getPiece().getPieceColor() != pieceColor){
            validMoves.add(new RankAndFile(i,j).rankAndFile);
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
        if(X+longLeg < 8 && Y+shortLeg < 8 && (squares[X+longLeg][Y+shortLeg].getPiece()== null || squares[X+longLeg][Y+shortLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X+longLeg,Y+shortLeg).rankAndFile);
        if(X+shortLeg < 8 && Y+longLeg < 8 && (squares[X+shortLeg][Y+longLeg].getPiece() == null || squares[X+shortLeg][Y+longLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X+shortLeg,Y+longLeg).rankAndFile);
        //Up and left
        if(X+longLeg < 8 && Y-shortLeg >= 0 && (squares[X+longLeg][Y-shortLeg].getPiece() == null || squares[X+longLeg][Y-shortLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X+longLeg,Y-shortLeg).rankAndFile);
        if(X+shortLeg < 8 && Y-longLeg >= 0 && (squares[X+shortLeg][Y-longLeg].getPiece() == null || squares[X+shortLeg][Y-longLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X+shortLeg,Y-longLeg).rankAndFile);
        //Down and left
        if(X-longLeg >=0 && Y-shortLeg >=0 && (squares[X-longLeg][Y-shortLeg].getPiece() == null || squares[X-longLeg][Y-shortLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X-longLeg,Y-shortLeg).rankAndFile);
        if(X-shortLeg >=0 && Y-longLeg >=0 && (squares[X-shortLeg][Y-longLeg].getPiece() == null || squares[X-shortLeg][Y-longLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X-shortLeg,Y-longLeg).rankAndFile);
        //Down and right
        if(X-longLeg >=0 && Y+shortLeg < 8 && (squares[X-longLeg][Y+shortLeg].getPiece() == null || squares[X-longLeg][Y+shortLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X-longLeg,Y+shortLeg).rankAndFile);
        if(X-shortLeg >=0 && Y+longLeg < 8 && (squares[X-shortLeg][Y+longLeg].getPiece() == null || squares[X-shortLeg][Y+longLeg].getPiece().pieceColor != pieceColor))
          validMoves.add(new RankAndFile(X-shortLeg,Y+longLeg).rankAndFile);
        break;
      case KING:
        for(int x = -1; x < 2; x++){
          for(int y = -1; y < 2; y++){
            if(x != 0 && y != 0){
              if(!(X+x > 7 || X+x < 0 || Y + y > 7 || Y+y < 0)) {

                if (squares[X + x][Y + y].getPiece() == null || squares[X + x][Y + y].getPiece().getPieceColor() != pieceColor) {
                  validMoves.add(new RankAndFile(X + x, Y + y).rankAndFile);
                }
              }
            }
          }
        }
        break;
    }
    return validMoves;
  }
}
