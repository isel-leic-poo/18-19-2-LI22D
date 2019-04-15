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

    private void updateUI(Counter model) {
        counterValue.setText(Integer.toString(model.getValue()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Counter model = new Counter(0, 10);
        counterValue = new TextView(this);

        Button incButton = new Button(this);
        incButton.setText("+");
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                model.increment();
                Log.v("MainActivity", "increment");
            }
        });
        Button decButton = new Button(this);
        decButton.setText("-");
        decButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                model.decrement();
                Log.v("MainActivity", "decrement");
            }
        });

        model.setListener(new Counter.Listener() {
            @Override
            public void valueChanged(Counter counter) {
                updateUI(counter);
                Log.v("MainActivity", "Counter.Listener.valueChanged");
            }
        });

        updateUI(model);

        LinearLayout content = new LinearLayout(this);
        content.addView(counterValue);
        content.addView(incButton);
        content.addView(decButton);

        setContentView(content);
    }
}
