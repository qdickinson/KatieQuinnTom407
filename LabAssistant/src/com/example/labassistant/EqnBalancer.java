package com.example.labassistant;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EqnBalancer extends Activity{

    // Create the text view
    private TextView textView;
    private String input = "->";

    //entry validation: check for valid format in form NumberElementNumberElementNumber..., make sure
    //no other characters are added, check for only valid elements later (make a list of valid elements?)
    //need to think of validation for same elements added to each side

    //figure out why my validation method either fails for everything or passes for everything...is char parsing
    //happening correctly?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eqnbalancer);
        textView = (TextView) findViewById(R.id.equation);

    }

    public void onButtonClick(View v)
    {
        switch(v.getId())
        {
            case R.id.button_clear:

                textView.setText("");
                input = "->";
                break;

            case R.id.button_balance:
                //add code later
                break;

            case R.id.left_add_cmpd:
                textView.setText("");
                EditText mEditLeft   = (EditText)findViewById(R.id.add_cmpd_left);
                if (mEditLeft.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a compound", Toast.LENGTH_LONG).show();
                }
                else {
                    input = textView.getText().toString() + input;
                    if(!validateInput(mEditLeft.getText().toString())) {
                       // Toast.makeText(getApplicationContext(), "Only numbers and letters should be entered", Toast.LENGTH_LONG).show();
                    }
                    //continue implementing input validation
                    if (input.indexOf('-') != 0) {
                        String input2 = input.substring(input.indexOf('-') - 1);
                        input = input.substring(0, input.indexOf('-') - 1) + " + " + mEditLeft.getText().toString() + input2;
                    }
                    else {
                        input = mEditLeft.getText().toString() + " " + input;
                    }
                    textView.setText(input);
                    mEditLeft.setText("");
                }

                break;

            case R.id.right_add_cmpd:
                textView.setText("");
                EditText mEditRight   = (EditText)findViewById(R.id.add_cmpd_right);
                if (mEditRight.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a compound", Toast.LENGTH_LONG).show();
                }
                else {
                    input = textView.getText().toString() + input;
                    if (input.indexOf('>') != input.length() - 1) {
                        input = input + " + " + mEditRight.getText().toString();
                    }
                    else {
                        input = input + " " + mEditRight.getText().toString();
                    }
                    textView.setText(input);
                    mEditRight.setText("");
                }

                break;

            default:
        }
    }

    private boolean validateInput(String compound) {
        for (int i = 0; i < compound.length(); i++) {
            if (Character.getNumericValue(compound.charAt(i)) < 48 || Character.getNumericValue(compound.charAt(i))  > 122) {
                return false;
            }
            else if (Character.getNumericValue(compound.charAt(i))  > 57 && Character.getNumericValue(compound.charAt(i))  < 65) {
                return false;
            }
            else if (Character.getNumericValue(compound.charAt(i))  > 90 && Character.getNumericValue(compound.charAt(i))  < 97) {
                return false;
            }
        }
        return true;

    }


}
