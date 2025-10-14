import java.util.ArrayList;

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
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/queen80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/queen80.png";
            default:
                return "";
        }
    }

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

    // public Cell[] getPossibleMoves() {

    // }

}