package com.example.labassistant;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class DilutionsActivity extends Activity{

    private Spinner initialConcentrationSpinner;
    private Spinner finalConcentrationSpinner;
    private Spinner startVolumeSpinner;
    private Spinner finalVolumeSpinner;
    private int chosenInitialConcentration;
    private int chosenFinalConcentration;
    private int chosenStartVolume;
    private int chosenFinalVolume;

    private Double[] conversionFactors = {1.0, 0.001, 0.000001, 0.000000001};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dilutions);

        ArrayAdapter<CharSequence> adapter;

        //Spinner for choosing the initial concentration unit
        initialConcentrationSpinner = (Spinner) findViewById(R.id.concentrationSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.concentration_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initialConcentrationSpinner.setAdapter(adapter);
        initialConcentrationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                chosenInitialConcentration = arg0.getSelectedItemPosition();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                //Nothing was selected
            }
        });

        //Spinner for choosing the final concentration unit
        finalConcentrationSpinner = (Spinner) findViewById(R.id.concentrationSpinner_2);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.concentration_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        finalConcentrationSpinner.setAdapter(adapter);
        finalConcentrationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                chosenFinalConcentration = arg0.getSelectedItemPosition();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                //Nothing was selected
            }
        });

        //Spinner for choosing the initial volume unit
        startVolumeSpinner = (Spinner) findViewById(R.id.startVolumeSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.volume_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startVolumeSpinner.setAdapter(adapter);
        startVolumeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                chosenStartVolume = arg0.getSelectedItemPosition();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                //Nothing was selected
            }
        });

        //Spinner for choosing the final volume unit
        finalVolumeSpinner = (Spinner) findViewById(R.id.finalVolumeSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.volume_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        finalVolumeSpinner.setAdapter(adapter);
        finalVolumeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                chosenFinalVolume = arg0.getSelectedItemPosition();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                //Nothing was selected
            }
        });


    }

    public void onButtonClick(View v){


        switch(v.getId()){

            case R.id.calculateStartVolume:

                String answer = "A required field was left empty.";
                String title = "Starting Volume:";

                try{
                    EditText initialConcentration = (EditText) findViewById(R.id.initialConcentration);
                    EditText finalConcentration = (EditText) findViewById(R.id.finalConcentration);
                    EditText finalVolume = (EditText) findViewById(R.id.finalVolume);

                    Double initConcVal = Double.parseDouble(initialConcentration.getText().toString());
                    Double finalConcVal = Double.parseDouble(finalConcentration.getText().toString());
                    Double finalVolVal = Double.parseDouble(finalVolume.getText().toString());

                    //Puts all inputs into standard Molar unit for calculation
                    initConcVal *= conversionFactors[chosenInitialConcentration];
                    finalConcVal *= conversionFactors[chosenFinalConcentration];
                    finalVolVal *= conversionFactors[chosenFinalVolume];

                    Double startVolume = ((finalConcVal * finalVolVal) / initConcVal);

                    startVolume /= conversionFactors[chosenStartVolume];

                    answer = String.valueOf(startVolume);

                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                            R.array.volume_array, android.R.layout.simple_spinner_item);
                    String volumeUnit = (String) adapter.getItem(chosenStartVolume);

                    answer += " " + volumeUnit;
                }
                catch(IllegalStateException e){
                    title = "Erorr:";
                }
                catch(NumberFormatException e){
                    title = "Erorr:";
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(answer).setTitle(title);
                builder.setPositiveButton("Done", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder.create();
                builder.show();

                break;

            default:
                break;
        }


    }


}



