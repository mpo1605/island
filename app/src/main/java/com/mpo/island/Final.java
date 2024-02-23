package com.mpo.island;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Final extends AppCompatActivity {

    public static String final_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Button restart = findViewById(R.id.Restart);
        Button end = findViewById(R.id.End);
        ImageView pic = findViewById(R.id.picture);
        TextView text = findViewById(R.id.text);
        text.setText(final_);

        if (final_.equals(getString(R.string.final1))) pic.setImageDrawable(getDrawable(R.drawable.one));
        if (final_.equals(getString(R.string.final2))) pic.setImageDrawable(getDrawable(R.drawable.two));
        if (final_.equals(getString(R.string.final3))) pic.setImageDrawable(getDrawable(R.drawable.three));
        if (final_.equals(getString(R.string.final4))) pic.setImageDrawable(getDrawable(R.drawable.four));
        if (final_.equals(getString(R.string.final5))) pic.setImageDrawable(getDrawable(R.drawable.five));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Final.this, MainActivity.class);
                startActivity(intent);
            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}