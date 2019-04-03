package edu.isel.adeetc.poo.model;

/**
 * Class whose instances represent the players of the tic-tac-toe game.
 */
public class Player {

    private final Board board;
    private final String id;

    /**
     * Initiates a player that will play on the given board and that will be identified by the given id.
     * @param board the game board.
     * @param id    the player identifier.
     */
    public Player(Board board, String id) {
        this.board = board;
        this.id = id;
    }

    /**
     * Executes a move on the given coordinates, if the position is still free.
     * @param x the horizontal coordinate.
     * @param y the vertical coordinate.
     * @throws InvalidMoveException if the specified position is not free.
     */
    public void doMove(int x, int y) {
        if (board.hasMoveAt(x, y))
            throw new InvalidMoveException("The board position is already in use");
        board.setMoveAt(x, y, this);
    }

    /**
     * Gets the player identifier.
     * @return
     */
    public String getId() {
        return id;
    }
}
