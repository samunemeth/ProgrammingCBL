public class Grid {

    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    Cell[][] cells = new Cell[WIDTH][HEIGHT];

    public Grid() {

        // Fill that
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }

        // Initialise Black Pieces
        cells[0][0].setPiece(new Rook(Piece.PieceColor.BLACK));
        cells[1][0].setPiece(new Knight(Piece.PieceColor.BLACK));
        cells[2][0].setPiece(new Bishop(Piece.PieceColor.BLACK));
        cells[3][0].setPiece(new Queen(Piece.PieceColor.BLACK));
        cells[4][0].setPiece(new King(Piece.PieceColor.BLACK));
        cells[5][0].setPiece(new Bishop(Piece.PieceColor.BLACK));
        cells[6][0].setPiece(new Knight(Piece.PieceColor.BLACK));
        cells[7][0].setPiece(new Rook(Piece.PieceColor.BLACK));

        for (int i = 0; i < WIDTH; i++) {
            cells[i][1].setPiece(new Pawn(Piece.PieceColor.BLACK));
        }

        // Initialise White Pieces
        cells[0][7].setPiece(new Rook(Piece.PieceColor.WHITE));
        cells[1][7].setPiece(new Knight(Piece.PieceColor.WHITE));
        cells[2][7].setPiece(new Bishop(Piece.PieceColor.WHITE));
        cells[3][7].setPiece(new Queen(Piece.PieceColor.WHITE));
        cells[4][7].setPiece(new King(Piece.PieceColor.WHITE));
        cells[5][7].setPiece(new Bishop(Piece.PieceColor.WHITE));
        cells[6][7].setPiece(new Knight(Piece.PieceColor.WHITE));
        cells[7][7].setPiece(new Rook(Piece.PieceColor.WHITE));

        for (int i = 0; i < WIDTH; i++) {
            cells[i][6].setPiece(new Pawn(Piece.PieceColor.WHITE));
        }

    }

    public void printToConsole() {
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
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

}