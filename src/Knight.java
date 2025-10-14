import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/knight80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/knight80.png";
            default:
                return "";
        }
    }

    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {

        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();
        
        int[][] possibleOffsets = new int[][]{
            {1, 2},
            {2, 1},
            {1, -2},
            {2, -1},
            {-1, 2},
            {-2, 1},
            {-1, -2},
            {-2, -1},
        };
        
        // Loop through all possible positions.
        for (int[] offsets : possibleOffsets) {
            int newXpos = parentXpos + offsets[0];
            int newYpos = parentYpos + offsets[1];
            
            if (newXpos >= 0 && newXpos < Grid.SIZE && newYpos >= 0 && newYpos < Grid.SIZE) {
                Cell toCell = grid.getCell(newXpos, newYpos);
                if (!toCell.hasPiece() || toCell.getPiece().getColor() != color) {
                    possibleMoves.add(toCell);
                }
            }

        }
        
        return possibleMoves;
    }

    // public Cell[] getPossibleMoves() {

    // }

}