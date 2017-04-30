package com.chesspionage.model;

public class AIPlayer implements Player {
  //Fields
  private SkillLevel skillLevel;

  //Constructors
  public AIPlayer(SkillLevel skillLevel) {
    this.skillLevel = skillLevel;
  }

  //Methods
  public void makeMove() {
    //Do something
  }

  public Square calculateMove() {
    //Decide on a move based on board state and Strategy
    return new Square();
  }
}
