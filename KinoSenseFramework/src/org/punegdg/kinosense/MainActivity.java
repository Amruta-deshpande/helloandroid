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
package org.punegdg.kinosense;

import org.punegdg.kinosense.eventsource.SensorService;
import org.punegdg.kinosense.triggers.PowerConnectedTrigger;
import org.punegdg.kinosense.triggers.framework.BroadCastReceiverBasedTrigger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

/**
 * Currently this Activity is bootstrap to number of things in the PoC state e.g like the Service which listens to Sensor events and code which registers various broadcast recievers.
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 *
 */
public class MainActivity extends Activity {

	/**
	 * Power Connected Disconnected BroadCastReceiver
	 */
	private BroadCastReceiverBasedTrigger bbTrigger = new PowerConnectedTrigger();

	
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bbTrigger.onCreate(getApplicationContext());

		Intent startServiceIntent = new Intent(getApplicationContext(),
				SensorService.class);
		startService(startServiceIntent);

	}

	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}



	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		super.onStop();
		bbTrigger.onDestroy();
	}




}
