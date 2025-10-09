import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    
    protected Image image;

    // Possible options for piece colour
    public enum PieceColor {
        BLACK,
        WHITE
    }
    
    public PieceColor color;

    // Gets colour of the piece
    public PieceColor getColor() {
        return color;
    }

    // public abstract Cell[] getPossibleMoves();

    public abstract char getLabel(); // Gets the piece notation
    public abstract String getAssetPath(); // Gets the piece's asset path to render image

    /**
     * Displays the piece
     * @param graphics Graphics object of the canvas
     * @param x xPosition of the cell on the grid
     * @param y yPosition of the cell on the grid
     */
    public void show(Graphics2D graphics, int x, int y) {
        if (image != null) {
            // TODO Don't hardcode the cell position values
            graphics.drawImage(image, x * 100 + 10, y * 100 + 10, 80,80, null);
        }
    }
    /**
     * Gets piece colour and tries get the asset path for the pieces
     * @param color
     */
    public Piece(PieceColor color) {
        this.color = color;

        // Reads the file path
        try {
            image = ImageIO.read(new File(getAssetPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
