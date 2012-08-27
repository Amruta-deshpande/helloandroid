package com.example.myapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	Button button;
	ImageView imgvi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        addOnListener();
    }

    public void addOnListener() {
		button =(Button) findViewById(R.id.Click);
		imgvi =(ImageView) findViewById(R.id.imageView1);
		button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				imgvi.setImageResource(R.drawable.android3d);
			}
		});
		
	}

}
