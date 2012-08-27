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
import org.punegdg.kinosense.triggers.framework.BroadCastReceiverBasedTrigger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

/**
 * This Trigger is for the action when User connects or disconnects the phone to
 * a power source face up
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 */
public class PowerConnectedTrigger extends BroadcastReceiver implements
		BroadCastReceiverBasedTrigger {

	/**
	 * Android's Application Context
	 */
	private Context context = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.triggers.BroadCastReceiverTrigger#onCreate(android
	 * .content.Context)
	 */
	public void onCreate(Context context) {
		this.context = context;
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_POWER_CONNECTED);
		filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
		context.registerReceiver(getBroadCastReceiver(), filter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.triggers.BroadCastReceiverTrigger#getBroadCastReceiver
	 * ()
	 */
	public BroadcastReceiver getBroadCastReceiver() {
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.triggers.BroadCastBasedReceiverTrigger#onDestroy()
	 */

	public void onDestroy() {
		context.unregisterReceiver(getBroadCastReceiver());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.content.BroadcastReceiver#onReceive(android.content.Context,
	 * android.content.Intent)
	 */

	public void onReceive(Context context, Intent intent) {
		Log.d("BroadCastReceiver", intent.toString());

		String action = intent.getAction();

		if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
			Intent bcIntent = new Intent(TriggerReceiver.ACTION_KINOSENSE_TRIGGER);
			bcIntent.putExtra("trigger", "POWER_CONNECTED");
			context.sendBroadcast(bcIntent);

		} else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
			Intent bcIntent = new Intent(TriggerReceiver.ACTION_KINOSENSE_TRIGGER);
			bcIntent.putExtra("trigger", "POWER_DISCONNECTED");
			context.sendBroadcast(bcIntent);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.content.BroadcastReceiver#peekService(android.content.Context,
	 * android.content.Intent)
	 */
	@Override
	public IBinder peekService(Context myContext, Intent service) {
		// TODO Auto-generated method stub
		return super.peekService(myContext, service);
	}

}
