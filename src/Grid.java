import java.awt.Graphics2D;

/**
 * A chess grid that holds cells. Has methods for moves and rendering.
 */
public class Grid {

    // The size of a chess grid.
    public static final int SIZE = 8;

    // The cells inside the grid.
    Cell[][] cells = new Cell[SIZE][SIZE];

    // The side length of one cell in pixes.
    private int sideLength;

    /**
     * Initialize the pieces on the chessboard as a regular starting position
     * from whites viewpoint.
     * 
     * @param canvasSideLength The side length of the canvas.
     */
    public Grid(int canvasSideLength) {

        // Calculate the side length from the size and canvas size.
        sideLength = canvasSideLength / SIZE;

        // Fill the grid of cells with new cells.
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(i, j, sideLength);
            }
        }

        // Initialise black pieces.
        cells[0][0].setPiece(new Rook(Piece.PieceColor.BLACK));
        cells[1][0].setPiece(new Knight(Piece.PieceColor.BLACK));
        cells[2][0].setPiece(new Bishop(Piece.PieceColor.BLACK));
        cells[3][0].setPiece(new Queen(Piece.PieceColor.BLACK));
        cells[4][0].setPiece(new King(Piece.PieceColor.BLACK));
        cells[5][0].setPiece(new Bishop(Piece.PieceColor.BLACK));
        cells[6][0].setPiece(new Knight(Piece.PieceColor.BLACK));
        cells[7][0].setPiece(new Rook(Piece.PieceColor.BLACK));

        // Initialize black pawns.
        for (int i = 0; i < SIZE; i++) {
            cells[i][1].setPiece(new Pawn(Piece.PieceColor.BLACK));
        }

        // Initialise white pieces.
        cells[0][7].setPiece(new Rook(Piece.PieceColor.WHITE));
        cells[1][7].setPiece(new Knight(Piece.PieceColor.WHITE));
        cells[2][7].setPiece(new Bishop(Piece.PieceColor.WHITE));
        cells[3][7].setPiece(new Queen(Piece.PieceColor.WHITE));
        cells[4][7].setPiece(new King(Piece.PieceColor.WHITE));
        cells[5][7].setPiece(new Bishop(Piece.PieceColor.WHITE));
        cells[6][7].setPiece(new Knight(Piece.PieceColor.WHITE));
        cells[7][7].setPiece(new Rook(Piece.PieceColor.WHITE));

        // Initialize white pawns.
        for (int i = 0; i < SIZE; i++) {
            cells[i][6].setPiece(new Pawn(Piece.PieceColor.WHITE));
        }

    }
    
    public static String coordinatesToChessNotation(int xPos, int yPos) {
        return Character.toString('A' + xPos) + Integer.toString(8 - yPos);
    }

    /**
     * Prints the grid to the console. Useful for debugging.
     * White pieces are capital letters while black pieces are lower case.
     * Empty squares are represented by dots.
     * (The method is a bit messy, but not used in production.)
     */
    public void printToConsole() {
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (cells[i][j].hasPiece()) {
                    if (cells[i][j].getPiece().getColor() == Piece.PieceColor.WHITE) {
                        System.out.print(Character.toUpperCase(cells[i][j].getPiece().getLabel()));
                    } else {
                        System.out.print(Character.toLowerCase(cells[i][j].getPiece().getLabel()));
                    }
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    /**
     * Renders the grid by rendering each individual cell.
     * 
     * @param graphics The graphics object to render to.
     */
    public void show(Graphics2D graphics) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j].show(graphics);
            }
        }

    }

    /**
     * Move a piece without checking any rules. Overrides the piece at the
     * destination and clears the starting cell.
     * 
     * @param fromX The starting x position.
     * @param fromY The starting y position.
     * @param toX   The destination x position.
     * @param toY   The destination y position.
     */
    public void move(int fromX, int fromY, int toX, int toY) {

        cells[toX][toY].setPiece(cells[fromX][fromY].getPiece());
        cells[fromX][fromY].setPiece(null);

    }

    public Cell getCell(int xPos, int yPos) {
        return cells[xPos][yPos];
    }

    /**
     * Sets the highlighted value of a cell.
     * 
     * @param xPos The x position of the cell.
     * @param yPos The y position of the cell.
     * @param val  The value to set highlighter to.
     */
    public void setHighlight(int xPos, int yPos, boolean val) {

        cells[xPos][yPos].setHighlight(val);

    }

}