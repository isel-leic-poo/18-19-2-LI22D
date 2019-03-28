package edu.isel.adeetc.poo.model;

import org.junit.Assert;
import org.junit.Test;

public class BoardTests {

    private void doMoves(Coordinate[] moves, Player p1, Player p2) {
        Player current = p1;
        for (int idx = 0; idx < moves.length; idx++) {
            current.doMove(moves[idx].x, moves[idx].y);
            current = current == p1 ? p2 : p1;
        }
    }

    private void doP2DiagonalWinningMoves(Player p1, Player p2) {
        final Coordinate[] moves = new Coordinate[] {
                new Coordinate(0, 1),
                new Coordinate(0, 0),
                new Coordinate(0, 2),
                new Coordinate(1, 1),
                new Coordinate(2, 0),
                new Coordinate(2, 2)
        };
        doMoves(moves, p1, p2);
    }

    private void doP1DiagonalWinningMoves(Player p1, Player p2) {
        final Coordinate[] moves = new Coordinate[] {
                new Coordinate(0, 2),
                new Coordinate(0, 0),
                new Coordinate(1, 1),
                new Coordinate(2, 2),
                new Coordinate(2, 0),
        };
        doMoves(moves, p1, p2);
    }

    private void doP1WinningMoves(Player p1, Player p2) {
        final Coordinate[] moves = new Coordinate[] {
            new Coordinate(0, 0),
            new Coordinate(0, 1),
            new Coordinate(1, 0),
            new Coordinate(0, 2),
            new Coordinate(2, 0)
        };
        doMoves(moves, p1, p2);
    }

    private void doDrawMoves(Player p1, Player p2) {
        final Coordinate[] moves = new Coordinate[] {
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(2, 0),
                new Coordinate(1, 0),
                new Coordinate(1, 1),
                new Coordinate(1, 2),
                new Coordinate(2, 2),
                new Coordinate(2, 1)
        };
        doMoves(moves, p1, p2);
    }

    @Test
    public void hasMoveAtPosition_returnsTrueIfOccupied() {
        Board sut = new Board();
        Player player = new Player(sut);

        sut.setMoveAt(0, 0, player);
        Assert.assertTrue(sut.hasMoveAt(0, 0));
    }

    @Test
    public void hasGameEnded_returnsTrueForCompletedGame() {
        final Board sut = new Board();
        final Player p1 = new Player(sut);
        final Player p2 = new Player(sut);
        doP1WinningMoves(p1, p2);
        Assert.assertTrue(sut.hasGameEnded());
    }

    @Test
    public void getWinner_returnsPlayerThatWon() {
        final Board sut = new Board();
        final Player p1 = new Player(sut);
        final Player p2 = new Player(sut);
        doP1WinningMoves(p1, p2);
        Assert.assertSame(p1, sut.getWinner());
    }

    @Test
    public void getWinner_returnsNullIfNobodyPlayed() {
        final Board sut = new Board();
        Assert.assertNull(sut.getWinner());
    }

    @Test
    public void getWinner_returnsNullIfNobodyWon() {
        final Board sut = new Board();
        final Player p1 = new Player(sut);
        final Player p2 = new Player(sut);
        doDrawMoves(p1, p2);
        Assert.assertNull(sut.getWinner());
    }

    @Test
    public void getWinner_onBoardWithP1DiagonalWin_returnsP1() {
        final Board sut = new Board();
        final Player p1 = new Player(sut);
        final Player p2 = new Player(sut);
        doP1DiagonalWinningMoves(p1, p2);
        Assert.assertSame(p1, sut.getWinner());
    }

    @Test
    public void getWinner_onBoardWithP2DiagonalWin_returnsP1() {
        final Board sut = new Board();
        final Player p1 = new Player(sut);
        final Player p2 = new Player(sut);
        doP2DiagonalWinningMoves(p1, p2);
        Assert.assertSame(p2, sut.getWinner());
    }
}
