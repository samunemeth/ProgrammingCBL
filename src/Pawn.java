import java.util.ArrayList;

public class Pawn extends Piece {

    // Chess Notation
    private final char label = 'P';

    public char getLabel() {
        return label;
    }

    public Pawn(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/pawn80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/pawn80.png";
            default:
                return "";
        }
    }

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
                if (toCell.hasPiece()) {
                    possibleMoves.add(toCell);
                }
            }
            if (parentXpos + 1 < Grid.SIZE) {
                toCell = grid.getCell(parentXpos + 1, parentYpos + moveDirection);
                if (toCell.hasPiece()) {
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

    // public Cell[] getPossibleMoves() {

    // }

}