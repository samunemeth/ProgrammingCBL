public class Bishop extends Piece {
    
    private final char label = 'B';
    
    public char getLabel() {
        return label;
    }

    public Bishop(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            case WHITE:
                return "assets/white/bishop.png";
            case BLACK:
                return "assets/black/bishop.png";
            default:
                return "";
        }
    }


    // public Cell[] getPossibleMoves() {

    // }

}