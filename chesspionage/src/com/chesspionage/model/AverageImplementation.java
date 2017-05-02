package com.chesspionage.model;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class AverageImplementation implements Strategy {
  public RankAndFile[] findMove(Square[][] squares, PieceColor pieceColor) {
    Piece playerPiece = null;
    Piece enemyPiece = null;
    RankAndFile fromSquare = null;
    RankAndFile toSquare = null;
    int fromRank = 0;
    int fromFile = 0;
    LinkedList<String> validMoves = playerPiece.getValidMoves(squares);

    do {
      fromRank = ThreadLocalRandom.current().nextInt(0, 8);
      fromFile = ThreadLocalRandom.current().nextInt(0, 8);

      playerPiece = squares[fromRank][fromFile].getPiece();
    } while (playerPiece == null || playerPiece.getPieceColor() != pieceColor || validMoves.peekFirst() == null);
    fromSquare = new RankAndFile(fromRank, fromFile);


    do {
      int idx = ThreadLocalRandom.current().nextInt(validMoves.size());
      String validMove = validMoves.get(idx);
      toSquare = new RankAndFile(validMove);
      enemyPiece = squares[toSquare.getRank()][toSquare.getFile()].getPiece();
    } while (enemyPiece != null && enemyPiece.getPieceColor() == pieceColor);


    RankAndFile[] move = {fromSquare, toSquare};
    return move;
  }
}
