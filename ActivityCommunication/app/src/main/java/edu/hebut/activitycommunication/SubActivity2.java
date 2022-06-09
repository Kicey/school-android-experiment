package edu.hebut.activitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class SubActivity2 extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub2);
		Button btnReturn = (Button)findViewById(R.id.btn_return);
		
		btnReturn.setOnClickListener(v -> {
			setResult(RESULT_CANCELED, null);
			finish();
		});
	}
}