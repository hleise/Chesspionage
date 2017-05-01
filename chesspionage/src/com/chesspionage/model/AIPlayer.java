package com.chesspionage.model;

public class AIPlayer implements Player {
  //Fields
  private SkillLevel skillLevel;
  private PieceColor pieceColor;

  //Constructors
  public AIPlayer(PieceColor pieceColor, SkillLevel skillLevel) {
    this.skillLevel = skillLevel;
    this.pieceColor = pieceColor;
  }

  //Methods
  public PlayerAction makeMove(Square[][] squares) {
    //Do something
    return PlayerAction.PLAY;
  }
}
