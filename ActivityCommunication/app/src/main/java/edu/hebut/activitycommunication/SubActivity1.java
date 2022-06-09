package edu.hebut.activitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity1 extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub1);
		final EditText editText = (EditText)findViewById(R.id.edit);
		Button btnOK = (Button)findViewById(R.id.btn_ok);
		Button btnCancel = (Button)findViewById(R.id.btn_cancel);
		
		btnOK.setOnClickListener(v -> {
			String uriString = editText.getText().toString();
			Uri data = Uri.parse(uriString);
			
			Intent result = new Intent(null, data);
			
			setResult(RESULT_OK, result);
			finish();
		});
		
		btnCancel.setOnClickListener(v -> {
			setResult(RESULT_CANCELED, null);
			finish();
		});
	}
}