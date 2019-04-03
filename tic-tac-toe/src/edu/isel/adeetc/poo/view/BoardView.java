package edu.isel.adeetc.poo.view;

import edu.isel.adeetc.poo.model.Board;
import isel.poo.console.tile.TilePanel;

/**
 * Represents a UI component that displays the tic-tac-toe game board. Each game board position is displayed by using a
 * {@link MoveTile} instance.
 */
public class BoardView extends TilePanel {

    private final Board board;
    private final int tileSide;

    /**
     * Initiates an instance with the given associated board.
     * @param board The game board instance to be displayed.
     * @param tileSide The size of each tile.
     */
    public BoardView(Board board, int tileSide) {
        super(board.getSide(), board.getSide(), tileSide);
        this.board = board;
        this.tileSide = tileSide;
        for(int x = 0; x < board.getSide(); ++x) {
            for (int y = 0; y < board.getSide(); ++y) {
                Board.Move move = board.getMoveAt(x, y);
                if (move != null)
                    throw new IllegalArgumentException("Board should be empty.");
                setTile(x, y, new EmptyTile());
            }
        }
    }

    /**
     * Gets the view height.
     * @return the view height.
     */
    public int getHeight() {
        return board.getSide() * tileSide;
    }

    /**
     * Gets the view width.
     * @return the view width.
     */
    public int getWidth() {
        return board.getSide() * tileSide;
    }
}
