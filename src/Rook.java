import java.util.ArrayList;

public class Rook extends Piece {

    private final char label = 'R';
    
    public char getLabel() {
        return label;
    }
    
    public Rook(PieceColor color) {
        super(color);
    }

    public String getAssetPath() {
        switch (color) {
            // Returns the white piece asset path
            case WHITE:
                return "assets/white/rook80.png";
            // Returns the black piece asset path
            case BLACK:
                return "assets/black/rook80.png";
            default:
                return "";
        }
    }

    public ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell) {
        ArrayList<Cell> possibleMoves = new ArrayList<Cell>();

        int parentXpos = parentCell.getX();
        int parentYpos = parentCell.getY();

        
        // Up Direction
        for (int i = parentYpos + 1; i < Grid.SIZE; i++) {
            Cell checkCell = grid.getCell(parentXpos, i);
            if (!checkCell.hasPiece()) {
                possibleMoves.add(checkCell);
            } else {
                break;
            }
            /*  else if (checkCell.getPiece().getColor() != color) {
                possibleMoves.add(checkCell);
                break;
            } else {
                break;
            } */
        }

        // Down Direction 


        return possibleMoves;
    }
    

    // public Cell[] getPossibleMoves() {

    // }

}