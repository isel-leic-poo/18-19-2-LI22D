package isel.adeetc.poo.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView counterValue;
    private Counter model;

    private static final String COUNTER_KEY = "counter";

    private void updateUI(Counter model) {
        counterValue.setText(Integer.toString(model.getValue()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = savedInstanceState != null ?
            new Counter(savedInstanceState.getInt(COUNTER_KEY, 0), 10) :
            new Counter(0, 10);

        setContentView(R.layout.activity_main);
        counterValue = findViewById(R.id.counterValue);

        Button incButton = findViewById(R.id.incButton);
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { model.increment(); }
        });

        Button decButton = findViewById(R.id.decButton);
        decButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) { model.decrement(); }
        });

        model.setListener(new Counter.Listener() {
            @Override
            public void valueChanged(Counter counter) { updateUI(counter); }
        });

        updateUI(model);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(COUNTER_KEY, model.getValue());
    }
}
