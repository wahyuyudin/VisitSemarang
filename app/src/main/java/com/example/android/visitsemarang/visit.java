package com.example.android.visitsemarang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class visit extends AppCompatActivity {

    private static Button button_kuliner_sbm;
    private static Button button_wisata_sbm;
    private static Button button_kesenian_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visit);
        OnClickButtonListener();
    }

    //method untuk membuka activity kuliner
    public void OnClickButtonListener() {
        button_kuliner_sbm = (Button) findViewById(R.id.kuliner_button);
        button_kuliner_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent visit_intent = new Intent("com.example.android.visitsemarang.kuliner");
                        startActivity(visit_intent);
                    }

                }
        );

        button_wisata_sbm = (Button) findViewById(R.id.wisata_button);
        button_wisata_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent wisata_intent = new Intent("com.example.android.visitsemarang.wisata");
                        startActivity(wisata_intent);
                    }

                }
        );

        button_kesenian_sbm = (Button) findViewById(R.id.kesenian_button);
        button_kesenian_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent kesenian_intent = new Intent("com.example.android.visitsemarang.kesenian");
                        startActivity(kesenian_intent);
                    }

                }
        );
    }
}
