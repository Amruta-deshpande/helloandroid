/**
 * Copyright 2012 Pune-GDG (http://meetup.com/pune-gdg)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.punegdg.kinosense.eventsource;

import org.punegdg.kinosense.triggers.FlipTrigger;
import org.punegdg.kinosense.triggers.framework.SensorBasedTrigger;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

/**
 * Sensor Listener Service. Listens to various sensor and delegates to
 * SensorBasedTrigger for processing the sensor events
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 * 
 */
public class SensorService extends Service {

	/**
	 * Android's Sensor Manager
	 */
	private SensorManager sensorMgr = null;

	/**
	 * The Trigger to handle the low level sensor events.
	 */
	private SensorBasedTrigger flipTrigger = new FlipTrigger();

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onCreate()
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("SensorService", "Service Started");
		sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
		flipTrigger.onCreate(getApplicationContext(), sensorMgr);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("SensorService", "Service Destroyed");
		flipTrigger.onDestroy();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
