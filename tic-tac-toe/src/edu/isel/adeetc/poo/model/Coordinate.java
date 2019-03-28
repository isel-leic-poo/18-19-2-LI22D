package edu.isel.adeetc.poo.model;

/**
 * Class whose instances represent rectangular coordinates.
 */
public class Coordinate {
    public final int x, y;

    public Coordinate() {
        this(0, 0);
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
