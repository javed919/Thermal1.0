package com.example.javed.thermal10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Javed on 6/14/2016.
 */
public class Pop extends Activity{

    private static Button btn_cancel;
    private static Button btn_ok;
    private static EditText edit_text_user_ID;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_change_user);

        //setting size of popup window
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width*10/10, height*10/10);

        //capturing user ID
        edit_text_user_ID = (EditText) findViewById(R.id.editText_UserID);
        //--------------------------------------------

        //adding button  functions
        btn_cancel = (Button) findViewById(R.id.btn_cancel_popup);
        btn_ok = (Button) findViewById(R.id.btn_ok_popup);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = edit_text_user_ID.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("edittextvalue", data);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        //------------------------------------------------------------

    }

}
