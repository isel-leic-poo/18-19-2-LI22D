package edu.isel.adeetc.poo.model;

/**
 * Class whose instances represent the players of the tic-tac-toe game.
 */
public class Player {

    private final Board board;

    public Player(Board board) {
        this.board = board;
    }

    public void doMove(int x, int y) {
        if (board.hasMoveAt(x, y))
            throw new InvalidMoveException("The board position is already in use");
        board.setMoveAt(x, y, this);
    }
}
