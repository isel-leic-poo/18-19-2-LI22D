package edu.isel.adeetc.tictactoe.view;

import android.graphics.Canvas;

import edu.isel.adeetc.poo.Tile;

/**
 * Class whose instances represent empty tiles on a tic-tac-toe board.
 *
 * @see BoardView
 */
public class EmptyTile implements Tile {

    @Override
    public void draw(Canvas canvas, int side) { }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
