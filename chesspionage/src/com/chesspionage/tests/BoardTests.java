package com.chesspionage.tests;

import com.chesspionage.model.Board;
import com.chesspionage.model.PieceType;

/**
 * Created by r1413 on 4/22/17.
 */
public class BoardTests {
    public static void main(String[] args){
        System.out.println("Running BoardTests");
        testBoardSetup();
    }

    private static void testBoardSetup(){
        System.out.println("testBoardSetup: Should return true");
        Board board = new Board();
        PieceType[] piecePlacement = new PieceType[]{
                PieceType.ROOK,
                PieceType.KNIGHT,
                PieceType.BISHOP,
                PieceType.QUEEN,
                PieceType.KING,
                PieceType.BISHOP,
                PieceType.KNIGHT,
                PieceType.ROOK,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN,
                PieceType.PAWN
        };
        System.out.println(board.setupBoard(0,piecePlacement));

        System.out.println("testBoardSetup: Should return false");
        System.out.println(board.setupBoard(0,piecePlacement));

        System.out.println("testBoardSetup: Should return true");
        System.out.println(board.setupBoard(1,piecePlacement));

        System.out.println("testBoardSetup: Should return false");
        System.out.println(board.setupBoard(1,piecePlacement));
    }
}
