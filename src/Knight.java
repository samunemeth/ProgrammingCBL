public class Knight extends Piece {

    private final char label = 'N';
    
    public char getLabel() {
        return label;
    }

    public Knight(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            case WHITE:
                return "assets/white/knight.png";
            case BLACK:
                return "assets/black/knight.png";
            default:
                return "";
        }
    }

    // public Cell[] getPossibleMoves() {

    // }

}