package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

import com.berkeleychurchill.chembal.InvalidUserInputException;
import com.berkeleychurchill.chembal.Main;

import java.util.ArrayList;

public class EqnBalancer extends Activity {

    String[] elements;
    private Spinner elementsSpinner;
    private ArrayList<String> compounds = new ArrayList<String>();
    private String compound = "";
    private TextView compoundTextView;
    private TextView eqnView;
    private int index;
    private String equation = "-->";
    private String coefficient = "";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqnbalancer);

        compoundTextView = (TextView) findViewById(R.id.compoundTextView);
        eqnView = (TextView) findViewById(R.id.eqnView);


        elementsSpinner = (Spinner) findViewById(R.id.eqnBalancerSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.elements_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elementsSpinner.setAdapter(adapter);

        elementsSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                index = arg0.getSelectedItemPosition();
                elements = getResources().getStringArray(R.array.elements_array);
                // Toast.makeText(getBaseContext(), "You have selected: " +elements[index], Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // do nothing
            }
        });

    }

    public void onButtonClick(View v) {
        switch(v.getId()) {

            case R.id.clearCmdButton:
                compoundTextView.setText("");
                compound = "";
                break;

            case R.id.cmdAddLeft:

                if (compoundTextView.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a compound", Toast.LENGTH_LONG).show();
                }
                else {
                    eqnView.setText("");

                    if (equation.indexOf('-') != 0) {
                        String equation2 = equation.substring(equation.indexOf('-') - 1);
                        equation = equation.substring(0, equation.indexOf('-') - 1) + " + " + coefficient +
                                compound + equation2;
                    }
                    else {
                        equation = coefficient + compound + " " + equation;
                    }

                    eqnView.setText(equation);
                    compoundTextView.setText("");
                    EditText coefficientText = (EditText)findViewById(R.id.coefficientEqnBalancer);
                    coefficientText.setText("");
                    EditText subscriptText = (EditText)findViewById(R.id.subscriptEditText);
                    subscriptText.setText("");
                    compound = "";
                    coefficient = "";
                }
                break;

            case R.id.cmdAddRight:
                if (compoundTextView.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a compound", Toast.LENGTH_LONG).show();
                }
                else {
                    eqnView.setText("");

                    if (equation.indexOf('>') != equation.length() - 1) {
                        equation = equation + " + " + coefficient + compound;
                    }
                    else {
                        equation = equation + " " + coefficient + compound;
                    }

                    eqnView.setText(equation);
                    compoundTextView.setText("");
                    EditText coefficientText = (EditText)findViewById(R.id.coefficientEqnBalancer);
                    coefficientText.setText("");
                    EditText subscriptText = (EditText)findViewById(R.id.subscriptEditText);
                    subscriptText.setText("");
                    compound = "";
                    coefficient = "";
                }
                break;

            case R.id.balanceEqnButton:
                try {
                    String answer = Main.balance(equation);
                    eqnView.setText(answer);
                } catch (InvalidUserInputException e) {

                }

                break;

            case R.id.clearEqnButton:
                eqnView.setText("");
                equation = "-->";
                break;

            case R.id.buttonCoeff:
                EditText coefficientText = (EditText)findViewById(R.id.coefficientEqnBalancer);
                coefficient = coefficientText.getText().toString();
                String selectedElement = elements[index];
                EditText subscriptText = (EditText)findViewById(R.id.subscriptEditText);
                String subscript = subscriptText.getText().toString();
                compound = compound + selectedElement + subscript;
                compoundTextView.setText(coefficient + compound);

                break;

            default:
        }
    }


}
