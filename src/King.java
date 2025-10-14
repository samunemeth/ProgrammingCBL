import java.util.ArrayList;

public class King extends Piece {
    
    public King(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/king80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/king80.png";
            default:
                return "";
        }
    }

    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {
        return new ArrayList<Cell>();
    }

    // public Cell[] getPossibleMoves() {
       
    // }
}    