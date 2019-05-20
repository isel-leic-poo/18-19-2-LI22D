package edu.isel.adeetc.tictactoe.view;

import edu.isel.adeetc.poo.OnTileTouchListener;

public class TileTouchAdapter implements OnTileTouchListener {
    @Override
    public boolean onClick(int xTile, int yTile) {
        return false;
    }

    @Override
    public boolean onDrag(int xFrom, int yFrom, int xTo, int yTo) {
        return false;
    }

    @Override
    public void onDragEnd(int x, int y) {

    }

    @Override
    public void onDragCancel() {

    }
}
