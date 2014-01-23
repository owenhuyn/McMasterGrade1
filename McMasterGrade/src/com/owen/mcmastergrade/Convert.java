package com.owen.mcmastergrade;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Convert extends Activity {

	double numGrade;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_convert);
		
		Intent i = getIntent();
		
		
		ScrollView sv = new ScrollView(Convert.this);
		final LinearLayout ll = new LinearLayout(Convert.this);
		ll.setOrientation(LinearLayout.VERTICAL);
		sv.addView(ll);
		
		
		
        Button convert = (Button)findViewById(R.id.convert);
        final EditText markEdit   = (EditText)findViewById(R.id.edit);	
        
        
        
        convert.setOnClickListener(new View.OnClickListener(){
    	
        	
        
        	public void onClick(View v){
        		
        		
        		TextView text = (TextView)findViewById(R.id.InfoText);
        		text.setText("Your mark is:");
        		
        		numGrade = Double.parseDouble(markEdit.getText().toString());
        		
        		double realgrade = 0;
        		if (numGrade >= 0){
        			
	        		if ((numGrade >= 1)&&(numGrade <= 6)){
	        			realgrade = (0.32*numGrade+0.38);
	        		}
	        			else if ((numGrade < 1)){
	        			realgrade = (0.7*numGrade);
	        		}
	        			else if ((numGrade > 6)&&(numGrade <= 7)){
	        			realgrade = (0.4*numGrade-0.1);
	        		}
	        			else if ((numGrade > 7) && (numGrade <= 9)){
	        			realgrade = (0.3*numGrade+0.6);
	        		}
	        			else if ((numGrade > 9) && (numGrade <= 10)){
	        			realgrade = (0.4*numGrade-0.3);
	        		}
	        			else if ((numGrade > 10) && (numGrade <= 11)){
	        			realgrade = (0.2*numGrade+1.7);
	        		}
	        			else if ((numGrade > 11) && (numGrade <= 12)){
	        			realgrade = (0.1*numGrade+2.8);
	        		}
	        			else{
	        				
	        			}
        		}
        		
        		String grade = String.valueOf(realgrade);
        		
        		TextView text1 = (TextView)findViewById(R.id.grade);
        		text1.setTextSize(2, 100);
        		text1.setText(grade);
        		
        		

        	}
        }
        
        		);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.convert, menu);
		return true;
	}

}
