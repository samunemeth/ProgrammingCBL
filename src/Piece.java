import java.awt.Graphics2D;

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

    }
    
    public Piece(PieceColor color) {
        this.color = color;
    }
}
