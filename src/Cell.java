import java.awt.Color;
import java.awt.Font;
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
        
        // Set the color based on the position of the cell on the board.
        graphics.setColor((x + y) % 2 == 0 ? new Color(236, 241, 251) : new Color(206, 216, 234));
        
        // Fill the cell background with the color.
        graphics.fillRect(x * 100, y * 100, 100, 100);

        // Show the piece if there is one.
        if (piece != null) {
            piece.show(graphics, x, y);
        }

        // Set the font type, size and color.
        graphics.setFont(new Font("Default", Font.BOLD, 16));
        graphics.setColor(new Color(52, 54, 74));
        
        // Draw the labels on the bottom and the side.
        if (x == 0) {
            graphics.drawString(Integer.toString(8 - y), x * 100 + 5, y * 100 + 20);
        }
        char label = 'A';
        if (y == 7) {
            graphics.drawString(Character.toString(label + x), x * 100 + 80, y * 100 + 95);
        }

    }
    
    
}