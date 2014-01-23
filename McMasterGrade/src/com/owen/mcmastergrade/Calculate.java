package com.owen.mcmastergrade;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Calculate extends Activity {
	
	double[] gradeArray =  new double[5];
	double[] unitsArray =  new double[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate);
		
		Intent i = getIntent();
		
		ScrollView sv = new ScrollView(Calculate.this);
		final LinearLayout ll = new LinearLayout(Calculate.this);
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);
		
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.editTextGroupLayout);

        		//ScrollView scrollLayout = (ScrollView) findViewById(R.id.scroll);
        
        for (int j = 1; j < 6; j++){
        	

        	    EditText name = new EditText(Calculate.this);
        	    EditText mark = new EditText(Calculate.this);
        	    
        	    LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
        	    
        	    
        	    name.setId(j);
        	    name.setLayoutParams(params);
        	    name.setHint("Place your Grade out of 12");
        	    mark.setId(2*j);
        	    mark.setLayoutParams(params);
        	    mark.setHint("Your Corresponding Units");

        	    linearLayout.addView(name);
        	    linearLayout.addView(mark);
        	    //scrollLayout.addView(linearLayout);
        }

        Button calculate = (Button)findViewById(R.id.Calculate);
        calculate.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for (int j = 1; j < 6; j++){
					EditText check = (EditText)findViewById(j);
					
					double grades = Double.parseDouble(check.getText().toString());
					gradeArray[j-1] = grades;

					EditText units = (EditText)findViewById(j);
					
					double numberUnits = Double.parseDouble(check.getText().toString());
					unitsArray[j-1] = numberUnits;
					
					
				}
				double total = 0;
				double totalUnits = 0;
				for (int j = 0; j < 5; j++){
					
					
					total = total + gradeArray[j]*unitsArray[j];
					
					totalUnits = totalUnits + unitsArray[j];
					
					
				}
				
				double average = total/totalUnits;
				String average1 = String.valueOf(average);
				
				TextView text1 = (TextView)findViewById(R.id.average);
        		text1.setTextSize(2, 100);
        		text1.setText(average1);
				
			}
        	
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.convert, menu);
		return true;
	}

}
