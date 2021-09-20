package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class image extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://aissmsioit.org/wp-content/uploads/2020/07/SESyllabusCompute.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
    public void prn(View v){
        Uri uri = Uri.parse("https://drive.google.com/file/d/1aWDm4-aY9efG9FuwaO03JENZl8o1lap6/view?usp=sharing");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}