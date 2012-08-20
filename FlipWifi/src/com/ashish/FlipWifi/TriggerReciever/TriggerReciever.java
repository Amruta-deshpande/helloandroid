package com.ashish.FlipWifi.TriggerReciever;

import com.ashish.FlipWifi.Actions.BaseAction;
import com.ashish.FlipWifi.Actions.MyAction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TriggerReciever extends BroadcastReceiver {
	
	public static String ACTION_TRIGGER = "com.ashish.FlipWifi.TRIGGER";

	private BaseAction myaction = new MyAction();
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		myaction.onCreate(context);
		
		String trigger = intent.getStringExtra("trigger");
		
		if("FLIPPED_UP".equals(trigger)){
			Toast toast = Toast.makeText(context, "Flipped Up !!", 1000);
			toast.show();
			myaction.Perform(null);
		}
		else if("FLIPPED_DOWN".equals(trigger)){
			Toast toast = Toast.makeText(context, "Flipped Down !!", 1000);
			toast.show();			
			myaction.Perform(null);
		}
		
	}

}
