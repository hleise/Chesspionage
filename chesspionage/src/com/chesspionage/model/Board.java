package com.chesspionage.model;

/**
 * Created by Raymond on 4/22/17.
 */
public class Board {
    //Fields
    private Piece[] pieceSet;
    private Square[] squares;
    private boolean[] boardSetup;

    //Constructors
    public Board(){
        //Initialize board fields
        pieceSet = new Piece[32];
        squares = new Square[64]; //Maybe increase the size of this by 32 to hold captured pieces?
        boardSetup = new boolean[2];
        boardSetup[0] = false;
        boardSetup[1] = false;
        for(int i = 0; i < 64; i++){
            squares[i] = new Square();
        }
    }

    //Methods
    public boolean setupBoard(int player, PieceType[] piecePlacement){
        /*
        Takes as input an array corresponding to a player's piece set placement

        The piecePlacement array contains the pieceTypes that are located at what location within the players two starting rows.
        The bottom row is [0-7] and the top row is [9-15]

        Returns true on success and false on failure and when pieces overlap or have invalid rank
         */
        if(boardSetup[player]) return false;
        PieceColor pieceColor;
        if(player == 0) {
            pieceColor = PieceColor.LIGHT;
        } else {
            pieceColor = PieceColor.DARK;
        }

        for(int i = 0; i < 16; i++){
            //Place pieces in this array to start
            Piece newPiece = new Piece(pieceColor,piecePlacement[i]);
            pieceSet[player*16 + i] = newPiece;
            squares[player*48 + i].setPiece(newPiece);
        }

        boardSetup[player] = true;
        return true;
    }

    public Square[] getBoardState(){
        //Return the contents of all pieces on the board
        return squares;
    }
}
