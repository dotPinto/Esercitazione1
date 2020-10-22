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

    Button incremento, decremento;
    EditText input,nice;
    SeekBar seekBar;
    MediaPlayer player;
    int minValue = 0;
    int maxValue=100;
    int currValue=50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        decremento = findViewById(R.id.decremento);
        input = findViewById(R.id.input);
        seekBar = findViewById(R.id.seekbar);
        nice = findViewById(R.id.nice);

        updateValue(currValue);

        incremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("+1");
                updateValue(++currValue);
            }
        });

        decremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updateValue(--currValue);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateValue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());
            }
        });
    }

    protected void updateValue(int newValue){
        player = MediaPlayer.create(MainActivity.this,R.raw.nice_sound);
        if(this.seekBar.getProgress() != this.currValue){
            this.seekBar.setProgress(this.currValue);
        }
        newValue = newValue>maxValue ? maxValue : newValue;
        newValue = newValue<minValue ? minValue : newValue;
        this.currValue=newValue;
        input.setText(""+this.currValue);

        if(currValue == 69){
            nice.setText("nice");
            player.start();
        }
        else {
            nice.setText("");
            player.pause();
        }
    }

    /*
    @Override
    protected void onStop(){
        super.onStop();

        TextView helloworld = findViewById(R.id.helloworld);
        helloworld.setText("on stop!");
    }
    */

}