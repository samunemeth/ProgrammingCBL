import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    private static final int CANVAS_SIZE = 800;

    // The chess grid of the game.
    private Grid grid;

    // A modified JFrame acting as the canvas for the game.
    private Canvas canvas;

    /**
     * Create a new Chess Game.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGame::new);
    }

    /**
     * Resets the game state and creates a window. There is no game loop,
     * renderting happens only on demand.
     */
    public ChessGame() {

        resetGameState();
        initializeWindow();

    }

    /**
     * Initialize the game state.
     */
    private void resetGameState() {

        // Create new grid. The grid automatically sets up the starting position.
        grid = new Grid(CANVAS_SIZE);

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
        canvas.addMouseListener(new MouseHandler());
        frame.add(canvas);

        // Variables for button images
        Image image;
        Image newImg;

        // Validate Button
        JButton enterButton = new JButton();
        frame.add(enterButton);

        enterButton.setFocusable(false);
        ImageIcon checkmarkIcon = new ImageIcon("assets/buttons/check.jpg");
        image = checkmarkIcon.getImage();
        newImg = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
        checkmarkIcon = new ImageIcon(newImg);

        enterButton.setIcon(checkmarkIcon);
        // @TODO: FIXHERE!
        enterButton.setMnemonic(
                javax.swing.KeyStroke.getKeyStroke("ENTER").getKeyCode());
        enterButton.setToolTipText("Validate Move (Enter)");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.out.println("Enter button pressed");
            }
        });
        enterButton.setPreferredSize(new Dimension(80, 80));
        enterButton.setBounds(200, 300, 80, 80);

        // Dicard Button
        JButton crossButton = new JButton();
        frame.add(crossButton);

        crossButton.setFocusable(false);
        ImageIcon crossIcon = new ImageIcon("assets/buttons/cross.jpg");
        image = crossIcon.getImage();
        newImg = image.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
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
        crossButton.setPreferredSize(new Dimension(80, 80));
        crossButton.setBounds(200, 300, 80, 80);

        // Pack the elements and make the window visible.
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * A canvas for the chess board based on a JPanel.
     */
    class Canvas extends JPanel {

        /**
         * Modifies a JPanel object to act as a canvas to the game.
         */
        public Canvas() {
        }

        /*
         * JPanel Size
         * 
         * Force a panel size bz setting preferred, minimum, and maximum to the
         * same value.
         */

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(CANVAS_SIZE, CANVAS_SIZE);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(CANVAS_SIZE, CANVAS_SIZE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(CANVAS_SIZE, CANVAS_SIZE);
        }

        /**
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

    /**
     * An object that handles mouse presses inside the canvas.
     */
    class MouseHandler implements MouseListener {

        // Variables for moving pieces with clicks.
        private boolean hasPreviousClick = false;
        private int lastClickedX = 0;
        private int lastClickedY = 0;

        /*
         * Mouse Listeners
         */

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        /**
         * Handles mouse clicks inside the canvas. We are not interested in any
         * other actions, just clicks.
         */
        public void mouseClicked(MouseEvent e) {

            // Get the position of the cell the click happened in.
            int xPos = e.getX() / 100;
            int yPos = e.getY() / 100;

            // If there was a click before this, we have to move a piece from
            // the old location to this one. If there was no click before this,
            // we have to save the values for the next click.
            if (hasPreviousClick) {

                // Move the piece.
                grid.move(lastClickedX, lastClickedY, xPos, yPos);
                
                // Print the move to the console.
                System.out.print(Grid.coordinatesToChessNotation(lastClickedX, lastClickedY));
                System.out.print(":");
                System.out.println(Grid.coordinatesToChessNotation(xPos, yPos));

                // Clear previous click tracker.
                hasPreviousClick = false;

                // Remove the highlighting from the origin cell.
                grid.setHighlight(lastClickedX, lastClickedY, false);

            } else {

                // Set the flag for a previous click.
                hasPreviousClick = true;

                // Save the click location.
                lastClickedX = xPos;
                lastClickedY = yPos;

                // Add highlighting to the cell just clicked.
                grid.setHighlight(xPos, yPos, true);

            }

            // Repaint the canvas. This is needed wither way, as cell highlighting
            // at the least changes every time.
            canvas.repaint();

        }
    }

}
