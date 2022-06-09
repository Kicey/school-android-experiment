package edu.hebut.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button button = findViewById(R.id.Button01);
        ImageButton imageButton = findViewById(R.id.ImageButton01);
        TextView textView = findViewById(R.id.textView);
        button.setOnClickListener((View v) -> textView.setText("Button clicked"));
        imageButton.setOnClickListener((View v) -> textView.setText("ImageButton clicked"));
    }
}