public class Queen extends Piece {

    private final char label = 'Q';
    
    public char getLabel() {
        return label;
    }

    public Queen(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/queen80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/queen80.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}