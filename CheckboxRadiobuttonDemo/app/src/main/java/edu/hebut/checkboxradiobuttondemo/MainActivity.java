package edu.hebut.checkboxradiobuttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        CheckBox checkBox = findViewById(R.id.checkBox);
        CheckBox checkBox1 = findViewById(R.id.checkBox1);
        RadioButton radioButton = findViewById(R.id.radioButton);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        View.OnClickListener checkBokOnClickListener = v -> {
            switch (v.getId()) {
                case R.id.checkBox:
                    textView.setText("CheckBox1：" + String.valueOf(checkBox.isChecked()));
                    break;
                case R.id.checkBox1:
                    textView.setText("CheckBox2：" + String.valueOf(checkBox1.isChecked()));
                    break;
            }
        };
        checkBox.setOnClickListener(checkBokOnClickListener);
        checkBox1.setOnClickListener(checkBokOnClickListener);
        View.OnClickListener radioButtonOnClickListener = v -> {
            switch (v.getId()) {
                case R.id.radioButton:
                    textView.setText("RadioButton1：" + String.valueOf(radioButton.isChecked()));
                    break;
                case R.id.radioButton1:
                    textView.setText("RadioButton2：" + String.valueOf(radioButton1.isChecked()));
                    break;
            }
        };
        radioButton.setOnClickListener(radioButtonOnClickListener);
        radioButton1.setOnClickListener(radioButtonOnClickListener);
    }
}