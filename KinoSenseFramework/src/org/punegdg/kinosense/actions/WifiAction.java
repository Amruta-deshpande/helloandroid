package org.punegdg.kinosense.actions;

import java.util.Map;

import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * 
 * Action which can turn the Wifi on the device ON or OFF.
 * 
 * @author "Ashish Kalbhor"<ashish.kalbhor@gmail.com>
 *
 */

public class WifiAction implements AbstractAction {

	/**
	 * Android Application Context
	 */	
	private Context context =null;
	
	/**
	 * WifiManager to access the device Wifi actions
	 */
	
	private WifiManager wifimgr;
	
	public void onCreate(Context context) {
		// TODO Auto-generated method stub
		this.context=context;
		wifimgr = (WifiManager)context.getSystemService(context.WIFI_SERVICE);		
	}

	public void perform(Map<String, Object> data) {
		// TODO Auto-generated method stub
		/**
		 * Turn the Wifi State On or Off
		 */
		
		String action = (String)data.get("action");
		if("WIFI_ON".equals(action)){
			wifimgr.setWifiEnabled(true);
		}else if("WIFI_OFF".equals(action)){
			wifimgr.setWifiEnabled(false);
		}
		
	}

	public void onDestroy() {
		// TODO Auto-generated method stub
		wifimgr=null;
	}

}
