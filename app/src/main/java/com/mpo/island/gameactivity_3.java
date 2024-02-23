package com.mpo.island;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameactivity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity3);
        TextView text = findViewById(R.id.text);
        Button ans1 = findViewById(R.id.ans1);
        Button ans2 = findViewById(R.id.ans2);
        Button ans3 = findViewById(R.id.ans3);
        TextView health = findViewById(R.id.health);
        TextView food = findViewById(R.id.food);
        TextView temp = findViewById(R.id.temp);
        health.setText("HP: " + Game.health);
        food.setText("F: " + Game.food);
        temp.setText("T: " + Game.temp);
        if (Game.stage == 1) {
            text.setText(R.string.str1);
            ans1.setText(R.string.ans1_1);
            ans2.setText(R.string.ans1_2);
            ans3.setText(R.string.ans1_3);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health-=20;}
                    text.setText(R.string.rez1_1);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);

                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.temp-=25;}
                    text.setText(R.string.rez1_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 2;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health -= 500;}
                    text.setText(R.string.rez1_3);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans3.setText(R.string.death_health);
                        if (Game.death_food()) ans3.setText(R.string.death_food);
                        if (Game.death_temp()) ans3.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);

                }
            });
        }
//стадия 2 - гребля
        if (Game.stage == 2){
            text.setText(R.string.str2);
            ans1.setText(R.string.ans2_1);
            ans2.setText(R.string.ans2_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.food-=20; Game.health-=20;}
                    text.setText(R.string.rez2_1);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 3;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);

                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.temp-=30;}
                    text.setText(R.string.rez2_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 3;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }
//стадия 3 - берег 1
        if (Game.stage == 3){
            text.setText(R.string.str3);
            ans1.setText(R.string.ans3_1);
            ans2.setText(R.string.ans3_2);
            ans3.setText(R.string.ans3_3);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health+=40; Game.temp-=45;}
                    text.setText(R.string.rez3_1);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 4;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);

                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.food+=40; Game.temp-=45;}
                    text.setText(R.string.rez3_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 4;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.temp+=50; Game.food -= 20;}
                    text.setText(R.string.rez3_3);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans3.setText(R.string.death_health);
                        if (Game.death_food()) ans3.setText(R.string.death_food);
                        if (Game.death_temp()) ans3.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans3.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 4;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 4) {
            text.setText(R.string.str4);
            ans1.setText(R.string.ans4_1);
            ans2.setText(R.string.ans4_2);
            ans3.setText(R.string.ans4_3);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health-=20;}
                    text.setText(R.string.rez4_1);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 5;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);

                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health-=30;}
                    text.setText(R.string.rez4_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans3.setVisibility(View.GONE);
                        ans3.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 7;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });

            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.food-=30;}
                    text.setText(R.string.rez4_3);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans3.setText(R.string.death_health);
                        if (Game.death_food()) ans3.setText(R.string.death_food);
                        if (Game.death_temp()) ans3.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans3.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 9;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 5) {
            text.setText(R.string.str5);
            ans1.setText(R.string.ans5_1);
            ans2.setText(R.string.ans5_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.health-=40;}
                    text.setText(R.string.rez5_1);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 6;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.temp+=15;}
                    text.setText(R.string.rez5_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 6;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 7) {
            text.setText(R.string.str7);
            ans1.setText(R.string.ans7_1);
            ans2.setText(R.string.ans7_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.health >= 50) {
                            text.setText(R.string.rez7_1_1);
                        }
                        else{
                            text.setText(R.string.rez7_1_2);
                            Game.health -= 500;
                        }
                    }

                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 8;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.health >= 75) {
                            text.setText(R.string.rez7_2);
                            Game.food += 30;
                        }
                        else{
                            text.setText(R.string.rez7_1_2);
                            Game.health -= 500;
                        }
                    }
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 8;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 9) {
            text.setText(R.string.str9);
            ans1.setText(R.string.ans9_1);
            ans2.setText(R.string.ans9_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Math.random()>=0.4) {
                            Game.health+=50;
                            Game.food+=30;
                            text.setText(R.string.rez9_1_1);
                        }
                        else {
                            Game.health-=50;
                            text.setText(R.string.rez9_1_2);
                        }
                    }

                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 10;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {Game.food-=15;}
                    text.setText(R.string.rez9_2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Game.stage = 10;
                        Intent intent = new Intent(gameactivity_3.this, gameactivity_3.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 6) {
            text.setText(R.string.str6);
            ans1.setText(R.string.ans6_1);
            ans2.setText(R.string.ans6_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.temp>=80) {
                            Final.final_ = getString(R.string.final1);
                            text.setText(R.string.rez6_1_1);
                        }
                        else {
                            Game.temp-=500;
                            text.setText(R.string.rez6_1_2);
                        }
                    }

                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    text.setText(R.string.rez6_2);
                    Final.final_ = getString(R.string.final2);
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 8) {
            text.setText(R.string.str8);
            ans1.setText(R.string.ans8_1);
            ans2.setText(R.string.ans8_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Math.random() >= 0.5) {
                            Final.final_ = getString(R.string.final3);
                            text.setText(R.string.rez8_1_1);
                        }
                        else {
                            Game.health-=500;
                            text.setText(R.string.rez8_1_2);
                        }
                    }

                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.health >= 70) {
                            Final.final_ = getString(R.string.final3);
                            text.setText(R.string.rez8_2_1);
                        }
                        else {
                            Game.health-=500;
                            text.setText(R.string.rez8_2_2);
                        }
                    }
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }

        if (Game.stage == 10) {
            text.setText(R.string.str10);
            ans1.setText(R.string.ans10_1);
            ans2.setText(R.string.ans10_2);
            ans3.setVisibility(View.GONE);
            ans3.setClickable(false);
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.food >= 60) {
                            Final.final_ = getString(R.string.final5);
                            text.setText(R.string.rez10_1);
                        }
                        else {
                            text.setText(R.string.rez10_2);
                            Final.final_ = getString(R.string.final4);
                        }
                    }

                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans1.setText(R.string.death_health);
                        if (Game.death_food()) ans1.setText(R.string.death_food);
                        if (Game.death_temp()) ans1.setText(R.string.death_temp);
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans1.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans2.setVisibility(View.GONE);
                        ans2.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Game.dontSeenResult) {
                        if (Game.health >= 60) {
                            Final.final_ = getString(R.string.final5);
                            text.setText(R.string.rez10_1);
                        }
                        else {
                            Final.final_ = getString(R.string.final4);
                            text.setText(R.string.rez10_2);
                        }
                    }
                    if (Game.dead) {
                        Intent intent = new Intent(gameactivity_3.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else if (Game.death()) {
                        Game.dead = true;
                        if (Game.death_health()) ans2.setText(R.string.death_health);
                        if (Game.death_food()) ans2.setText(R.string.death_food);
                        if (Game.death_temp()) ans2.setText(R.string.death_temp);
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else if (Game.dontSeenResult) {
                        ans2.setText("Продолжить");
                        Game.dontSeenResult = false;
                        ans1.setVisibility(View.GONE);
                        ans1.setClickable(false);
                    }
                    else {
                        Game.dontSeenResult = true;
                        Intent intent = new Intent(gameactivity_3.this, Final.class);
                        startActivity(intent);
                    }
                    health.setText("HP: " + Game.health);
                    food.setText("F: " + Game.food);
                    temp.setText("T: " + Game.temp);
                }
            });
        }


    }
}