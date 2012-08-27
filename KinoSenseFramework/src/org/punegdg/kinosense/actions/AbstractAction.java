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

/**
 * Contract for all Action classes. The life cycle methods are explained as
 * follows
 * <ul>
 * <li>onCreate - Called once when creating an instance of this action.
 * Application Context is passed here</li>
 * <li>performAction - Called each time when an action needs to be performed</li>
 * <li>onDestroy - Called once when this action needs to be destroyed. Clean up
 * needs to be done here</li>
 * 
 * 
 * </ul>
 * 
 * @author "Rohit Ghatol"<rohitsghatol@gmail.com>
 * 
 */
public interface AbstractAction {
	/**
	 * Called once when creating an instance of this action.
	 * 
	 * @param context
	 *            Android Application Context
	 */
	public void onCreate(Context context);

	/**
	 * Called each time when an action needs to be performed
	 * 
	 * @param action
	 * @param extra
	 */
	public void perform(Map<String,Object> data);

	/**
	 * Called once when this action needs to be destroyed. Clean up needs to be
	 * done here
	 */
	public void onDestroy();

}
