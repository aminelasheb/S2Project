package com.example.spacysprint1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ANQ extends AppCompatActivity {
    private TextView Quiz ;
    private TextView Alphabet ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anq);
        TextView numbers =findViewById(R.id.numbers);

        Quiz=findViewById(R.id.quiz) ;
        Alphabet=findViewById(R.id.alphabet) ;

        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ANQ.this , Quiz.class) ;
                startActivity(intent);
            }
        });

        Alphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ANQ.this , AlphabetAng.class) ;
                startActivity(intent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennumbers();

            }
        });
    }
    public void opennumbers(){
        Intent intent=new Intent(this,NumAn.class);
        startActivity(intent);
    }
}
