package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HelpPagesActivity extends Activity {

    private TextView helpPage;
    String solutionText = "Select method for calculating the solution. This will be the units the final solution is " +
           "measured by. In the next screen, first select the element and subscript of the first element in the" +
           " compound and click add. Repeat until desired compound is formed. Next, you can either solve for the " +
           "selected units or for the needed grams of solute. Enter the desired grams or amount of selected unit " +
           "and select solve for selected unit or solve for mass of solute respectively. Finally, press solve. " +
           "The solution will be displayed in a pop-up window.  \n  \n  \n \n \n";

    String eqnText = "1. Entering a compound:\n" +
            "\n" +
            "Select the first element of the compound and enter its subscript. Select the \"Add\" button to add it to " +
            "the compound. A compound preview will be displayed. Continue to add any additional elements to the compound" +
            " in this manner.\n" +
            "\n" +
            "2. Making the equation\n" +
            "\n" +
            "When the compound is complete, it may be added to the equation. If the compound is a reactant, select " +
            "the \"Add Left\" button to add it as a reactant, and likewise, if it is a product select \"Add Right\" to " +
            "add the compound as a product. The equation will be displayed below as it is constructed.\n" +
            "\n" +
            "3. Solving the equation\n" +
            "\n" +
            "When the chemical equation is complete, select the \"Balance\" button. The equation should now display the " +
            "correct balanced form.  \n  \n  \n \n \n";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        helpPage = (TextView) findViewById(R.id.viewHelpContent);
    }

    public void onButtonClick(View v) {
        switch(v.getId()) {
            case R.id.helpButtonSolutions:
                helpPage.setText(solutionText);
                break;
            case R.id.helpButtonEqn:
                helpPage.setText(eqnText);
                break;
            default:
                break;
        }
    }
}
