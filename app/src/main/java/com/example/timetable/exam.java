package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class exam extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        imageView = findViewById(R.id.imageView2);

    }

    public void endsem(View view) {
        imageView.setImageResource(R.drawable.endsem);
    }

    public void ut(View view) {
        imageView.setImageResource(R.drawable.ut);
    }
}