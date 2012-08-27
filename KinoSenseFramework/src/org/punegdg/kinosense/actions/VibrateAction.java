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
package org.punegdg.kinosense.actions;

import java.util.Map;

import android.content.Context;
import android.os.Vibrator;

/**
 * Vibrate Action vibrates the phone for a defined duration
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 * 
 * 
 */
// FIXME - We are not using all features of vibration
public class VibrateAction implements AbstractAction {

	/**
	 * Android Application Context
	 */
	private Context context = null;

	/**
	 * Android Vibrator Service
	 */
	private Vibrator vibrator;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.actions.BaseAction#onCreate(android.content.Context
	 * )
	 */
	public void onCreate(Context context) {
		this.context = context;
		vibrator = (Vibrator) context
				.getSystemService(context.VIBRATOR_SERVICE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.punegdg.kinosense.actions.BaseAction#perform(java.lang.String,
	 * java.lang.String)
	 */
	public void perform(Map<String,Object> data) {
		if (null != vibrator) {
			vibrator.vibrate(2000);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.punegdg.kinosense.actions.BaseAction#onDestroy()
	 */
	public void onDestroy() {
		vibrator = null;

	}

}
