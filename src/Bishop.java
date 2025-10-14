import java.util.ArrayList;

/**
 * Bishop piece type.
 */
public class Bishop extends Piece {

    public Bishop(PieceColor color) {
        super(color);
    }

    /**
     * Get the name of the asset file.
     */
    public String getAssetName() {
        return "bishop";
    }

    /**
     * Return the array of cells that are a valid destination for this piece.
     */
    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {

        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();

        // Down-Right Direction
        for (int i = parentXpos + 1, j = parentYpos + 1; i < Grid.SIZE && j < Grid.SIZE; i++, j++) {
            Cell checkCell = grid.getCell(i, j);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Down-Left Direction
        for (int i = parentXpos - 1, j = parentYpos + 1; i >= 0 && j < Grid.SIZE; i--, j++) {
            Cell checkCell = grid.getCell(i, j);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Up-Right Direction
        for (int i = parentXpos + 1, j = parentYpos - 1; i < Grid.SIZE && j >= 0; i++, j--) {
            Cell checkCell = grid.getCell(i, j);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            }
        }

        // Up-Left Direction
        for (int i = parentXpos - 1, j = parentYpos - 1; i >= 0 && j >= 0; i--, j--) {
            Cell checkCell = grid.getCell(i, j);
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