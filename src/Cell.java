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
    private boolean mark;

    // The side length of one cell in pixes.
    private int sideLength;

    /**
     * A cell on the chess grid.
     * 
     * @param x The x position of the cell on the grid from 0 to 7.
     * @param y The y position of the cell on the grid from 0 to 7.
     */
    public Cell(int x, int y, int sideLength) {

        // Store to instance variables.
        this.x = x;
        this.y = y;

        // Store the side length.
        this.sideLength = sideLength;

        // Determine the cell color based on the position.
        this.isLight = (x + y) % 2 == 0;

        // By default the cell is not highlighted.
        this.highlight = false;
        this.mark = false;

    }

    /*
     * Setters and Getters
     */

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

        if (highlight || (mark && hasPiece())) {
            bgColor = isLight ? new Color(177, 167, 252) : new Color(153, 144, 236);
        } else {
            bgColor = isLight ? new Color(236, 241, 251) : new Color(206, 216, 234);
        }

        // Fill the cell background with the color.
        graphics.setColor(bgColor);
        graphics.fillRect(x * sideLength, y * sideLength, sideLength, sideLength);

        // Show the piece if there is one.
        if (hasPiece()) {
            piece.show(graphics, x, y, sideLength);
        }

        // Draw a mark if there is one.
        if (mark && (!hasPiece())) {
            graphics.setColor(isLight ? new Color(177, 167, 252) : new Color(153, 144, 236));
            graphics.fillOval(x * sideLength + sideLength / 3,
                    y * sideLength + sideLength / 3,
                    sideLength / 3,
                    sideLength / 3);

        }

        // Set the font type, size and color.
        graphics.setFont(new Font("Default", Font.BOLD, sideLength / 6));
        graphics.setColor(new Color(52, 54, 74));

        // Draw the labels on the bottom and the left side.
        // There is some black magic happening with calculating the positions.
        if (x == 0) {
            graphics.drawString(Integer.toString(8 - y), x * sideLength + sideLength / 20,
                    y * sideLength + sideLength / 5);
        }
        if (y == 7) {
            graphics.drawString(Character.toString('A' + x), (x + 1) * sideLength - sideLength / 5,
                    (y + 1) * sideLength - sideLength / 20);
        }

    }

}