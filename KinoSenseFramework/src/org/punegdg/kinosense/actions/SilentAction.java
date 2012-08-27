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
import android.media.AudioManager;

/**
 * Action which can silent the phone and on the flip side raise the volume to
 * max.
 * 
 *@author "Rohit Ghatol"<rohitsghatol@gmail.com>
 * 
 */
// FIXME - Need to decide what is the scope of Silent Action, also what can we
// do to undo this action
public class SilentAction implements AbstractAction {

	/**
	 * Android Application Context
	 */
	private Context context = null;
	/**
	 * Audio Manager used to change the ringer volume
	 */
	private AudioManager audioManager = null;
	
	/**
	 * Last stored volume
	 */
	private int lastVolume = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.actions.BaseAction#onCreate(android.content.Context
	 * )
	 */
	public void onCreate(Context context) {
		this.context = context;
		audioManager = (AudioManager) context
				.getSystemService(context.AUDIO_SERVICE);
		// lastVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.punegdg.kinosense.actions.BaseAction#onAction(java.lang.String,
	 * java.lang.String)
	 */
	public void perform(Map<String,Object> data) {
		String action = (String)data.get("action");
		if ("Silence".equals(action)) {
			lastVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
			audioManager.setStreamVolume(AudioManager.STREAM_RING, 0,
					AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
		} else if ("Restore".equals(action)) {
			audioManager.setStreamVolume(AudioManager.STREAM_RING, 7,
					AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.punegdg.kinosense.actions.BaseAction#onDestroy(android.content.Context
	 * )
	 */
	public void onDestroy() {
		audioManager = null;
	}

}
