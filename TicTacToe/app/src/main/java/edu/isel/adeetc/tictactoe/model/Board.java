package edu.isel.adeetc.tictactoe.model;

import java.util.LinkedList;

/**
 * Class whose instances represent the tic-tac-toe game board.
 */
public class Board {

    /**
     * Contract to be supported by all interested parties on receiving notifications for model changes.
     */
    public interface ChangeListener {

        /**
         * Signals that a change as occurred on the board.
         * @param board the board instance from where the notification originates.
         * @param x the horizontal coordinate of the change.
         * @param y the vertical coordinate of the change.
         */
        void boardChanged(Board board, int x, int y);

        /**
         * Signals that the game is completed and a winner was found.
         * @param winner the winner.
         */
        void andTheWinnerIs(Player winner);
    }

    public static class ChangeAdapter implements ChangeListener {
        @Override
        public void boardChanged(Board board, int x, int y) { }

        @Override
        public void andTheWinnerIs(Player winner) { }
    }

    /**
     * Class whose instances represent moves.
     */
    public static class Move {
        /** The board coordinates of the move. */
        public final Coordinate coordinate;
        /** The player instance that made the move. */
        public final Player player;
        public Move(int x, int y, Player player) {
            this.coordinate = new Coordinate(x, y);
            this.player = player;
        }
    }

    private static final int SIDE = 3;

    /**
     * Helper method used to check if there are any free positions in the game board.
     * @return {@literal true} if there are empty positions, {@literal false} otherwise.
     */
    private boolean hasFreePositions() {
        return moves != SIDE * SIDE;
    }

    /**
     * Helper method used to chek if the given arguments represent coordinates within the board bounds.
     * @param x the horizontal coordinate to be checked.
     * @param y the vertical coordinate to be checked.
     */
    private void checkBounds(int x, int y) {
        if (x < 0 || x >= SIDE || y < 0 || y >= SIDE) {
            throw new IllegalArgumentException("Invalid move coordinates (" + x + ", " + y + ")");
        }
    }

    /**
     * Gets the player instance at the given coordinates.
     * @param x the horizontal coordinate.
     * @param y he vertical coordinate.
     * @return The player instance, or {@literal null} if no move has been made on that position.
     */
    private Player getPlayerAt(int x, int y) {
        return board[x][y] != null ? board[x][y].player : null;
    }

    private final Move[][] board = new Move[SIDE][SIDE];
    private int moves = 0;
    private LinkedList<ChangeListener> listeners = new LinkedList<>();

    /**
     * Register the given listener for receiving board changes notifications.
     * @param listener the listener to be registered.
     */
    public void addListener(ChangeListener listener) {
        this.listeners.add(listener);
    }

    /**
     * Checks whether a given position is occupied by a move or not.
     * @param x the horizontal coordinate.
     * @param y the vertical coordinate.
     * @return {@literal true} if the position has been used by a move, {@literal false} otherwise.
     */
    public boolean hasMoveAt(int x, int y) {
        checkBounds(x, y);
        return board[x][y] != null;
    }

    /**
     * Makes a move at the specified position.
     * @param x the horizontal coordinate of the move.
     * @param y the vertical coordinate of the move.
     * @param player the player that made the move.
     */
    public void setMoveAt(int x, int y, Player player) {
        checkBounds(x, y);

        if (hasGameEnded())
            throw new IllegalStateException();

        board[x][y] = new Move(x, y, player);
        moves += 1;

        for (ChangeListener listener : listeners) {
            listener.boardChanged(this, x, y);
        }

        if (hasGameEnded())
            for (ChangeListener listener : listeners) {
                listener.andTheWinnerIs(getWinner());
            }
    }

    /**
     * Gets the player that won the game, if one exists.
     * @return the winner, or {@literal null} if no one won.
     */
    public Player getWinner() {
        Player[] maybeWinner = new Player[SIDE * 2 + 2];
        maybeWinner[SIDE * 2] = getPlayerAt(0, 0);
        maybeWinner[SIDE * 2 + 1] = getPlayerAt(0, SIDE - 1);
        for (int i = 0; i < SIDE; ++i) {
            maybeWinner[i] = getPlayerAt(0, i);
            maybeWinner[SIDE + i] = getPlayerAt(0, i);
            for (int j = 0; j < SIDE; j++) {
                if (maybeWinner[i] != null && getPlayerAt(j, i) != maybeWinner[i])
                    maybeWinner[i] = null;
                if (maybeWinner[SIDE + i] != null && getPlayerAt(i, j) != maybeWinner[SIDE + i])
                    maybeWinner[SIDE + i] = null;
            }
            if (maybeWinner[SIDE * 2] != null && getPlayerAt(i, i) != maybeWinner[SIDE * 2]) {
                maybeWinner[SIDE * 2] = null;
            }
            if (maybeWinner[SIDE * 2 + 1] != null && getPlayerAt(i, SIDE - 1 - i) != maybeWinner[SIDE * 2 + 1]) {
                maybeWinner[SIDE * 2 + 1] = null;
            }
        }

        for (Player player : maybeWinner) {
            if (player != null)
                return player;
        }
        return null;
    }

    /**
     * Checks whether the game has ended or not.
     * @return {@literal true} if the game has ended, {@literal false} otherwise.
     */
    public boolean hasGameEnded() {
        return !hasFreePositions() || getWinner() != null;
    }

    /**
     * Gets the move at the given coordinates.
     * @param x the move's horizontal coordinate
     * @param y the move's vertical coordinate
     * @return  the move at the position, or {@literal null} if no move has been made at that position.
     */
    public Move getMoveAt(int x, int y) {
        checkBounds(x, y);
        return board[x][y];
    }

    /**
     * Gets the board side.
     * @return  The board side.
     */
    public int getSide() {
        return SIDE;
    }
}
