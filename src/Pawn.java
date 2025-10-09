public class Pawn extends Piece {

    // Chess Notation
    private final char label = 'P';

    public char getLabel() {
        return label;
    }

    public Pawn(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/pawn80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/pawn80.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}