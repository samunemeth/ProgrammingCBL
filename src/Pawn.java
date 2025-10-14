import java.util.ArrayList;

/**
 * Pawn piece type.
 */
public class Pawn extends Piece {

    public Pawn(PieceColor color) {
        super(color);
    }

    /**
     * Get the name of the asset file.
     */
    public String getAssetName() {
        return "pawn";
    }

    /**
     * Return the array of cells that are a valid destination for this piece.
     */
    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {

        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();
        
        int moveDirection = color == Piece.PieceColor.BLACK ? 1 : -1;
        
        // One step forward.
        if (parentYpos + moveDirection >= 0 && parentYpos + moveDirection < Grid.SIZE) {
            Cell toCell = grid.getCell(parentXpos, parentYpos + moveDirection);
            if (!toCell.hasPiece()) {
                possibleMoves.add(toCell);
            }
            if (parentXpos - 1 >= 0) {
                toCell = grid.getCell(parentXpos - 1, parentYpos + moveDirection);
                if (toCell.hasPiece() && toCell.getPiece().getColor() != color) {
                    possibleMoves.add(toCell);
                }
            }
            if (parentXpos + 1 < Grid.SIZE) {
                toCell = grid.getCell(parentXpos + 1, parentYpos + moveDirection);
                if (toCell.hasPiece() && toCell.getPiece().getColor() != color) {
                    possibleMoves.add(toCell);
                }
            }
        }
        
        // Add first row double move.
        if (color == Piece.PieceColor.WHITE && parentYpos == 6) {
            possibleMoves.add(grid.getCell(parentXpos, parentYpos - 2));
        }
        if (color == Piece.PieceColor.BLACK && parentYpos == 1) {
            possibleMoves.add(grid.getCell(parentXpos, parentYpos + 2));
        }

        return possibleMoves;
    }

}