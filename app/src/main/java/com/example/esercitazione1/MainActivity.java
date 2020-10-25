package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    Button incremento, decremento, incremento5, decremento5, reset;
    EditText input;

    int minValue = 0;
    int maxValue = 100;
    int currValue = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        incremento5 = findViewById(R.id.incremento5);
        decremento = findViewById(R.id.decremento);
        decremento5 = findViewById(R.id.decremento5);
        input = findViewById(R.id.input);
        reset = findViewById(R.id.reset);

        updateValue(currValue);

        incremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("+1");
                updateValue(++currValue);
            }
        });

        incremento5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(currValue + 5);
            }
        });

        decremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updateValue(--currValue);
            }
        });

        decremento5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updateValue(currValue - 5);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(0);
            }
        });
    }

    protected void updateValue(int newValue) {
        newValue = newValue > maxValue ? maxValue : newValue;
        newValue = newValue < minValue ? minValue : newValue;
        this.currValue = newValue;
        input.setText("" + this.currValue);
    }
}