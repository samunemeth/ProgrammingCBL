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
    
    Grid grid;
    
    /**
     * Create a new Chess Game.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChessGame::new);
    }
    
    public ChessGame() {
        grid = new Grid();
        grid.printToConsole();
    }
}
