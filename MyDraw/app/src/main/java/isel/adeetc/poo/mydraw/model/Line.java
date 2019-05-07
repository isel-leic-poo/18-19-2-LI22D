package isel.adeetc.poo.mydraw.model;

import java.util.Scanner;

public class Line {

    private final Point pi;
    private final Point pf;

    public Line(int xi, int yi, int xf, int yf) {
        this.pi = new Point(xi, yi);
        this.pf = new Point(xf, yf);
    }

    public Line(Point pi, Point pf) {
        this.pi = pi;
        this.pf = pf;
    }

    public Point getPi() {
        return pi;
    }

    public Point getPf() {
        return pf;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(pi.toString()).append(' ').append(pf.toString()).append('\n');
        return result.toString();
    }

    public static Line fromFile(Scanner in) {
        return new Line(Point.fromFile(in), Point.fromFile(in));
    }
}
