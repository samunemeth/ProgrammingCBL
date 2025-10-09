public class Rook extends Piece {

    private final char label = 'R';
    
    public char getLabel() {
        return label;
    }
    
    public Rook(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/rook.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/rook.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}