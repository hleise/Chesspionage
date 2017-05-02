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
  public PlayerAction makeMove(Board board) {
    Square[][] squares = board.getBoardState();

    if (skillLevel == SkillLevel.Easy)
    {
      EasyImplementation easyStrat = new EasyImplementation();
      RankAndFile[] move = easyStrat.findMove(squares, pieceColor);
      Piece playerPiece = squares[move[0].getRank()][move[0].getFile()].getPiece();
      Piece enemyPiece = squares[move[1].getRank()][move[1].getRank()].getPiece();

      playerPiece.setRankAndFile(move[1].getRank(),move[1].getFile());
      squares[move[0].getRank()][move[0].getFile()].setPiece(null);
      squares[move[1].getRank()][move[1].getFile()].setPiece(playerPiece);
      if(enemyPiece != null)
      {
        enemyPiece.setCaptured();
        System.out.println(enemyPiece.getPieceColor() + " " + enemyPiece.getPieceType() + " captured");
      }
    }
    else if (skillLevel == SkillLevel.Average)
    {
      AverageImplementation avgStrat = new AverageImplementation();
      RankAndFile[] move = avgStrat.findMove(squares, pieceColor);
      Piece playerPiece = squares[move[0].getRank()][move[0].getFile()].getPiece();
      Piece enemyPiece = squares[move[1].getRank()][move[1].getRank()].getPiece();

      playerPiece.setRankAndFile(move[1].getRank(),move[1].getFile());
      squares[move[0].getRank()][move[0].getFile()].setPiece(null);
      squares[move[1].getRank()][move[1].getFile()].setPiece(playerPiece);
      if(enemyPiece != null)
      {
        enemyPiece.setCaptured();
        board.addCapturedPiece(enemyPiece, PieceColor.DARK);
        System.out.println(enemyPiece.getPieceColor() + " " + enemyPiece.getPieceType() + " captured");
      }
    }
    return PlayerAction.PLAY;
  }
}
