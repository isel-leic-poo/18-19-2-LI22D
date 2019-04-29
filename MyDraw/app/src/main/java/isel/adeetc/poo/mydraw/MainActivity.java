package isel.adeetc.poo.mydraw;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import isel.adeetc.poo.mydraw.model.Drawing;
import isel.adeetc.poo.mydraw.model.Line;
import isel.adeetc.poo.mydraw.model.Point;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Drawing model = new Drawing();
        final DrawView drawView = findViewById(R.id.drawView);
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
}
