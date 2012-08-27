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
package org.punegdg.kinosense.triggers.framework;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Contract to write trigger points which source from sensor events
 * 
 * The life cycle methods are explained as follows
 * <ul>
 * <li>onCreate - Called once when creating an instance of this action.
 * Application Context is passed here. Responsible for registering a proper
 * intent filter</li>
 * <li>getSensorEventListener - Called to get access to underlying
 * SensorEventListener</li>
 * <li>onDestroy - Called once when this action needs to be destroyed. Clean up
 * needs to be done here</li>
 * 
 * @author "Rohit Ghatol" <rohitsghatol@gmail.com>
 * 
 */
public interface SensorBasedTrigger {

	/**
	 * Called once when creating an instance of this action. Responsible for
	 * registering a proper sensor event listener
	 * 
	 * @param context
	 *            Android's Application Context
	 * @param sensorManager
	 *            Android's Sensor Manager
	 */
	public void onCreate(Context context, SensorManager sensorManager);

	/**
	 * 
	 * @return underlying SensorEventListener
	 */
	public SensorEventListener getSensorEventListener();

	/**
	 * Called once when this action needs to be destroyed. Clean up needs to be
	 * done here
	 * 
	 * 
	 */
	public void onDestroy();

}
