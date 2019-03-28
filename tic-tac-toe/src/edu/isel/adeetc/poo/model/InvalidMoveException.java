package edu.isel.adeetc.poo.model;

/**
 * Exception used to report that a given tic-tac-toe move is deemed invalid, e.g. the position is already used.
 */
public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String message) {
        super(message);
    }
}
