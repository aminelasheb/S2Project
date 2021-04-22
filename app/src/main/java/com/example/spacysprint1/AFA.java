package com.example.spacysprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AFA extends AppCompatActivity {

    private TextView Ang ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afa);

        Ang = findViewById(R.id.angg) ;
        Ang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AFA.this ,levels.class) ;
                startActivity(intent);
            }
        });


    }
}