import java.util.ArrayList;

public class Bishop extends Piece {
    
    private final char label = 'B';
    
    public char getLabel() {
        return label;
    }

    public Bishop(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/bishop80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/bishop80.png";
            default:
                return "";
        }
    }

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


    // public Cell[] getPossibleMoves() {

    // }

}