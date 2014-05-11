package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpPagesActivity extends Activity {

    TextView helpPage = (TextView) findViewById(R.id.viewHelpContent);
   // String solutionText = "Select method for calculating the solution. This will be the units the final solution is " +
     //       "measured by. In the next screen, first select the element and subscript of the first element in the" +
       //     " compound and click add. Repeat until desired compound is formed. Next, you can either solve for the " +
         //   "selected units or for the needed grams of solute. Enter the desired grams or amount of selected unit " +
           // "and select solve for selected unit or solve for mass of solute respectively. Finally, press solve. " +
            //"The solution will be displayed in a pop-up window.";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onButtonClick(View v) {
        switch(v.getId()) {
            case R.id.helpButtonSolutions:
                helpPage.setText("hi");
                break;
            case R.id.helpButtonEqn:
                break;
            default:
                break;
        }
    }
}
