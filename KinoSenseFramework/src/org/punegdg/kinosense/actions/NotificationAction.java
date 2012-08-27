/**
 * 
 */
package org.punegdg.kinosense.actions;

import java.util.Map;

import android.content.Context;

/**
 * @author rohit
 *
 */
public class NotificationAction implements AbstractAction {

	private Context context = null;
	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.AbstractAction#onCreate(android.content.Context)
	 */
	public void onCreate(Context context) {
		this.context = context;

	}

	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.AbstractAction#perform(java.util.Map)
	 */
	public void perform(Map<String, Object> data) {
		String message = (String)data.get("message");

	}

	/* (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.AbstractAction#onDestroy()
	 */
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

}
