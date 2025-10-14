import java.util.ArrayList;

/**
 * Rook piece type.
 */
public class Rook extends Piece {
    
    public Rook(PieceColor color) {
        super(color);
    }

    /**
     * Get the name of the asset file.
     */
    public String getAssetName() {
        return "rook";
    }

    /**
     * Return the array of cells that are a valid destination for this piece.
     */
    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {

        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();

        // Down Direction
        for (int i = parentYpos + 1; i < Grid.SIZE; i++) {
            Cell checkCell = grid.getCell(parentXpos, i);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Up Direction 
        for (int i = parentYpos - 1; i >= 0; i--) {
            Cell checkCell = grid.getCell(parentXpos, i);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Right Direction
        for (int i = parentXpos + 1; i < Grid.SIZE; i++) {
            Cell checkCell = grid.getCell(i, parentYpos);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Left Direction
        for (int i = parentXpos - 1; i >= 0; i--) {
            Cell checkCell = grid.getCell(i, parentYpos);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }


        return possibleMoves;
    }

}