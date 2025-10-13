import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * A cell inside the chess board. Can hold a piece.
 */
public class Cell {

    // Variables for storing the x and y position of the cell.
    private int x;
    private int y;

    // Stores the piece that is on this cell.
    private Piece piece;

    // Variables to keep track of some visuals.
    private boolean isLight;
    private boolean highlight;

    // The size of the cells inside the window in units of pixels.
    private static final int CELL_WIDTH = 100;
    private static final int CELL_HEIGHT = 100;

    /**
     * A cell on the chess grid.
     * 
     * @param x The x position of the cell on the grid from 0 to 7.
     * @param y The y position of the cell on the grid from 0 to 7.
     */
    public Cell(int x, int y) {

        // Store to instance variables.
        this.x = x;
        this.y = y;

        // Determine the cell color based on the position.
        this.isLight = (x + y) % 2 == 0;

        // By default the cell is not highlighted.
        this.highlight = false;

    }

    /*
     * Setters and Getters
     */

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    /**
     * Shows the cell and the piece within it if there is one.
     * 
     * @param graphics The graphics to render onto.
     */
    public void show(Graphics2D graphics) {

        // The color to fill the cells background with.
        // Selected by looking at cell color and highlighter status.
        Color bgColor;

        if (highlight) {
            bgColor = isLight ? new Color(177, 167, 252) : new Color(153, 144, 236);
        } else {
            bgColor = isLight ? new Color(236, 241, 251) : new Color(206, 216, 234);
        }

        // Fill the cell background with the color.
        graphics.setColor(bgColor);
        graphics.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);

        // Show the piece if there is one.
        if (piece != null) {
            piece.show(graphics, x, y);
        }

        // Set the font type, size and color.
        graphics.setFont(new Font("Default", Font.BOLD, CELL_WIDTH / 6));
        graphics.setColor(new Color(52, 54, 74));

        // Draw the labels on the bottom and the left side.
        // There is some black magic happening with calculating the positions.
        if (x == 0) {
            graphics.drawString(Integer.toString(8 - y), x * CELL_WIDTH + CELL_WIDTH / 20,
                    y * CELL_HEIGHT + CELL_HEIGHT / 5);
        }
        if (y == 7) {
            graphics.drawString(Character.toString('A' + x), (x + 1) * CELL_WIDTH - CELL_WIDTH / 5,
                    (y + 1) * CELL_HEIGHT - CELL_HEIGHT / 20);
        }

    }

}