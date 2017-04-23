package Model;

/**
 * Created by Raymond on 4/22/17.
 */
public class Square {
    //Fields
    private int i;
    private int j;
    private boolean isHighlighted;
    private Piece piece;

    //Constructors
    public Square(){
        //Do something
    }

    //Methods

    public boolean isHighlighted() {
        return isHighlighted;
    }

    public void setHighlighted(boolean highlighted) {
        isHighlighted = highlighted;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
