package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


public class SolutionsActivity extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.solutions_type_select);
		}
		
		public void onRadioButtonClicked(View v)
		{
			switch(v.getId())
			{
                case R.id.molarityRadioButton:
                    Toast.makeText(getApplicationContext(),"Molarity Option to be Implemented Later", Toast.LENGTH_LONG ).show();
                    break;
                case R.id.ppmRadioButton:
                    Toast.makeText(getApplicationContext(),"ppm Option to be Implemented Later", Toast.LENGTH_LONG ).show();
                    break;
                case R.id.mgLRadioButton:
                    Toast.makeText(getApplicationContext(),"mg/L Option to be Implemented Later", Toast.LENGTH_LONG ).show();
                    break;
                case R.id.percentRadioButton:
                    Toast.makeText(getApplicationContext(),"% [] Option to be Implemented Later", Toast.LENGTH_LONG ).show();
                    break;
			default:
                break;
			}
			
		}
	
	}

