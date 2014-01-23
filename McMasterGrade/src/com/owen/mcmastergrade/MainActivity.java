package com.owen.mcmastergrade;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ImageButton calculateButton = (ImageButton)findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Intent calc = new Intent(MainActivity.this, Calculate.class);
    			startActivity(calc);
        	}
		});		
		
		
        ImageButton convertButton = (ImageButton)findViewById(R.id.convert);
        convertButton.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		Intent convert = new Intent(MainActivity.this, Convert.class);
    			startActivity(convert);
        	}
		});		
		
		
        ImageButton exit = (ImageButton)findViewById(R.id.exit);
		exit.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v){
        		System.exit(0);
        	}
		});		
				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
