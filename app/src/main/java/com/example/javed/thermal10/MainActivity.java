package com.example.javed.thermal10;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SeekBar seek_bar;
    private static TextView text_view;
    private static TextView user_id_disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_id_disp = (TextView) findViewById(R.id.textView_UserID) ;

        user_id_disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Pop.class));
            }
        });

        //blind listener
      //  user_id_disp.setOnTouchListener(this);

        seekbbarr();
    }
    public void seekbbarr(){
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        text_view = (TextView)findViewById(R.id.textView);
        text_view.setText("Level: "+ (seek_bar.getProgress()-50)/10);


        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int thermal_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        thermal_value = progress;
                        text_view.setText("Level: "+ (progress-50)/10);
                    //    Toast.makeText(MainActivity.this,"SeekBar in Progress",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                      //  Toast.makeText(MainActivity.this,"SeekBar in StartTracking",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view.setText("Level: "+ (thermal_value-50)/10);
                     //   Toast.makeText(MainActivity.this,"SeekBar in StopTracking",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void onSubmit(View v){
        Context context = MainActivity.this;
        CharSequence message = "Submited Successfully";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context , message ,duration).show();
    }
    public void onReset(View v){
        seek_bar.setProgress(50);
        seek_bar.refreshDrawableState();
    }
}
