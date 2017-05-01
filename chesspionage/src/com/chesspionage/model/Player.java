package com.chesspionage.model;

public interface Player {
  PlayerAction makeMove(Square[][] squares);
}
