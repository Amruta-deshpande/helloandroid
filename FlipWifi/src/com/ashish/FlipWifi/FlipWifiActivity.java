package com.ashish.FlipWifi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ashish.FlipWifi.Sensors.SensorService;

public class FlipWifiActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent myintent = new Intent(getApplicationContext(), SensorService.class);
        startService(myintent);      //START THE SENSING SERVICE
   }
   
    
    protected void onStop(){
    	super.onStop();
    }
}