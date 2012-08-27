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
package org.punegdg.kinosense.triggers;

import org.punegdg.kinosense.triggerReceiver.TriggerReceiver;
import org.punegdg.kinosense.triggers.framework.SensorBasedTrigger;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * This Trigger is for the action when User flips the phone either face down or
 * face up
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 * 
 */
public class FlipTrigger implements SensorBasedTrigger, SensorEventListener {

	/**
	 * Android's Application Context
	 */
	private Context context = null;
	
	/**
	 * Android's Sensor Manager
	 */
	private SensorManager sensorManager = null;
	
	/**
	 * Internal State whether Phone is Flipped Up or Flipped Down
	 */
	private boolean isFlippedDown = false;

	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.triggers.SensorBasedTrigger#onCreate
	 */
	public void onCreate(Context context, SensorManager sensorManager) {
		this.context = context;
		this.sensorManager = sensorManager;
		sensorManager.registerListener(this.getSensorEventListener(),
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);

	}
	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.triggers.SensorBasedTrigger#getSensorEventListener
	 */
	public SensorEventListener getSensorEventListener() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.triggers.SensorBasedTrigger#onDestroy
	 */
	public void onDestroy() {
		sensorManager.unregisterListener(getSensorEventListener());

	}

	
	/* (non-Javadoc)
	 * @see android.hardware.SensorEventListener#onAccuracyChanged
	 */
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.hardware.SensorEventListener#onSensorChanged
	 */
	public void onSensorChanged(SensorEvent event) {
		float zAxis = event.values[2];
		if (zAxis >= 0) {
			flippedUp();
		} else {
			flippedDown();
		}

	}

	/**
	 * Called when phone is flipped up (face is up)
	 */
	private void flippedUp() {
		if (isFlippedDown == true) {
			isFlippedDown = false;
			Intent intent = new Intent(TriggerReceiver.ACTION_KINOSENSE_TRIGGER);
			
			intent.putExtra("trigger", "FLIPPED_UP");
			context.sendBroadcast(intent);
		}

	}
	/**
	 * Called when phone is flipped down (face id down)
	 */
	private void flippedDown() {
		if (isFlippedDown == false) {
			isFlippedDown = true;
			Intent intent = new Intent(TriggerReceiver.ACTION_KINOSENSE_TRIGGER);

			intent.putExtra("trigger", "FLIPPED_DOWN");
			context.sendBroadcast(intent);
		}
	}

}
