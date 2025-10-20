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

        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();

        // Loop through all possible positions.
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                
                // Cant move to the origin cell.
                if (xOffset == 0 & yOffset == 0) {
                    continue;
                }

                int newXpos = parentXpos + xOffset;
                int newYpos = parentYpos + yOffset;

                if (newXpos >= 0 && newXpos < Grid.SIZE && newYpos >= 0 && newYpos < Grid.SIZE) {
                    Cell toCell = grid.getCell(newXpos, newYpos);
                    if (!toCell.hasPiece() || toCell.getPiece().getColor() != color) {
                        possibleMoves.add(toCell);
                    }
                }
            }

        }

        return possibleMoves;
    }

}    