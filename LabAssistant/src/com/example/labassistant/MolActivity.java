package com.example.labassistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;


public class MolActivity extends Activity {

    private Spinner elementsSpinner;
    private int index;
    private String[] elements;
    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private ArrayList<Integer> subscripts = new ArrayList<Integer>();
    private String compound = "";
    private TextView molCompoundView;
    private TextView molDisplayValue;


    private Double[] molWeights = {227.0, 107.87, 26.982, 39.948, 74.922, 210.0, 196.97, 10.811, 137.33, 9.0122, 272.0,
            208.98, 247.0, 79.904, 12.011, 40.078, 112.41, 140.12, 251.0, 35.453, 247.0, 285.0, 58.933, 51.996,
            132.91, 63.546, 268.0, 281.0, 162.5, 167.26, 252.0, 151.96, 183.998, 55.845, 287.0, 257.0, 223.0, 69.723,
            157.25, 72.64, 1.0079, 4.0026, 178.49, 200.59, 164.93, 277.0, 126.9, 114.82, 192.22, 39.098, 83.798, 138.91,
            6.941, 262.0, 174.97, 291.0, 258.0, 24.305, 54.938, 95.96, 276.0, 14.007, 22.99, 92.906, 144.24, 20.18, 58.693,
            259.0, 237.0, 15.999, 190.23, 30.974, 231.04, 207.2, 106.42, 145.0, 209.0, 140.91, 195.08, 244.0, 226.0, 85.468,
            186.21, 267.0, 280.0, 102.91, 222.0, 101.07, 32.065, 121.76, 44.956, 78.96, 271.0, 28.086, 150.36, 118.71,
            87.62, 180.95, 158.93, 98.0, 127.6, 232.04, 47.867, 204.38, 168.93, 238.03, 50.942, 183.84, 131.29,
            88.906, 173.05, 65.38, 91.224};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_mol);

            molCompoundView = (TextView) findViewById(R.id.molCompoundView);
            molDisplayValue = (TextView) findViewById(R.id.molDisplayValue);

		    elementsSpinner = (Spinner) findViewById(R.id.molWeightSpinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.elements_array, android.R.layout.simple_spinner_item);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            elementsSpinner.setAdapter(adapter);

            elementsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    index = arg0.getSelectedItemPosition();
                    elements = getResources().getStringArray(R.array.elements_array);
                }

                public void onNothingSelected(AdapterView<?> arg0) {
                    //do nothing
                }
            });
		}
		
		public void onButtonClick(View v)
		{
			switch(v.getId())
			{
                case R.id.molAddElementButton:
                    EditText subscriptText = (EditText) findViewById(R.id.molEditSubscript);
                    String subscript = subscriptText.getText().toString();
                    if (subscript.equals("")) {
                        subscripts.add(1);
                    }
                    else {
                        subscripts.add(Integer.parseInt(subscript));
                    }
                    indices.add(index);
                    compound = compound + elements[index] + subscript;
                    molCompoundView.setText(compound);
                    subscriptText.setText("");
                    break;

                case R.id.molCalculatebutton:
                    double mass = 0;
                    for (int i = 0; i < subscripts.size(); i++) {
                        double value = subscripts.get(i) * molWeights[indices.get(i)];
                        mass += value;
                    }

                    String molarMass = Double.toString(mass);
                    molDisplayValue.setText(molarMass);
                    indices.clear();
                    subscripts.clear();
                    compound = "";
                    molCompoundView.setText("");

                    break;
				
			    case R.id.clearbutton:
                    indices.clear();
                    subscripts.clear();
                    compound = "";
                    molCompoundView.setText("");
                    molDisplayValue.setText("");
			        break;

                default:
			}
			
		}
	
	
	
}
