package com.ashish.FlipWifi.Triggers;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public interface SensorBasedTrigger {
	public void onCreate(Context c,SensorManager sm);
	public SensorEventListener getSensorEventListener();
	public void onDestroy();
}
