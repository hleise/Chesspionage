package com.chesspionage.model;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class EasyImplementation implements Strategy {
  public RankAndFile[] findMove(Square[][] squares, PieceColor pieceColor) {
    Piece playerPiece = null;
    Piece enemyPiece = null;
    RankAndFile fromSquare = null;
    RankAndFile toSquare = null;
    int fromRank = 0;
    int fromFile = 0;
    LinkedList<String> validMoves = null;

    outerloop:
    for (int x = 0; x < 8; x++) {
      for (int y = 0; y < 8; y++) {
        playerPiece = squares[x][y].getPiece();
        if (playerPiece != null && playerPiece.getPieceColor() == pieceColor)
        {
          validMoves = new LinkedList<String>(playerPiece.getValidMoves(squares));
          if (validMoves.peekFirst() != null)
          {
            fromRank = x;
            fromFile = y;
            break outerloop;
          }
        }
      }
    }
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
