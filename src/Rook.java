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
            case WHITE:
                return "assets/white/rook.png";
            case BLACK:
                return "assets/black/rook.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}