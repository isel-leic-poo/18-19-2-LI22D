package isel.adeetc.poo.mydraw;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import isel.adeetc.poo.mydraw.model.Drawing;
import isel.adeetc.poo.mydraw.model.Line;
import isel.adeetc.poo.mydraw.model.Point;

public class MainActivity extends AppCompatActivity {

    public static final String FILENAME = "Drawing.dat";

    private Drawing model = null;
    private DrawView drawView = null;

    private void loadState() {
        try (Scanner in = new Scanner(openFileInput(FILENAME))) {
            model = Drawing.fromFile(in);
        }
        catch (FileNotFoundException e) {
            Log.e("DrawingApp", "Error opening file");
        }
    }

    private void saveState() {
        try (PrintWriter out = new PrintWriter(openFileOutput(FILENAME, MODE_PRIVATE))) {
            String state = model.toString();
            out.print(state);
            Log.v("DrawingApp", state);
        }
        catch (FileNotFoundException e) {
            Log.e("DrawingApp", "Error opening file");
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        loadState();
        if (model == null)
            model = new Drawing();

        drawView = findViewById(R.id.drawView);
        drawView.setModel(model);

        drawView.setOnTouchListener(new View.OnTouchListener() {
            private Point initialPoint;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    initialPoint = new Point((int) event.getX(), (int) event.getY());
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final Point finalPoint = new Point((int) event.getX(), (int) event.getY());
                    model.add(new Line(initialPoint, finalPoint));
                    drawView.invalidate();
                }
                return true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
    }
}
