import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * A generic chess piece or pawn of any color or type.
 */
public abstract class Piece {

    // The loaded image of the pieces asset.
    protected Image image;

    /**
     * A color of a piece. Can be black of white.
     */
    public enum PieceColor {
        BLACK,
        WHITE
    }

    // The color of the piece.
    public PieceColor color;

    /*
     * Abstract Methods
     */

    // Returns the path to the asset that must be used for this piece.
    public abstract String getAssetPath();

    // Returns an array of possible moves for this piece.
    public abstract ArrayList<Cell> getPossibleMoves(Grid grid, Cell parentCell);

    /*
     * Getters and Setters
     */

    public PieceColor getColor() {
        return color;
    }

    /**
     * Displays the piece over the grid. Uses pre-sized assets.
     * 
     * @param graphics Graphics object to render to.
     * @param x        The parent cell's x position.
     * @param y        The parent cell's y position.
     */
    public void show(Graphics2D graphics, int x, int y, int sideLength) {

        // Draw the appropriate image at the location determined by the black magic.
        graphics.drawImage(image,
                x * sideLength + sideLength / 10,
                y * sideLength + sideLength / 10,
                sideLength - sideLength / 5,
                sideLength - sideLength / 5,
                null);
    }

    /**
     * Gets piece colour and loads the asset for the piece.
     * 
     * @param color The color of the piece.
     */
    public Piece(PieceColor color) {

        // Save the piece color.
        this.color = color;

        // Get he path to the asset and load the file.
        try {
            image = ImageIO.read(new File(getAssetPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
