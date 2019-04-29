package isel.adeetc.poo.mydraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import isel.adeetc.poo.mydraw.model.Drawing;
import isel.adeetc.poo.mydraw.model.Line;

public class DrawView extends View {

    private final Paint brush;
    private Drawing model;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        brush = new Paint();
        brush.setColor(Color.RED);
        brush.setStrokeWidth(3);
        brush.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.v("SLB", "onDraw()");
        for (Line line : model) {
            drawLine(canvas, line);
        }
    }

    private void drawLine(Canvas canvas, Line line) {
        canvas.drawLine(
                line.getPi().getX(),
                line.getPi().getY(),
                line.getPf().getX(),
                line.getPf().getY(),
                brush
            );
    }

    public void setModel(Drawing drawing) {
        model = drawing;
        invalidate();
    }
}
