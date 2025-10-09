import java.awt.Color;
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
        
        // 206 216 234
        // 236 241 251
        graphics.setColor((x + y) % 2 == 0 ? new Color(236, 241, 251) : new Color(206, 216, 234));
        graphics.fillRect(x * 100, y * 100, 100, 100);

        if (piece != null) {
            piece.show(graphics, x, y);
        }

    }
    
    
}