package com.ashish.FlipWifi.Sensors;

import com.ashish.FlipWifi.Triggers.FlipTrigger;
import com.ashish.FlipWifi.Triggers.SensorBasedTrigger;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

public class SensorService extends Service {							//Most basic class
																	    //For enabling the Trigger

	private SensorManager sensormgr = null;
	private SensorBasedTrigger fliptrigger = new FlipTrigger();
	
	public void onCreate(){
		super.onCreate();
		Log.d("SensorService", "Service Started");
		sensormgr = (SensorManager)getSystemService(SENSOR_SERVICE);
		fliptrigger.onCreate(getApplicationContext(), sensormgr);
	}
	
	public void OnDestroy(){
		super.onDestroy();
		Log.d("SensorService", "Service Stopped");
		fliptrigger.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
