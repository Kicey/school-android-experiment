package edu.hebut.resourcefiledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
	
	private Resources resources;
	private TextView displayView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button readRawButton = (Button) findViewById(R.id.read_raw);
		Button readXmlButton = (Button) findViewById(R.id.read_xml);
		Button clearButton = (Button) findViewById(R.id.clear);
		readRawButton.setOnClickListener(readRawButtonListener);
		readXmlButton.setOnClickListener(readXmlButtonListener);
		clearButton.setOnClickListener(clearButtonListener);
		
		this.displayView = (TextView) findViewById(R.id.display);
		this.resources = this.getResources();
	}
	
	View.OnClickListener readRawButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			InputStream inputStream = null;
			try {
				inputStream = resources.openRawResource(R.raw.raw_file);
				byte[] reader = new byte[inputStream.available()];
				while (inputStream.read(reader) != -1) {
				}
				displayView.setText(new String(reader, "utf-8"));
			} catch (IOException e) {
				Log.e("ResourceFileDemo", e.getMessage(), e);
			} finally {
				if (inputStream != null) {
					try {
						inputStream.close();
					} catch (IOException e) {
					}
				}
			}
		}
	};
	
	
	View.OnClickListener readXmlButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			XmlPullParser parser = resources.getXml(R.xml.people);
			String msg = "";
			try {
				while (parser.next() != XmlPullParser.END_DOCUMENT) {
					String people = parser.getName();
					String name = null;
					String age = null;
					String height = null;
					if ((people != null) && people.equals("person")) {
						int count = parser.getAttributeCount();
						for (int i = 0; i < count; i++) {
							String attrName = parser.getAttributeName(i);
							String attrValue = parser.getAttributeValue(i);
							if ((attrName != null) && attrName.equals("name")) {
								name = attrValue;
							} else if ((attrName != null) &&
									attrName.equals("age")) {
								age = attrValue;
							} else if ((attrName != null) &&
									attrName.equals("height")) {
								height = attrValue;
							}
						}
						if ((name != null) && (age != null) && (height != null)) {
							msg += "姓名：" + name + "，年龄：" + age + "，身高： " + height + "\n";
						}
					}
				}
			} catch (Exception e) {
				Log.e("ResourceFileDemo", e.getMessage(), e);
			}
			displayView.setText(msg);
		}
	};
	
	View.OnClickListener clearButtonListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			displayView.setText("");
		}
	};
	
}