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
    public boolean setupBoard(int player, int[] pieceRank, int[] pieceFile){
        /*
        Takes as input the player number and pieceRank and pieceFile arrays

        pieceRank and pieceFile are each length 16 arrays which contain the index of it's location.
        Piece identity is by index: Pawn[0-7], Rook[8-9], Knight[10-11], Bishop[12-13], Queen[14], King[15]

        Returns true on success and false on failure and when pieces overlap or have invalid rank
         */
        if(boardSetup) return false;
        //Set board pieces
        int rank,file;
        PieceColor pieceColor = null;
        if(player == 0) {
            pieceColor = PieceColor.LIGHT;
        } else {
            pieceColor = PieceColor.DARK;
        }

        PieceType pieceType = PieceType.PAWN;
        for(int i = 0; i < 16; i++){
            rank = pieceRank[0];
            file = pieceFile[0];
            if(squares[8*rank + file].getPiece() != null){
                //If there is already a piece in the location in question
                return false;
            }
            switch(i){
                case 8|9:
                    pieceType = PieceType.ROOK;
                    break;
                case 10|11:
                    pieceType = PieceType.KNIGHT;
                    break;
                case 12|13:
                    pieceType = PieceType.BISHOP;
                    break;
                case 14:
                    pieceType = PieceType.QUEEN;
                    break;
                case 15:
                    pieceType = PieceType.KING;
                    break;
            }
            Piece newPiece = new Piece(pieceColor, pieceType);
            pieceSet[player*16 + i] = newPiece;
            squares[8*rank + file].setPiece(newPiece);
        }
        boardSetup = true;
        return true;
    }

    public Square[] getBoardState(){
        //Return the contents of all pieces on the board
        return squares;
    }
}
