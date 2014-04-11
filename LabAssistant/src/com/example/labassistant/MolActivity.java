package com.example.labassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MolActivity extends Activity {

	Button   okbutton;
	EditText compoundtext;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_mol);

		    okbutton = (Button)findViewById(R.id.okbutton);
		    compoundtext   = (EditText)findViewById(R.id.compoundtext);

		    okbutton.setOnClickListener(
		        new View.OnClickListener()
		        {
		            public void onClick(View view)
		            {
		                Log.v("EditText", compoundtext.getText().toString());
		            }
		        });
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		
		public void onButtonClick(View v)
		{
			switch(v.getId())
			{
			
			case R.id.okbutton:
				String text = compoundtext.getText().toString();
				EditText finalmassText = (EditText)findViewById(R.id.finalmasstext);
				finalmassText.setText(text);
				
				break;
				
			case R.id.clearbutton:
				
				
				
				break;
			
			
			
			default:
			}
			
		}
	
	
	
}
