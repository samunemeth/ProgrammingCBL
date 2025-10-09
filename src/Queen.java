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
            case WHITE:
                return "assets/white/queen.png";
            case BLACK:
                return "assets/black/queen.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}