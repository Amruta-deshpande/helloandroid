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
package org.punegdg.kinosense.triggerReceiver;

import java.util.HashMap;
import java.util.Map;

import org.punegdg.kinosense.actions.AbstractAction;
import org.punegdg.kinosense.actions.SilentAction;
import org.punegdg.kinosense.actions.VibrateAction;
import org.punegdg.kinosense.actions.WifiAction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Receives all the Kino Sense Triggers and runs the rules to invoke the
 * corresponding actions
 * 
 * @author "Rohit Ghatol" <rohitsghatol@gmail.com>
 * 
 */
public class TriggerReceiver extends BroadcastReceiver {
	public static String ACTION_KINOSENSE_TRIGGER = "org.punegdg.kinosense.TRIGGER";

	/** 
	 * Silent Action 
	 */
	private AbstractAction silentAction = new SilentAction();
	
	/**
	 * Vibrate Action
	 */
	private AbstractAction vibrateAction = new VibrateAction();

	/**
	 * Wifi Action
	 */
	
	private AbstractAction wifiAction = new WifiAction();
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public void onReceive(Context context, Intent intent) {

		// -----------------------------
		// FIXME Fix the following
		// -----------------------------
		silentAction.onCreate(context);
		vibrateAction.onCreate(context);
		wifiAction.onCreate(context);
		// -----------------------------

		String trigger = intent.getStringExtra("trigger");
		if ("FLIPPED_DOWN".equals(trigger)) {
			vibrateAction.perform(null);
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("action","Silence");
			silentAction.perform(data);
			data.put("action", "WIFI_OFF");
			wifiAction.perform(data);
			
		} else if ("FLIPPED_UP".equals(trigger)) {
			vibrateAction.perform(null);
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("action","Restore");
			silentAction.perform(data);
			data.put("action", "WIFI_ON");
			wifiAction.perform(data);
		}
		
		if ("POWER_CONNECTED".equals(trigger)) {
			vibrateAction.perform(null);
			
		} else if ("POWER_DISCONNECTED".equals(trigger)) {
			vibrateAction.perform(null);
			
		}
	}

}
