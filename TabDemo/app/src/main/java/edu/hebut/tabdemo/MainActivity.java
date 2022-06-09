package edu.hebut.tabdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TabHost tabHost = getTabHost();
		
		LayoutInflater.from(this).inflate(R.layout.tab1,
				tabHost.getTabContentView(), true);
		LayoutInflater.from(this).inflate(R.layout.tab2,
				tabHost.getTabContentView(), true);
		LayoutInflater.from(this).inflate(R.layout.tab3,
				tabHost.getTabContentView(), true);
		
		tabHost.addTab(tabHost.newTabSpec("TAB1").
				setIndicator("线性布局").setContent(R.id.layout01));
		tabHost.addTab(tabHost.newTabSpec("TAB2").
				setIndicator("绝对布局").setContent(R.id.layout02));
		tabHost.addTab(tabHost.newTabSpec("TAB3").
				setIndicator("相对布局").setContent(R.id.layout03));
	}
}