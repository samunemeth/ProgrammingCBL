# CBL Chess Game

This repository can be found here: []()

## Usage

Run the `ChessGame.java` file from the `src` directory to run the game.

White starts. You can click a piece to show what available moves it has.
You can click on the same piece again to cancel the selection, or press escape.
The possible moves are marked with blue circles. Clicking on one of the possible
destination squares moves the piece. After a move, it's the other players turn.
Therefore, you can only select black pieces after the first move, and so on.
The game ends when one player captures the other players king.

There are buttons on the side for special options. Then flags indicate the
resignation of the player on that side (the button next to white means white is
resigning and black wins). The center button indicates a draw. Both players have
to agree to a draw beforehand.

Navigation with only the keyboard is also possible. Focus on the game area, then
you can move the yellow cursor (that only apperas after pressing a key) with the
arrow keys, WASD or HJKL (it really is up to your preference). You can 'click' on
the cell the cursor is on with enter, and cancel a selection with escape.
You can use tab to move through the buttons and canvas itself. You can click
buttons with enter. This way, the game can be played with keyboard input only.

The game can end by capturing one of the kings, resignation or an agreed draw.
The window closes after the game is over.

## Synopsis

A simple hot seat implementation of a 2 player chess game.

<p align="center">
  <img src="./design-ideas/gui.png" width="80%"/><br/>
  <i>GUI Design Sketch</i>
</p>

## Backlog

*The items listed here are in the order of decreasing priority.*

  - [x] Creating class structure: *(Learning Topic)* 
    - Note: Simple classes that accommodate our use case well.
  - [x] Implement a grid:
    - Demo: Print the contents of the grid to the console.
    - Note: 2D array to console.
  - [x] Pieces:
    - Demo: Print the contents of the grid to the console.
    - Note: The cells are objects, and will have variables storing the piece.
  - [x] Show the grid and the Pieces:
    - Demo: Compare the pieces and grid displayed to the ones coded,
      and printed to the console.
    - Note: Display the background color of the grind and the pieces on top
      of that.
  - [x] Show the grid labels:
    - Demo: Check if the grid labels are correctly displayed.
    - Note: On the side of the canvas.
  - [x] Assign start positions:
    - Demo: The user interface displays the pieces as a regular starting
      position in chess would have them.
    - Note: Make sure the king and queen are in the right spots.
  - [x] ~~Move piece with from the terminal with positions, and update the piece
        position.~~
    - Note: Jumped to using clicking instead.
  - [x] Record what move have been played.
    - Demo: Do multiples moves from the terminal, and see if they are kept
      in an array correctly.
    - Note: Just display the list of moves after every move in the terminal.
  - [x] Moving with clicking. *(Learning Topic)*
    - Demo: Click the piece that you want to move, then click on the square
      that you want it to move to.
    - Note: Also make the clicked cells highlighted.
  - [x] Check who the next player is.
    - Demo: players can only play moves in an alternate fashion with white
      starting.
  - [x] Validate the move.
    - Demo: Do not allow the piece to move if the move is incorrect.
    - Note: This requires that there is a function for each piece type that
      can determine if the piece can move there.
  
> [!NOTE]
> If we have time, we may also implement special moves
> or we may do checking of checks and checkmate.
> 
> We will not implement any kind of chess solving algorithm.

## Learning

We want to learn to do the following things with this project:

  - Version control and project management with git.
  - Adopting common design patterns concerning class structure.
  - Graphical user input handling.
  - Accessible user input.

## Resources

  - [Creating a Game in Swing](https://peerdh.com/blogs/programming-insights/creating-a-game-loop-in-java-swing)
  - [Designing a Chess Game](https://www.geeksforgeeks.org/dsa/design-a-chess-game/)
  - [Drawing Images](https://reintech.io/blog/java-2d-graphics-drawing-shapes-text-images)
  - [Chess Assets](https://www.figma.com/community/file/971870797656870866)
  - [Box Layout](https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html)
  - [Our Color Pallette](https://coolors.co/b1a7fc-9990ec-ecf1fb-ced8ea-ffcd70-f8be54)
