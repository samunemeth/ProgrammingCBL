import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;

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

        frame.setLayout(new FlowLayout());

        // Create a new game panel.
        canvas = new Canvas();
        frame.add(canvas);

        // Variables for button images
        Image image; 
        Image newImg;

        // Validate Button
        JButton enterButton = new JButton(); 
        frame.add(enterButton);
        
        enterButton.setFocusable(false);
        ImageIcon checkmarkIcon = new ImageIcon("assets\\buttons\\check.jpg");
        image = checkmarkIcon.getImage();
        newImg = image.getScaledInstance(80,80, java.awt.Image.SCALE_SMOOTH);
        checkmarkIcon = new ImageIcon(newImg);

        enterButton.setIcon(checkmarkIcon);
        // @TODO: FIXHERE!
        enterButton.setMnemonic(
            javax.swing.KeyStroke.getKeyStroke("ENTER").getKeyCode()
        );
        enterButton.setToolTipText("Validate Move (Enter)");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Enter button pressed");
            }
        });
        enterButton.setPreferredSize(new Dimension(80,80));
        enterButton.setBounds(200,300,80,80);

        // Dicard Button 
        JButton crossButton = new JButton(); 
        frame.add(crossButton);
        
        crossButton.setFocusable(false);
        ImageIcon crossIcon = new ImageIcon("assets\\buttons\\cross.jpg");
        image = crossIcon.getImage();
        newImg = image.getScaledInstance(80,80, java.awt.Image.SCALE_SMOOTH);
        crossIcon = new ImageIcon(newImg);

        crossButton.setIcon(crossIcon);
        // @TODO: FIXHERE!
        crossButton.setMnemonic(KeyEvent.VK_DELETE);
        crossButton.setToolTipText("Discard Move (Delete)");
        crossButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Detel button pressed");
            }
        });
        crossButton.setPreferredSize(new Dimension(80,80));
        crossButton.setBounds(200,300,80,80);


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
            // setBorder(BorderFactory.createLineBorder(Color.RED));

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
            // graphics.setColor(Color.GREEN);
            // graphics.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
            grid.show(graphics);

        }

    }

}
