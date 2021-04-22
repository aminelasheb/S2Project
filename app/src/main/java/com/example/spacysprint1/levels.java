package com.example.spacysprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levels);

        ImageView levelone =findViewById(R.id.levelone);

        levelone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlevelone();

            }
        });
    }
    public void openlevelone(){
        Intent intent=new Intent(this,ANQ.class);
        startActivity(intent);
    }
}