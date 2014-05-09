package com.example.labassistant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;


public class SolutionsActivity extends Activity {

    private Spinner elementsSpinner;
    private int index;
    private String[] elements;

    private ArrayList<Integer> indices = new ArrayList<Integer>();
    private ArrayList<Integer> subscripts = new ArrayList<Integer>();

    private String compound = "";
    private TextView solCompoundView;
    private TextView solCompoundView2;
    private TextView solCompoundView3;
    private TextView solCompoundView4;

    private RadioButton soluteMolUnits4;
    private RadioButton soluteGramUnits4;

    private boolean molesUsed = false;
    private boolean solveMolarity = false;
    private boolean selectUnits = false;
    private boolean selectVariable = false;
    private boolean solvePPM = false;
    private boolean solveMGL = false;
    private boolean solvePercent = false;


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
			setContentView(R.layout.solutions_type_select);
		}
		
		public void onButtonClick(View v)
		{
            ArrayAdapter<CharSequence> adapter;
			switch(v.getId())
			{
                case R.id.molarityRadioButton:
                    setContentView(R.layout.activity_solutions);

                    solCompoundView = (TextView) findViewById(R.id.solCompoundView);
                    indices.clear();
                    subscripts.clear();
                    molesUsed = false;
                    solveMolarity = false;
                    selectUnits = false;
                    selectVariable = false;
                    solvePPM = false;
                    solveMGL = false;
                    solvePercent = false;
                    compound = "";
                    elementsSpinner = (Spinner) findViewById(R.id.solutionSpinner);
                    adapter = ArrayAdapter.createFromResource(this,
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
                    break;
                case R.id.ppmRadioButton:
                    setContentView(R.layout.activity_solutions_ppm);
                    solCompoundView2 = (TextView) findViewById(R.id.solCompoundView2);
                    indices.clear();
                    subscripts.clear();
                    molesUsed = false;
                    solveMolarity = false;
                    selectUnits = false;
                    selectVariable = false;
                    solvePPM = false;
                    solveMGL = false;
                    solvePercent = false;
                    compound = "";
                    elementsSpinner = (Spinner) findViewById(R.id.solutionSpinner2);
                     adapter = ArrayAdapter.createFromResource(this,
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
                    break;
                case R.id.mgLRadioButton:
                    setContentView(R.layout.activity_solutions_mgl);
                    solCompoundView3 = (TextView) findViewById(R.id.solCompoundView3);
                    indices.clear();
                    subscripts.clear();
                    molesUsed = false;
                    solveMolarity = false;
                    selectUnits = false;
                    selectVariable = false;
                    solvePPM = false;
                    solveMGL = false;
                    solvePercent = false;
                    compound = "";
                    elementsSpinner = (Spinner) findViewById(R.id.solutionSpinner3);
                    adapter = ArrayAdapter.createFromResource(this,
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
                    break;
                case R.id.percentRadioButton:
                    setContentView(R.layout.activity_solutions_percent);
                    solCompoundView4 = (TextView) findViewById(R.id.solCompoundView4);
                    indices.clear();
                    subscripts.clear();
                    molesUsed = false;
                    solveMolarity = false;
                    selectUnits = false;
                    selectVariable = false;
                    solvePPM = false;
                    solveMGL = false;
                    solvePercent = false;
                    compound = "";
                    elementsSpinner = (Spinner) findViewById(R.id.solutionSpinner4);
                    adapter = ArrayAdapter.createFromResource(this,
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

                    soluteMolUnits4 = (RadioButton) findViewById(R.id.soluteMolUnits4);
                    soluteMolUnits4.setVisibility(View.INVISIBLE);
                    soluteGramUnits4 = (RadioButton) findViewById(R.id.soluteGramUnits4);
                    soluteGramUnits4.setVisibility(View.INVISIBLE);
                    break;
                case R.id.solAddCompound:
                    EditText subscriptText = (EditText) findViewById(R.id.subscriptSolEdit);
                    String subscript = subscriptText.getText().toString();
                    if (subscript.equals("")) {
                        subscripts.add(1);
                    }
                    else {
                        subscripts.add(Integer.parseInt(subscript));
                    }
                    indices.add(index);
                    compound = compound + elements[index] + subscript;
                    solCompoundView.setText(compound);
                    subscriptText.setText("");
                    break;
                case R.id.solClearCompound:
                    indices.clear();
                    subscripts.clear();
                    compound = "";
                    solCompoundView.setText("");
                    break;
                case R.id.soluteMolUnits:
                    molesUsed = true;
                    selectUnits = true;
                    break;
                case R.id.soluteGramUnits:
                    molesUsed = false;
                    selectUnits = true;
                    break;
                case R.id.solveMassRadioButton:
                    solveMolarity = false;
                    selectVariable = true;
                    break;
                case R.id.solveMolarityRadioButton:
                    solveMolarity = true;
                    selectVariable = true;
                    break;
                case R.id.solCalcButton:
                    EditText volumeEdit = (EditText) findViewById(R.id.volumeEdit);
                    EditText molarityEdit = (EditText) findViewById(R.id.molarityEdit);
                    EditText soluteEdit = (EditText) findViewById(R.id.soluteEdit);
                    if (volumeEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the total volume", Toast.LENGTH_LONG).show();
                    }
                    else if (solCompoundView.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a valid compound", Toast.LENGTH_LONG).show();
                    }
                    else if (!selectVariable) {
                        Toast.makeText(getApplicationContext(), "Choose a variable to solve for", Toast.LENGTH_LONG).show();
                    }
                    else if (!selectUnits) {
                        Toast.makeText(getApplicationContext(), "Choose units for the result", Toast.LENGTH_LONG).show();
                    }
                    else if (!solveMolarity && molarityEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Molarity needed to solve for solute mass", Toast.LENGTH_LONG).show();
                    }
                    else if (solveMolarity && soluteEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Solute mass needed to solve for molarity", Toast.LENGTH_LONG).show();
                    }
                    else {
                        //solve for molarity
                        if (solveMolarity) {
                            double volume = Double.parseDouble(volumeEdit.getText().toString());
                            double solute = Double.parseDouble(soluteEdit.getText().toString());
                            if (!molesUsed) {
                                double mass = 0;
                                for (int i = 0; i < subscripts.size(); i++) {
                                    double value = subscripts.get(i) * molWeights[indices.get(i)];
                                    mass += value;
                                }
                                solute = solute/mass;
                            }
                            double answer = solute/volume;
                            String result = "Molarity = " + answer + " M";
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(result).setTitle("Molarity of Solution: ");
                            builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                            builder.create();
                            builder.show();
                        }

                        //solve for amount of solute
                        else {
                            double volume = Double.parseDouble(volumeEdit.getText().toString());
                            double molarity = Double.parseDouble(molarityEdit.getText().toString());
                            double answer = volume * molarity;
                            if (molesUsed) {
                                String result = "Solute = " + answer + " mol";
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setMessage(result).setTitle("Amount of Solute to Add: ");
                                builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                                builder.create();
                                builder.show();
                            }
                            else {
                                double mass = 0;
                                for (int i = 0; i < subscripts.size(); i++) {
                                    double value = subscripts.get(i) * molWeights[indices.get(i)];
                                    mass += value;
                                }
                                answer = answer * mass;
                                String result = "Solute = " + answer + " g";
                                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                                builder.setMessage(result).setTitle("Amount of Solute to Add: ");
                                builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                                builder.create();
                                builder.show();
                            }
                        }
                    }

                    break;
                case R.id.solAddCompound2:
                    EditText subscriptText2 = (EditText) findViewById(R.id.subscriptSolEdit2);
                    String subscript2 = subscriptText2.getText().toString();
                    if (subscript2.equals("")) {
                        subscripts.add(1);
                    }
                    else {
                        subscripts.add(Integer.parseInt(subscript2));
                    }
                    indices.add(index);
                    compound = compound + elements[index] + subscript2;
                    solCompoundView2.setText(compound);
                    subscriptText2.setText("");
                    break;
                case R.id.solClearCompound2:
                    indices.clear();
                    subscripts.clear();
                    compound = "";
                    solCompoundView2.setText("");
                    break;
                case R.id.soluteMolUnits2:
                    molesUsed = true;
                    selectUnits = true;
                    break;
                case R.id.soluteGramUnits2:
                    molesUsed = false;
                    selectUnits = true;
                    break;
                case R.id.solveMassRadioButton2:
                    solvePPM = false;
                    selectVariable = true;
                    break;
                case R.id.solvePPMRadioButton2:
                    solvePPM = true;
                    selectVariable = true;
                    break;
                case R.id.solCalcButton2:
                    EditText solventEdit = (EditText) findViewById(R.id.solventEditText);
                    EditText soluteEdit2 = (EditText) findViewById(R.id.soluteEdit2);
                    EditText ppmEdit = (EditText) findViewById(R.id.ppmEdit);

                    if (solCompoundView2.getText().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a valid compound", Toast.LENGTH_LONG).show();
                    }
                    else if (solventEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the solvent mass", Toast.LENGTH_LONG).show();
                    }
                    else if (!selectUnits) {
                        Toast.makeText(getApplication(), "Select units for the solute mass", Toast.LENGTH_LONG).show();
                    }
                    else if(!selectVariable) {
                        Toast.makeText(getApplicationContext(), "Select the variable to solve for", Toast.LENGTH_LONG).show();
                    }
                    else if (solvePPM && soluteEdit2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the solute mass", Toast.LENGTH_LONG).show();
                    }
                    else if (!solvePPM && ppmEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the ppm", Toast.LENGTH_LONG).show();
                    }
                    else {
                        //all necessary variables are defined
                        if (solvePPM) {
                            Double ppm;
                            Double solute = Double.parseDouble(soluteEdit2.getText().toString());
                            if (molesUsed) {
                                //convert mass in moles to grams
                                double mass = 0;
                                for (int i = 0; i < subscripts.size(); i++) {
                                    double value = subscripts.get(i) * molWeights[indices.get(i)];
                                    mass += value;
                                }
                                solute *= mass;

                            }
                            Double solvent = Double.parseDouble(solventEdit.getText().toString());
                            ppm = solute / (solute + solvent);
                            ppm = ppm * 1000000;
                            String result = ppm.toString();
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(result).setTitle("Solute's ppm: ");
                            builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                            builder.create();
                            builder.show();
                        }
                        else {
                            String result;
                            Double ppm = Double.parseDouble(ppmEdit.getText().toString());
                            ppm = ppm / 1000000;
                            Double solvent = Double.parseDouble(solventEdit.getText().toString());
                            Double solute = (ppm * solvent) / (1 - ppm);
                            if (molesUsed) {
                                double mass = 0;
                                for (int i = 0; i < subscripts.size(); i++) {
                                    double value = subscripts.get(i) * molWeights[indices.get(i)];
                                    mass += value;
                                }
                                solute = solute / mass;
                                result = "Solute = " + solute + " mol";
                            }
                            else {
                                result = "Solute = " + solute + " g";
                            }
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage(result).setTitle("Solute Mass: ");
                            builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                            {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                            builder.create();
                            builder.show();
                        }
                    }
                    break;
                case R.id.solAddCompound3:
                    EditText subscriptText3 = (EditText) findViewById(R.id.subscriptSolEdit3);
                    String subscript3 = subscriptText3.getText().toString();
                    if (subscript3.equals("")) {
                        subscripts.add(1);
                    }
                    else {
                        subscripts.add(Integer.parseInt(subscript3));
                    }
                    indices.add(index);
                    compound = compound + elements[index] + subscript3;
                    solCompoundView3.setText(compound);
                    subscriptText3.setText("");
                    break;
                case R.id.solClearCompound3:
                    indices.clear();
                    subscripts.clear();
                    compound = "";
                    solCompoundView3.setText("");
                    break;
                case R.id.soluteMolUnits3:
                    molesUsed = true;
                    selectUnits = true;
                    break;
                case R.id.soluteGramUnits3:
                    molesUsed = false;
                    selectUnits = true;
                    break;
                case R.id.solveMGLRadioButton3:
                    solveMGL = true;
                    selectVariable = true;
                    break;
                case R.id.solveMassRadioButton3:
                    solveMGL = false;
                    selectVariable = true;
                    break;
                case R.id.solCalcButton3:
                    EditText solutionEdit = (EditText) findViewById(R.id.solutionVolumeEditText3);
                    EditText soluteEdit3 = (EditText) findViewById(R.id.soluteEdit3);
                    EditText mglEdit3 = (EditText) findViewById(R.id.mglEdit3);
                    if (solCompoundView3.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a valid compound", Toast.LENGTH_LONG).show();
                    }
                    else if (solutionEdit.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the solution volume", Toast.LENGTH_LONG).show();
                    }
                    else if (!selectUnits) {
                        Toast.makeText(getApplicationContext(), "Select units for the solute", Toast.LENGTH_LONG).show();
                    }
                    else if (!selectVariable) {
                        Toast.makeText(getApplicationContext(), "Select a variable to solve for", Toast.LENGTH_LONG).show();
                    }
                    else if (solveMGL && soluteEdit3.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for the solute mass", Toast.LENGTH_LONG).show();
                    }
                    else if (!solveMGL && mglEdit3.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter a value for milligrams p. liter", Toast.LENGTH_LONG).show();
                    }
                    else {
                       if (solveMGL) {
                           Double solute = Double.parseDouble(soluteEdit3.getText().toString());
                           if (molesUsed) {
                               double mass = 0;
                               for (int i = 0; i < subscripts.size(); i++) {
                                   double value = subscripts.get(i) * molWeights[indices.get(i)];
                                   mass += value;
                               }
                               solute = solute * mass / 0.001;
                           }
                           Double volume = Double.parseDouble(solutionEdit.getText().toString());
                           Double answer = solute/volume;
                           String result = "Concentration = " + answer + " mg/L";
                           AlertDialog.Builder builder = new AlertDialog.Builder(this);
                           builder.setMessage(result).setTitle("Milligrams p. Liter: ");
                           builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                           {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });
                           builder.create();
                           builder.show();
                       }
                       else {
                           //solve for amount of solute
                           Double mgl = Double.parseDouble(mglEdit3.getText().toString());
                           Double volume = Double.parseDouble(solutionEdit.getText().toString());
                           Double amt_solute = mgl * volume;
                           if (molesUsed) {
                               double mass = 0;
                               for (int i = 0; i < subscripts.size(); i++) {
                                   double value = subscripts.get(i) * molWeights[indices.get(i)];
                                   mass += value;
                                   amt_solute = (amt_solute * .001) / mass;
                               }
                           }
                          String result = "Mass = " + amt_solute + " mg";
                           AlertDialog.Builder builder = new AlertDialog.Builder(this);
                           builder.setMessage(result).setTitle("Amount of solute: ");
                           builder.setPositiveButton("Done", new DialogInterface.OnClickListener()
                           {
                               public void onClick(DialogInterface dialog, int id) {
                                   dialog.cancel();
                               }
                           });
                           builder.create();
                           builder.show();
                       }
                    }
                    break;
                case R.id.solAddCompound4:
                    break;
                case R.id.solClearCompound4:
                    break;
                case R.id.solutionLiters4:
                    soluteMolUnits4 = (RadioButton) findViewById(R.id.soluteMolUnits4);
                    soluteMolUnits4.setVisibility(View.INVISIBLE);
                    soluteGramUnits4 = (RadioButton) findViewById(R.id.soluteGramUnits4);
                    soluteGramUnits4.setVisibility(View.INVISIBLE);
                    break;
                case R.id.solutionGrams4:
                    soluteMolUnits4 = (RadioButton) findViewById(R.id.soluteMolUnits4);
                    soluteMolUnits4.setVisibility(View.VISIBLE);
                    soluteGramUnits4 = (RadioButton) findViewById(R.id.soluteGramUnits4);
                    soluteGramUnits4.setVisibility(View.VISIBLE);
                    break;
                case R.id.soluteMolUnits4:
                    break;
                case R.id.soluteGramUnits4:
                    break;
                case R.id.solvePercRadioButton4:
                    break;
                case R.id.solveMassRadioButton4:
                    break;
                case R.id.solCalcButton4:
                    break;
			default:
                break;
			}
			
		}

    }
	


