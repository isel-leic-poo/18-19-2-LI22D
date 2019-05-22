package edu.isel.adeetc.tictactoe.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import edu.isel.adeetc.poo.Img;
import edu.isel.adeetc.poo.Tile;
import edu.isel.adeetc.tictactoe.model.Board;

public class ImageTile implements Tile {

    private final Paint brush;
    private final Img image;

    public ImageTile(Img image) {
        brush = new Paint();
        this.image = image;
    }

    @Override
    public void draw(Canvas canvas, int side) {
        int border = side * 10 / 100;
        image.draw(canvas, side - border, side - border, brush);
    }

    @Override
    public boolean setSelect(boolean selected) {
        return false;
    }
}
