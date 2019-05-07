package isel.adeetc.poo.mydraw.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (Line line: this)
            result.append(line.toString());
        return result.toString();
    }

    public static Drawing fromFile(Scanner in) {
        final Drawing loaded = new Drawing();
        while(in.hasNext()) {
            loaded.add(Line.fromFile(in));
        }
        return loaded;
    }
}
