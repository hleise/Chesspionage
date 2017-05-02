package com.chesspionage.model;

public interface Strategy {
  RankAndFile[] findMove(Square[][] squares, PieceColor pieceColor);
}
