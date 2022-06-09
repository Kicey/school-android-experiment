package edu.hebut.intentresolutiondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.btn);
		button.setOnClickListener(v -> {
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("schemodemo://edu.scse/path"));
			startActivity(intent);
		});
	}
}