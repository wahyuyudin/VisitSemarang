package com.example.android.visitsemarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //define button_visit_sbm
    private static Button button_visit_sbm;

    //define button_about_sbm
    private static Button button_about_sbm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonListener();
    }


    //create methode for button click
    public void OnClickButtonListener() {

        //go to visit_acticity when button visit is clicked
        button_visit_sbm = (Button) findViewById(R.id.visit_button);
        button_visit_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent visit_intent = new Intent("com.example.android.visitsemarang.visit");
                        startActivity(visit_intent);
                    }

                }
        );

        //go to about_acticity when button visit is clicked
        button_about_sbm = (Button) findViewById(R.id.about_button);
        button_about_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent about_intent = new Intent("com.example.android.visitsemarang.about");
                        startActivity(about_intent);
                    }

                }
        );
    }

}