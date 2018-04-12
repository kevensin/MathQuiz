package com.example.keven.mathquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public TextView textIntro;
    public Button button;
    public String[] intro = {"Math Quiz!\nClick below to begin", "start quiz!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        textIntro=findViewById(R.id.textIntro1);
        textIntro.setText(intro[0]);
        button = findViewById(R.id.button1);
        button.setText(intro[1]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
