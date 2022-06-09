package edu.hebut.threadrandomservicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	
	private static Handler handler = new Handler();
	private static TextView labelView = null;
	private static double randomDouble;
	
	private static Runnable RefreshLabel = new Runnable() {
		@Override
		public void run() {
			labelView.setText(String.valueOf(randomDouble));
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelView = (TextView) findViewById(R.id.label);
		Button startButton = (Button) findViewById(R.id.start);
		Button stopButton = (Button) findViewById(R.id.stop);
		
		final Intent serviceIntent = new Intent(this, RandomService.class);
		
		startButton.setOnClickListener(v -> {
			startService(serviceIntent);
		});
		
		stopButton.setOnClickListener(v -> {
			stopService(serviceIntent);
		});
	}
	
	public static void UpdateGUI(double refreshDouble) {
		randomDouble = refreshDouble;
		handler.post(RefreshLabel);
	}
	
}