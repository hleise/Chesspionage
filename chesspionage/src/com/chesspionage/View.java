package com.chesspionage;

import com.chesspionage.model.PieceColor;
import com.chesspionage.model.PieceType;
import com.chesspionage.model.Square;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public abstract class View {

  private static String boardString = ""
    + "          A           B           C           D           E           F           G           H      \n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 8  *     X     *     X     *     X     *     X     *     X     *     X     *     X     *     X     *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 7  *     X     *     X     *     X     *     X     *     X     *     X     *     X     *     X     *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 6  *           *           *           *           *           *           *           *           *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 5  *           *           *           *           *           *           *           *           *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 4  *           *           *           *           *           *           *           *           *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 3  *           *           *           *           *           *           *           *           *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 2  *     O     *     O     *     O     *     O     *     O     *     O     *     O     *     O     *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + " 1  *     O     *     O     *     O     *     O     *     O     *     O     *     O     *     O     *\n"
    + "    *           *           *           *           *           *           *           *           *\n"
    + "    * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";

  private static char[] board = boardString.toCharArray();

  private static Map<PieceType, Character> pieceStrings = new HashMap<PieceType, Character>() {{
    put(PieceType.PAWN, 'P');
    put(PieceType.KING, 'K');
    put(PieceType.QUEEN, 'Q');
    put(PieceType.KNIGHT, 'N');
    put(PieceType.ROOK, 'R');
    put(PieceType.BISHOP, 'B');
  }};

  private static Map<PieceColor, Character> colorStrings = new HashMap<PieceColor, Character>() {{
    put(PieceColor.DARK, 'X');
    put(PieceColor.LIGHT, 'O');
  }};

  private static Map<String, Integer> boardFiles = new HashMap<String, Integer>() {{
    put("a", 10);
    put("b", 22);
    put("c", 34);
    put("d", 46);
    put("e", 58);
    put("f", 70);
    put("g", 82);
    put("h", 94);
  }};

  private static Map<String, Integer> boardRanks = new HashMap<String, Integer>() {{
    put("8", 3 * 102);
    put("7", 7 * 102);
    put("6", 11 * 102);
    put("5", 15 * 102);
    put("4", 19 * 102);
    put("3", 23 * 102);
    put("2", 27 * 102);
    put("1", 31 * 102);
  }};

  private static Map<String, Integer> boardPositions = new HashMap<String, Integer>() {{
    for (String file: boardFiles.keySet()) {
      for (String rank: boardRanks.keySet()) {
        put(file + rank, boardFiles.get(file) + boardRanks.get(rank));
      }
    }
  }};

  public static void drawVisibleBoard(Square squares[][], PieceColor playerColor) {
    for (int squareRank = 0; squareRank < squares.length; squareRank++) {
      for (int squareFile = 0; squareFile < squares[squareRank].length; squareFile++) {
        Square square = squares[squareRank][squareFile];

        if (square.getPiece() == null) {
          continue;
        }

        if (square.getPiece().getPieceColor().equals(playerColor)) {
          board[boardPositions.get(square.getCoordinate())] = pieceStrings.get(square.getPiece().getPieceType());
        } else {
          board[boardPositions.get(square.getCoordinate())] = colorStrings.get(square.getPiece().getPieceColor());
        }
      }
    }

    System.out.println(board);
  }

  public static void drawHiddenBoard(Square squares[][]) {
    for (int squareRank = 0; squareRank < squares.length; squareRank++) {
      for (int squareFile = 0; squareFile < squares[squareRank].length; squareFile++) {
        Square square = squares[squareRank][squareFile];

        if (square.getPiece() == null) {
          continue;
        }

        board[boardPositions.get(square.getCoordinate())] = colorStrings.get(square.getPiece().getPieceColor());
      }
    }

    System.out.println(board);
  }
}

