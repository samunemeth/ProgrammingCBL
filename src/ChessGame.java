import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * A Simple chess game implementation.
 *
 * @author Samu Németh
 * @id 2252449
 * @author Arnav Gupta
 * @id 2243652
 */
public class ChessGame {

    // The size of the canvas inside the window in units of pixels.
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 800;

    // The size of the cells inside the window in units of pixels.
    private static final int CELL_WIDTH = 100;
    private static final int CELL_HEIGHT = 100;
    
    // The chess grid of the game.
    private Grid grid;
    
    // A modified JFrame acting as the canvas for the game.
    private Canvas canvas;
    
    /**
     * Create a new Chess Game.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGame::new);
    }
    
    public ChessGame() {
        
        resetGameState();
        initializeWindow();
    
    }
    
    /**
     * Initialize the game state.
     */
    private void resetGameState() {

        grid = new Grid();
        grid.printToConsole();

    }

    
    
    /**
     * Initialize the game window.
     */
    private void initializeWindow() {

        // Create a new window.
        JFrame frame = new JFrame("ChessGame");

        // Quit on window close.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new game panel.
        canvas = new Canvas();
        frame.add(canvas);

        // Pack the elements and make the window visible.
        frame.pack();
        frame.setVisible(true);

    }
    
    class Canvas extends JPanel {

        /**
         * Modifies a JPanel object to act as a canvas to the game.
         */
        public Canvas() {

            // Set a border for the panel.
            setBorder(BorderFactory.createLineBorder(Color.RED));

        }

        /*
         * JPanel Size
         * 
         * Force a panel size bz setting preferred, minimum, and maximum to the
         * same value.
         */

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
        }

        /*
         * JPanel Paint
         * 
         * Contains the instructions on how to draw the panel.
         */

        @Override
        public void paintComponent(Graphics g) {

            // Call the original function.
            super.paintComponent(g);

            // Cast the Graphics object into a Graphics2D object.
            Graphics2D graphics = (Graphics2D) g;

            // Draw grid.
            graphics.setColor(Color.GREEN);
            graphics.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        }

    }

}
