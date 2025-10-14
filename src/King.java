import java.util.ArrayList;

/**
 * King piece type.
 */
public class King extends Piece {
    
    public King(PieceColor color) {
        super(color);
    }
    
    /**
     * Get the name of the asset file.
     */
    public String getAssetName() {
        return "king";
    }

    /**
     * Return the array of cells that are a valid destination for this piece.
     */
    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {
        return new ArrayList<Cell>();
    }

}    