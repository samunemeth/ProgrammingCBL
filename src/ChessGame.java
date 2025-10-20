import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

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

    ArrayList<Cell> possibleMoves = new ArrayList<Cell>();
    ArrayList<String> moveHistory = new ArrayList<String>();

    // Variables for moving pieces with clicks.
    private boolean hasPreviousClick = false;
    private int lastClickedX = 0;
    private int lastClickedY = 0;
    private Piece.PieceColor nextPlayerColor = Piece.PieceColor.WHITE;

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
     * rendering happens only on demand.
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
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

        // --- Canvas ---
        
        canvas = new Canvas();
        canvas.setFocusable(true);

        // Create and add input handler.
        InputHandler inputHandler = new InputHandler();
        canvas.addMouseListener(inputHandler);
        canvas.addKeyListener(inputHandler);

        frame.add(canvas);
        
        // --- Side Buttons ---
        
        Box sideButtons = new Box(BoxLayout.Y_AXIS);
        sideButtons.add(Box.createRigidArea(new Dimension(0, 5)));

        // --- Resign Button Black ---

        // Create the button with default settings.
        JButton resignButtonBlack = new JButton();
        resignButtonBlack.setToolTipText("Resign");
        resignButtonBlack.setFocusable(true);

        // Set the icon for the button.
        ImageIcon resignIconBlack = new ImageIcon(
                new ImageIcon("assets/buttons/resign-new.png").getImage()
                        .getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        resignButtonBlack.setIcon(resignIconBlack);

        // Set the size of the button 
        resignButtonBlack.setPreferredSize(new Dimension(80, 80));

        // Add listeners to the button.
        resignButtonBlack.addActionListener(e -> {

            int response = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to resign?", "Confirm Resignation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "White Wins");
            }

        });

        sideButtons.add(resignButtonBlack);
        sideButtons.add(Box.createRigidArea(new Dimension(0, 273)));
        
        // --- Draw Button ---

        // Create the button with default settings.
        JButton drawButton = new JButton();
        drawButton.setToolTipText("Draw");
        drawButton.setFocusable(true);

        // Set the icon for the button.
        ImageIcon drawIcon = new ImageIcon(
                new ImageIcon("assets/buttons/draw-new.png").getImage()
                        .getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        drawButton.setIcon(drawIcon);

        // Set the size of the button.
        drawButton.setPreferredSize(new Dimension(80, 80));

        // Add listeners to the button.
        drawButton.addActionListener(e -> {

            int response = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to draw?", "Confirm Draw",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "It's a Draw");
            }

        });

        sideButtons.add(drawButton);
        sideButtons.add(Box.createRigidArea(new Dimension(0, 273)));
        
        // --- Resign Button White ---

        // Create the button with default settings.
        JButton resignButtonWhite = new JButton();
        resignButtonWhite.setToolTipText("Resign");
        resignButtonWhite.setFocusable(true);

        // Set the icon for the button.
        ImageIcon resignIconWhite = new ImageIcon(
                new ImageIcon("assets/buttons/resign-new.png").getImage()
                        .getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
        resignButtonWhite.setIcon(resignIconWhite);

        // Set the size of the button 
        resignButtonWhite.setPreferredSize(new Dimension(80, 80));

        // Add listeners to the button.
        resignButtonWhite.addActionListener(e -> {

            int response = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you want to resign?", "Confirm Resignation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(frame, "Black Wins");
            }

        });
        
        sideButtons.add(resignButtonWhite);
        
        frame.add(sideButtons);

        // Pack the elements and make the window visible.
        frame.pack();
        frame.setVisible(true);

    }

    private void handleSelection(int xPos, int yPos) {

        // If there was a click before this, we have to move a piece from
        // the old location to this one. If there was no click before this,
        // we have to save the values for the next click.
        if (hasPreviousClick) {

            // Check if the click is on a different square.
            if (lastClickedX == xPos && lastClickedY == yPos) {

                // If the same cell is clicked, clear the selection.
                hasPreviousClick = false;
                possibleMoves.clear();
                grid.clearHighlightAndMark();

                // Repaint the canvas.
                canvas.repaint();

                return;
            }

            // Only allow moves that are valid.
            if (!possibleMoves.contains(grid.getCell(xPos, yPos))) {
                return;
            }

            // Move the piece.
            grid.move(lastClickedX, lastClickedY, xPos, yPos);
            
            // Change the next player after a move.
            nextPlayerColor = nextPlayerColor == Piece.PieceColor.WHITE
                    ? Piece.PieceColor.BLACK
                    : Piece.PieceColor.WHITE;

            // Add the move to the move history.
            moveHistory.add(Grid.coordinatesToChessNotation(lastClickedX, lastClickedY) + ":"
                    + Grid.coordinatesToChessNotation(xPos, yPos));

            // Clear previous click tracker, previous moves and highlights.
            hasPreviousClick = false;
            possibleMoves.clear();
            grid.clearHighlightAndMark();

        } else {

            // Check if there is a piece at the location.
            Cell clickedCell = grid.getCell(xPos, yPos);
            if (!clickedCell.hasPiece()) {
                return;
            }

            if (clickedCell.getPiece().getColor() != nextPlayerColor) {
                return;
            }

            // Save the possible moves.
            possibleMoves = clickedCell.getPiece().getPossibleMoves(grid, clickedCell);

            // Mark all the cells that a move can be made to.
            for (Cell cell : possibleMoves) {
                cell.setMark(true);
            }

            // Sete the flag for a previous click.
            hasPreviousClick = true;

            // Save the click location.
            lastClickedX = xPos;
            lastClickedY = yPos;

            // Add highlighting to the cell just clicked.
            grid.getCell(xPos, yPos).setHighlight(true);

        }

        // Repaint the canvas. This is needed wither way, as cell highlighting
        // at the least changes every time.

        canvas.repaint();
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
         * Force a panel size by setting preferred, minimum, and maximum to the
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
            grid.show(graphics);

        }

    }

    /**
     * An object that handles mouse presses inside the canvas.
     */
    class InputHandler implements MouseListener, KeyListener {

        // Store the position of the cursor on the grid.
        int cursorCurrentX = 3;
        int cursorCurrentY = 3;

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

            grid.getCell(cursorCurrentX, cursorCurrentY).setCursor(false);

            handleSelection(xPos, yPos);

        }

        /*
         * KeyListener
         *
         * Event handlers for keyboard input.
         */

        @Override
        public void keyPressed(KeyEvent e) {

            int xDelta = 0;
            int yDelta = 0;

            switch (e.getKeyCode()) {

                // Move up.
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                case KeyEvent.VK_K:

                    xDelta = 0;
                    yDelta = -1;

                    break;

                // Move down.
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                case KeyEvent.VK_J:

                    xDelta = 0;
                    yDelta = 1;

                    break;

                // Move left.
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                case KeyEvent.VK_H:

                    xDelta = -1;
                    yDelta = 0;

                    break;

                // Move right.
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                case KeyEvent.VK_L:

                    xDelta = 1;
                    yDelta = 0;

                    break;

                case KeyEvent.VK_ENTER:

                    handleSelection(cursorCurrentX, cursorCurrentY);

                    break;

                case KeyEvent.VK_ESCAPE:

                    // If the same cell is clicked, clear the selection.
                    hasPreviousClick = false;
                    possibleMoves.clear();
                    grid.clearHighlightAndMark();

                    break;

                default:
                    break;
            }

            grid.getCell(cursorCurrentX, cursorCurrentY).setCursor(false);

            cursorCurrentX = (8 + cursorCurrentX + xDelta) % 8;
            cursorCurrentY = (8 + cursorCurrentY + yDelta) % 8;

            grid.getCell(cursorCurrentX, cursorCurrentY).setCursor(true);

            canvas.repaint();

        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
