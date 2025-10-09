public class King extends Piece {
    
    private final char label = 'K';
    
    public char getLabel() {
        return label;
    }

    public King(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            case WHITE:
                return "assets/white/king.png";
            case BLACK:
                return "assets/black/king.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {
       
    // }
}    