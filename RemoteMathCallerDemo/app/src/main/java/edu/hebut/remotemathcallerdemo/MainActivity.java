package edu.hebut.remotemathcallerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.hebut.remotemathservicedemo.IMathService;

public class MainActivity extends AppCompatActivity {
	
	private IMathService mathService;
	private boolean isBound = false;
	TextView labelView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		labelView = (TextView) findViewById(R.id.label);
		Button bindButton = (Button) findViewById(R.id.bind);
		Button unbindButton = (Button) findViewById(R.id.unbind);
		Button computeAllButton = (Button) findViewById(R.id.compute_all);
		
		bindButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!isBound) {
					Intent intent = new Intent();
					intent.setAction("edu.hebut.remotemathservicedemo.MathService");
					intent.setPackage("edu.hebut.remotemathservicedemo");
					bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
					isBound = true;
				}
			}
		});
		
		unbindButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isBound) {
					isBound = false;
					unbindService(mConnection);
					mathService = null;
				}
			}
		});
		
		
		computeAllButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mathService == null) {
					labelView.setText("未绑定服务");
					return;
				}
				long a = Math.round(Math.random() * 100);
				long b = Math.round(Math.random() * 100);
				Long result = null;
				try {
					result = mathService.Add(a, b);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				String msg = "";
				if (result != null) {
					msg += a + " + " + b + " = " + result + "\n";
				}
				labelView.setText(msg);
			}
		});
	}
	
	private ServiceConnection mConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mathService = IMathService.Stub.asInterface(service);
		}
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mathService = null;
		}
	};
}