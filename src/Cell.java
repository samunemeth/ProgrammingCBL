import java.awt.Graphics2D;

public class Cell {
    
    // Variables for storing the x and y position of the cell.
    private int x; 
    private int y; 
    
    private Piece piece;
    
    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    public Cell(int x, int y) {

        // Store to instance variables.
        this.x = x;
        this.y = y;

    }
    
    public void show(Graphics2D graphics) {

        piece.show(graphics, x, y);

    }
    
    
}