package isel.adeetc.poo.mydraw.model;

import java.util.ArrayList;
import java.util.Iterator;

import isel.adeetc.poo.mydraw.model.Line;

public class Drawing implements Iterable<Line> {

    private final ArrayList<Line> drawing;

    public Drawing() {
        this.drawing = new ArrayList<>();
    }

    public void add(Line line) {
        drawing.add(line);
    }

    @Override
    public Iterator<Line> iterator() {
        return drawing.iterator();
    }
}
