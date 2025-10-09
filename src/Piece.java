import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public abstract class Piece {
    
    protected Image image;
        
    public enum PieceColor {
        BLACK,
        WHITE
    }
    
    public PieceColor color;
        
    public PieceColor getColor() {
        return color;
    }

    // public abstract Cell[] getPossibleMoves();
    public abstract char getLabel();
    public abstract String getAssetPath();
    
    /**
     * Show the piece image.
     */
    public void show(Graphics2D graphics, int x, int y) {
        try {
            image = ImageIO.read(new File(getAssetPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (image != null) {
            graphics.drawImage(image, x * 100, y * 100, null);
        } else {
            // System.out.println("No image.");
        }
    }
    
    public Piece(PieceColor color) {
        this.color = color;

    }
}
