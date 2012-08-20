package com.ashish.FlipWifi.Triggers;

import com.ashish.FlipWifi.TriggerReciever.TriggerReciever;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class FlipTrigger implements SensorBasedTrigger,SensorEventListener {

	private Context context = null;
	private boolean IsFlippedDown = false;
	private SensorManager sensormgr = null;
	
	public void onCreate(Context context,SensorManager sensormanager){
		this.sensormgr = sensormanager;
		this.context = context;
		sensormanager.registerListener(this.getSensorEventListener(), sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 30000);
	}
	
	public SensorEventListener getSensorEventListener(){
		return this;
	}
	
	public void onDestroy(){
		sensormgr.unregisterListener(getSensorEventListener());
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float z = event.values[2];
		
		if(z>=0){
			up();
		}else {
			down();
		}
	}
	
	private void up(){
		if(IsFlippedDown==true){	
			IsFlippedDown=false;
			Intent intent = new Intent(TriggerReciever.ACTION_TRIGGER);
			intent.putExtra("trigger", "FLIPPED_UP");
			
			context.sendBroadcast(intent);
		}
	}
	
	private void down(){
		if(IsFlippedDown==false){	
			IsFlippedDown=true;
			Intent intent = new Intent(TriggerReciever.ACTION_TRIGGER);
			intent.putExtra("trigger", "FLIPPED_DOWN");
			context.sendBroadcast(intent);
		}
	}
}
