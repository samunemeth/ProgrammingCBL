public class Pawn extends Piece {
    
    private final char label = 'P';
    
    public char getLabel() {
        return label;
    }

    public Pawn(PieceColor color) {
        super(color);
    }

    // public Cell[] getPossibleMoves() {

    // }

}