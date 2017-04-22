package Model;

/**
 * Created by Raymond on 4/22/17.
 */
public class Board {
    //Fields
    private Piece[] pieceSet;
    private Square[] squares;
    private boolean boardSetup;

    //Constructors
    public Board(){
        //Initialize board fields
        pieceSet = new Piece[32];
        squares = new Square[64]; //Maybe increase the size of this by 32 to hold captured pieces?
        boardSetup = false;
    }

    //Methods
    public boolean setupBoard(){
        if(boardSetup) return false;
        //Set board pieces
        return true;
    }

    public Square[] getBoardState(){
        //Return the contents of all pieces on the board
        return squares;
    }
}
