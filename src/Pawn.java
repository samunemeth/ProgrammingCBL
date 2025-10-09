public class Pawn extends Piece {
    
    private final char label = 'P';
    
    public char getLabel() {
        return label;
    }

    public Pawn(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            case WHITE:
                return "assets/white/pawn.png";
            case BLACK:
                return "assets/black/pawn.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}