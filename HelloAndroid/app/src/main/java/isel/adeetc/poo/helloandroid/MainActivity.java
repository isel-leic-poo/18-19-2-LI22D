package isel.adeetc.poo.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterValue;
    private Counter model;

    private void updateUI(Counter model) {
        counterValue.setText(Integer.toString(model.getValue()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("CounterActivity", "onCreate()");

        model = savedInstanceState != null ?
            new Counter(savedInstanceState.getInt("counter", 0), 10) :
            new Counter(0, 10);

        counterValue = new TextView(this);

        Button incButton = new Button(this);
        incButton.setText("+");
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                model.increment();
                Log.v("CounterActivity", "increment");
            }
        });
        Button decButton = new Button(this);
        decButton.setText("-");
        decButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                model.decrement();
                Log.v("CounterActivity", "decrement");
            }
        });

        model.setListener(new Counter.Listener() {
            @Override
            public void valueChanged(Counter counter) {
                updateUI(counter);
                Log.v("CounterActivity", "Counter.Listener.valueChanged");
            }
        });

        updateUI(model);

        LinearLayout content = new LinearLayout(this);
        content.addView(counterValue);
        content.addView(incButton);
        content.addView(decButton);

        setContentView(content);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", model.getValue());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("CounterActivity", "onDestroy()");

    }
}
