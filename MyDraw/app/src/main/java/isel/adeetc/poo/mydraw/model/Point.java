package isel.adeetc.poo.mydraw.model;

import java.util.Scanner;

public class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(getX())
                .append(' ')
                .append(getY());

        return result.toString();
    }

    public static Point fromFile(Scanner in) {
        return new Point(in.nextInt(), in.nextInt());
    }

}
