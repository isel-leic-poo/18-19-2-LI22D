package edu.isel.adeetc.poo.model;

/**
 * Class whose instances represent the tic-tac-toe game board.
 */
public class Board {

    private void checkBounds(int x, int y) {
        if (x < 0 || x >= SIDE || y < 0 || y >= SIDE) {
            throw new IllegalArgumentException("Invalid move coordinates (" + x + ", " + y + ")");
        }
    }
    private static final int SIDE = 3;

    private static class Move {
        final Coordinate coordinate;
        final Player player;
        public Move(int x, int y, Player player) {
            this.coordinate = new Coordinate(x, y);
            this.player = player;
        }
    }

    private final Move[][] board = new Move[SIDE][SIDE];
    private int moves = 0;

    private Player getPlayerAt(int x, int y) {
        return board[x][y] != null ? board[x][y].player : null;
    }

    public boolean hasMoveAt(int x, int y) {
        checkBounds(x, y);
        return board[x][y] != null;
    }

    public void setMoveAt(int x, int y, Player player) {
        checkBounds(x, y);
        board[x][y] = new Move(x, y, player);
        moves += 1;
    }

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

    public boolean hasGameEnded() {
        return !hasFreePositions() || getWinner() != null;
    }

    private boolean hasFreePositions() {
        return moves != SIDE * SIDE;
    }
}
