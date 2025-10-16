# CBL Chess Game

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
  - [ ] Check who the next player is.
    - Demo: players can only play moves in an alternate fashion with white
      starting.
  - [x] Validate the move.
    - Demo: Do not allow the piece to move if the move is incorrect.
    - Note: This requires that there is a function for each piece type that
      can determine if the piece can move there.
  - [ ] Add a box that displays the past moves.
    - Demo: Check if the rendered past moves are the same ones displayed in
      the terminal.
  - [ ] Add discard button. *(Learning Topic)*
    - Demo: Discard button discards the start and end position clicked while 
    - Note: Do not complete the move immediately, offer the option of
      discarding the move.
  - [ ] Add enter button. *(Learning Topic)*
    - Demo: Enter button performs and updates the positions accordingly
      otherwise doesn't do anything.
    - Note: Replace the mechanic of automatically completing the move.
  - [ ] Display the consequence of the move:
    - Demo: Performs the move and checks the results
    - Note: Check what kind of cell the piece is moving to.
  
> [!NOTE]
> If we have time, we may also implement special xxmoves
> or we may do checking of checks and checkmate.
> 
> We will not implement any kind of chess solving algorithm.

## Learning

We want to learn to do the following things with this project:

  - Version control and project management with git.
  - Adopting common design patterns concerning class structure.
  - Graphical user input handling.

## Resources

  - [Creating a Game in Swing](https://peerdh.com/blogs/programming-insights/creating-a-game-loop-in-java-swing)
  - [Designing a Chess Game](https://www.geeksforgeeks.org/dsa/design-a-chess-game/)
  - [Drawing Images](https://reintech.io/blog/java-2d-graphics-drawing-shapes-text-images)
  - [Chess Assets](https://www.figma.com/community/file/971870797656870866)
  - [Box Layout](https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html)
  - [Our Color Pallette](https://coolors.co/b1a7fc-9990ec-ecf1fb-ced8ea-ffcd70-f8be54)
