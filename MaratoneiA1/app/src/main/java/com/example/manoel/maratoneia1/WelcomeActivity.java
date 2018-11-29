package com.example.manoel.maratoneia1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dataMovie.manoel.maratoneia1.R;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnter;
    private static final String ARQUIVO_PREFERENCIA = "FileReference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,MODE_PRIVATE);
        if(preferences.contains("enter")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            this.finish();
        }
        else{
            setContentView(R.layout.activity_welcome);
            btnEnter = findViewById(R.id.btnAccess);
            btnEnter.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("enter", true);
        editor.commit();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
