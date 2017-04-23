package Model;

/**
 * Created by Raymond on 4/22/17.
 */
public class Piece {
    //Fields
    private int rank;
    private int file;
    private boolean isCaptured;
    private boolean isVisible;
    private PieceColor pieceColor;
    private PieceType pieceType;

    //Constructor;
    public Piece(PieceColor pieceColor, PieceType pieceType){
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
        isCaptured = false;
        isVisible = false;
    }

    //Methods
    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public void setRankAndFile(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public boolean isCaptured() {
        return isCaptured;
    }

    public void setCaptured() {
        isCaptured = true;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void toggleVisible(boolean visible) {
        isVisible = visible;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        if(pieceType == PieceType.PAWN) {
            this.pieceType = pieceType;
        }
    }
}
