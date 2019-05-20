package edu.isel.adeetc.tictactoe.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import edu.isel.adeetc.tictactoe.model.Board;

/**
 * UI component used to display player moves in a tic-tac-toe board.
 *
 * @see BoardView
 */
public class CrossedTile extends MoveTile {

    private final Paint brush;

    /**
     * Initiates the tile instance with the given associated move.
     *
     * @param move the move to be displayed, or null if there's no move in the position to which the tile corresponds.
     */
    public CrossedTile(Board.Move move) {
        super(move);
        brush = new Paint();
        brush.setStyle(Paint.Style.STROKE);
        brush.setColor(Color.RED);
        brush.setStrokeWidth(5);
    }

    @Override
    public void draw(Canvas canvas, int side) {
        int border = side * 10 / 100;
        canvas.drawLine(border, border, side - border, side - border, brush);
        canvas.drawLine(side - border, border, border, side - border, brush);
    }
}
