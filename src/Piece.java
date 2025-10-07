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
    
    public Piece(PieceColor color) {
        this.color = color;
    }
}
