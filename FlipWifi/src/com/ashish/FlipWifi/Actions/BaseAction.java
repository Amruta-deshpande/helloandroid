package com.ashish.FlipWifi.Actions;

import android.content.Context;

public interface BaseAction {	//Interface for actions
	
	public void onCreate(Context context);
	public void Perform(String action);
	public void onDestroy();
}
