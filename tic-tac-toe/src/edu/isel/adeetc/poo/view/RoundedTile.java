package edu.isel.adeetc.poo.view;

import edu.isel.adeetc.poo.model.Board;

/**
 * UI component used to display player moves in a tic-tac-toe board.
 *
 * @see BoardView
 */
public class RoundedTile extends MoveTile {

    /**
     * Initiates the tile instance with the given associated move.
     *
     * @param move the move to be displayed, or null if there's no move in the position to which the tile corresponds.
     */
    public RoundedTile(Board.Move move) {
        super(move);
    }

    @Override
    public void paint() {
        if (move != null) {
            // TODO: Implement like a boss
            print(0, 1, 'O');
            print(1, 0, 'O');
            print(1, 2, 'O');
            print(2, 1, 'O');
        }
    }
}
