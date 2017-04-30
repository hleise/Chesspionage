//package com.chesspionage.model;
//
//import jdk.internal.util.xml.impl.Pair;
//
//import java.util.LinkedList;
//import java.util.Map;
//
///**
// * Created by r1413 on 4/30/17.
// */
//public class Pawn extends Piece {
//  public Pawn(PieceColor pieceColor){
//    super(pieceColor, PieceType.PAWN);
//  }
//
//  public LinkedList validMoves(Square[][] squares){
//    int verticalMovement;
//    LinkedList validMoves = new LinkedList();
//    if(pieceColor == PieceColor.LIGHT){verticalMovement = 1;}
//    else {verticalMovement = -1; }
//
//    Square testSquare = squares[rank+verticalMovement][file];
//    if(testSquare.getPiece() == null) {
//      validMoves.add(testSquare);
//      testSquare = squares[rank + 2 * verticalMovement][file];
//      if (!hasMoved && testSquare.getPiece() == null) {
//        validMoves.add(testSquare);
//      }
//    }
//    testSquare = squares[rank+verticalMovement][file-1];
//    if(testSquare.getPiece() != null && testSquare.getPiece().getPieceColor() != pieceColor){
//      validMoves.add(testSquare);
//    }
//    //Add logic for trapping
//
//    return validMoves;
//  }
//}
