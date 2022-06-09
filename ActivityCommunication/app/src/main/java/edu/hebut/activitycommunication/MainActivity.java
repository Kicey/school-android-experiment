package edu.hebut.activitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	private static final int SUBACTIVITY1 = 1;
	private static final int SUBACTIVITY2 = 2;
	TextView textView = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textShow);
		final Button btn1 = (Button) findViewById(R.id.button);
		final Button btn2 = (Button) findViewById(R.id.button1);
		
		btn1.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity.this,
					SubActivity1.class);
			startActivityForResult(intent, SUBACTIVITY1);
		});
		
		btn2.setOnClickListener(v -> {
			Intent intent = new Intent(MainActivity.this,
					SubActivity1.class);
			startActivityForResult(intent, SUBACTIVITY1);
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
			case SUBACTIVITY1:
				if (resultCode == RESULT_OK) {
					Uri uriData = data.getData();
					textView.setText(uriData.toString());
				}
				break;
			case SUBACTIVITY2:
				break;
		}
	}
}