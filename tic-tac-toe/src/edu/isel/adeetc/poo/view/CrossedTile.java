package edu.isel.adeetc.poo.view;

import edu.isel.adeetc.poo.model.Board;

/**
 * UI component used to display player moves in a tic-tac-toe board.
 *
 * @see BoardView
 */
public class CrossedTile extends MoveTile {

    /**
     * Initiates the tile instance with the given associated move.
     *
     * @param move the move to be displayed, or null if there's no move in the position to which the tile corresponds.
     */
    public CrossedTile(Board.Move move) {
        super(move);
    }

    @Override
    public void paint() {
        if (move != null) {
            // TODO: Implement like a boss
            for (int i = 0; i < 3; i++) {
                print(i, i, 'x');
                print(3-i-1, i, 'x');
            }
        }
    }
}
