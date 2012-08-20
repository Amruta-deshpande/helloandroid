package com.ashish.FlipWifi.Actions;

import android.content.Context; 
import android.net.wifi.WifiManager;
import android.os.Vibrator;

public class MyAction implements BaseAction {

	private Context context = null;
	private Vibrator vibrator;
	private WifiManager wifimgr;
	
	public void onCreate(Context c){
		this.context=c;
		vibrator = (Vibrator)c.getSystemService(c.VIBRATOR_SERVICE);	//get Vibrate service from device
		wifimgr = (WifiManager)c.getSystemService(c.WIFI_SERVICE);		//get Wifi Service from the device
	}
	
	public void Perform(String action){
		if(null!=vibrator){
			vibrator.vibrate(2000);										//Vibrate at a Frequency
		}
		
		if(wifimgr.isWifiEnabled()){
			wifimgr.setWifiEnabled(false);								//if enabled then disable
		}else{
			wifimgr.setWifiEnabled(true);								//if disabled then enable
		}
		
	}
	
	public void onDestroy(){
		vibrator=null;
	}
	
	
}
