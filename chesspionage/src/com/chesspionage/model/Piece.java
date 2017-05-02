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
        validMoves.addAll(validPawnMoves(squares, X, Y));
        break;
      case QUEEN:
      case ROOK:
        validMoves.addAll(validRookMoves(squares,X,Y));
        if(pieceType != PieceType.QUEEN){
          //Add logic for castling
          break;
        }
      case BISHOP:
        validMoves.addAll(validBishopMoves(squares,X,Y));
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


   private LinkedList<String> validPawnMoves(Square[][] squares, int X, int Y){
     LinkedList<String>  validMoves = new LinkedList<String>();
     int verticalMovement;
     if(pieceColor == PieceColor.LIGHT){verticalMovement = 1;}
     else {verticalMovement = -1; }

     for(int i = -1; i < 2; i++){
       try{
         if (squares[X+verticalMovement][Y+i].getPiece() == null){
           if(i == 0){
             //Forward Movement
             validMoves.add(RankAndFile.convert(X+verticalMovement,Y+i));
             if(squares[X+(2*verticalMovement)][Y+i].getPiece() == null){
               validMoves.add(RankAndFile.convert(X+(2*verticalMovement),Y+i));
             }
           } else {
             //Capturing en passant
             if(squares[X][Y+i].getPiece().getPieceColor() != pieceColor && squares[X-verticalMovement][Y+i].getPiece().getPieceColor() == pieceColor){
               validMoves.add(RankAndFile.convert(X+(2*verticalMovement),Y+i));
             }
           }
         } else {
           //Normal capture
           if(squares[X+verticalMovement][Y+i].getPiece().getPieceColor() != getPieceColor()){
             validMoves.add(RankAndFile.convert(X+verticalMovement, Y+i));
           }
         }

       } catch (ArrayIndexOutOfBoundsException e){
         continue;
       }
     }
     return validMoves;
   }

   private LinkedList<String> validRookMoves(Square[][] squares, int X, int Y){
     LinkedList<String> validMoves = new LinkedList<String>();
     boolean canGoUp = true;
     boolean canGoDown = true;
     boolean canGoLeft = true;
     boolean canGoRight = true;
     for(int i = 1; i < 8; i++){
       if(canGoUp){
         if(X+i > 7){
           canGoUp = false;
         } else {
           if(squares[X+i][Y].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X+i, Y));
           } else {
             if(squares[X+i][Y].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X+i, Y));
             }
             canGoUp = false;
           }
         }
       }
       if(canGoDown){
         if(X-i < 0){
           canGoDown = false;
         } else {
           if(squares[X-i][Y].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X-i, Y));
           } else {
             if(squares[X-i][Y].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X-i, Y));
             }
             canGoDown = false;
           }
         }
       }
       if(canGoRight){
         if(Y+i > 7){
           canGoRight = false;
         } else {
           if(squares[X][Y+i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X, Y+i));
           } else {
             if(squares[X][Y+i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X, Y+i));
             }
             canGoRight = false;
           }
         }
       }
       if(canGoLeft){
         if(Y-i < 0){
           canGoLeft = false;
         } else {
           if(squares[X][Y-i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X, Y-i));
           } else {
             if(squares[X][Y-i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X, Y-i));
             }
             canGoLeft = false;
           }
         }
       }
     }
     return validMoves;
   }

  private LinkedList<String> validBishopMoves(Square[][] squares, int X, int Y){
     LinkedList<String> validMoves = new LinkedList<String>();
     boolean UpRight = true;
     boolean UpLeft = true;
     boolean DownLeft = true;
     boolean DownRight = true;
     for(int i = 1; i < 8; i++){
       if(UpRight){
         if(X+i > 7 || Y+i > 7){
           UpRight = false;
         } else {
           if(squares[X+i][Y+i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X+i, Y+i));
           } else {
             if(squares[X+i][Y+i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X+i, Y+i));
             }
             UpRight = false;
           }
         }
       }
       if(UpLeft){
         if(X+i > 7 || Y-i < 0){
           UpLeft = false;
         } else {
           if(squares[X+i][Y-i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X+i, Y-i));
           } else {
             if(squares[X+i][Y-i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X+i, Y-i));
             }
             UpLeft = false;
           }
         }
       }
       if(DownLeft){
         if(X-i < 0 || Y-i < 0){
           DownLeft = false;
         } else {
           if(squares[X-i][Y-i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X-i, Y-i));
           } else {
             if(squares[X-i][Y-i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X-i, Y-i));
             }
             DownLeft = false;
           }
         }
       }
       if(DownRight){
         if(X-i < 0 || Y+i > 7){
           DownRight = false;
         } else {
           if(squares[X-i][Y+i].getPiece() == null) {
             validMoves.add(RankAndFile.convert(X-i, Y+i));
           } else {
             if(squares[X-i][Y+i].getPiece().getPieceColor() != pieceColor){
               validMoves.add(RankAndFile.convert(X-i, Y+i));
             }
             DownRight = false;
           }
         }
       }
     }
     return validMoves;
  }
}
