package isel.adeetc.poo.mydraw.model;

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
}
