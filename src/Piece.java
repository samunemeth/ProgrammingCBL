import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;

public abstract class Piece {
        
    public enum PieceColor {
        BLACK,
        WHITE
    }
    
    public PieceColor color;
        
    public PieceColor getColor() {
        return color;
    }

    // public abstract Cell[] getPossibleMoves();
    public abstract char getLabel();
    public abstract String getAssetPath();
    
    /**
     * Show the piece image.
     */
    public void show(Graphics2D graphics, int x, int y) {
        ImageIcon image = new ImageIcon(getAssetPath());
        graphics.drawImage(image.getImage(), x*100, y*100, null);
    }
    
    public Piece(PieceColor color) {
        this.color = color;
    }
}
