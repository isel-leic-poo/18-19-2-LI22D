package edu.isel.adeetc.poo.view;

import edu.isel.adeetc.poo.model.Board;

/**
 * Class whose instances represent empty tiles on a tic-tac-toe board.
 *
 * @see BoardView
 */
public class EmptyTile extends MoveTile {

    /**
     * Initiates the tile instance with the given associated move.
     */
    public EmptyTile() {
        super(null);
    }
}
