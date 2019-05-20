package edu.isel.adeetc.tictactoe.view;


import edu.isel.adeetc.poo.Tile;
import edu.isel.adeetc.tictactoe.model.Board;

/**
 * Base class for all UI component used to display player moves in a tic-tac-toe board.
 *
 * @see BoardView
 */
public abstract class MoveTile implements Tile {

    protected final Board.Move move;

    /**
     * Initiates the tile instance with the given associated move.
     * @param move the move to be displayed, or null if there's no move in the position to which the tile corresponds.
     */
    public MoveTile(Board.Move move) {
        this.move = move;
    }


    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
