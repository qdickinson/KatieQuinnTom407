package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class SolutionsActivity extends Activity {

    private Spinner elementsSpinner;
    private int index;
    private String[] elements;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.solutions_type_select);
		}
		
		public void onButtonClick(View v)
		{
			switch(v.getId())
			{
                case R.id.molarityRadioButton:
                    setContentView(R.layout.activity_solutions);
                    elementsSpinner = (Spinner) findViewById(R.id.solutionSpinner);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.elements_array, android.R.layout.simple_spinner_item);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    elementsSpinner.setAdapter(adapter);

                    elementsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            index = arg0.getSelectedItemPosition();
                            elements = getResources().getStringArray(R.array.elements_array);
                        }

                        public void onNothingSelected(AdapterView<?> arg0) {
                            //do nothing
                        }
                    });
                    //Toast.makeText(getApplicationContext(),"Molarity Option to be Implemented Later", Toast.LENGTH_LONG ).show();
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
                case R.id.solAddCompound:
                    break;
                case R.id.solClearCompound:
                    break;
                case R.id.soluteMolUnits:
                    break;
                case R.id.soluteGramUnits:
                    break;
                case R.id.solveMassRadioButton:
                    break;
                case R.id.solveMolarityRadioButton:
                    break;
                case R.id.solCalcButton:
                    break;
			default:
                break;
			}
			
		}

    }
	


