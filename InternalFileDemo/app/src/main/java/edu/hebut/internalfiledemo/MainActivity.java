package edu.hebut.internalfiledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
	
	private final String FILE_NAME = "fileDemo.txt";
	private TextView labelView;
	private TextView displayView;
	private CheckBox appendBox ;
	private EditText entryText;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelView = (TextView)findViewById(R.id.label);
		displayView = (TextView)findViewById(R.id.display);
		appendBox = (CheckBox)findViewById(R.id.append);
		entryText = (EditText)findViewById(R.id.entry);
		Button writeButton = (Button)findViewById(R.id.write);
		Button readButton = (Button)findViewById(R.id.read);
		writeButton.setOnClickListener(writeButtonListener);
		readButton.setOnClickListener(readButtonListener);
		entryText.selectAll();
		entryText.findFocus();
	}
	
	
	View.OnClickListener writeButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			FileOutputStream fos = null;
			try {
				if (appendBox.isChecked()){
					fos = openFileOutput(FILE_NAME,Context.MODE_APPEND);
				}
				else {
					fos = openFileOutput(FILE_NAME,Context.MODE_PRIVATE);
				}
				
				String text = entryText.getText().toString();
				fos.write(text.getBytes());
				labelView.setText("文件写入成功，写入长度："+text.length());
				entryText.setText("");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally{
				if (fos != null){
					try {
						fos.flush();
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	};
	
	View.OnClickListener readButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			displayView.setText("");
			FileInputStream fis = null;
			try {
				fis = openFileInput(FILE_NAME);
				if (fis.available() == 0){
					return;
				}
				byte[] readBytes = new byte[fis.available()];
				while(fis.read(readBytes) != -1){
				}
				String text = new String(readBytes);
				displayView.setText(text);
				labelView.setText("文件读取成功，文件长度："+text.length());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
}