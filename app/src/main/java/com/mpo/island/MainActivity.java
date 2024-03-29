package com.mpo.island;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Game.dead = false;
                Game.stage = 1;
                Game.health = 100;
                Game.food = 100;
                Game.temp = 100;
                Game.dontSeenResult = true;
                Intent intent = new Intent(MainActivity.this, gameactivity_3.class);
                startActivity(intent);
            }
        });
    }


}