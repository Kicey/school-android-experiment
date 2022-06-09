package edu.hebut.broadcastreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
	private EditText entryText ;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		entryText = (EditText)findViewById(R.id.entry);
		button = (Button)findViewById(R.id.btn);
		
		button.setOnClickListener(v -> {
			Intent intent = new Intent("edu.hebut.broadcastreceiverdemo");
			intent.setPackage("edu.hebut.broadcastreceiverdemo");
			intent.putExtra("message", entryText.getText().toString());
			sendBroadcast(intent);
		});
	}
}