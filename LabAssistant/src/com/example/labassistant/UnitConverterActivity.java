package com.example.labassistant;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UnitConverterActivity extends Activity {
	boolean converttobuttonclick;
	boolean convertfrombuttonclick;
	boolean convertfrom;
	boolean convertto;
	Button convertfrombutton;
	Button converttobutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unitconverter);
		convertfrombutton = (Button)findViewById(R.id.convertfrom);
		converttobutton = (Button)findViewById(R.id.convertto);
		converttobuttonclick = false;
		convertfrombuttonclick = false;
		convertfrom = false;
		convertto = false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
	{
		if (convertfrombuttonclick == true && converttobuttonclick == false)
		{
			// Setting title for ContextMenu
			menu.setHeaderTitle("Convert From?");
			menu.add("Kg");
			menu.add("g");
			menu.add("mg");
			menu.add("tons");
			menu.add("lbs");
			menu.add("oz");
			menu.add("Troy oz");
			menu.add("Stones");
			menu.add("Km");
			menu.add("m");
			menu.add("mm");
			menu.add("Mi");
			menu.add("Yds");
			menu.add("Ft");
			menu.add("in");
			
			menu.add("L");
			menu.add("mL");
			menu.add("Gallons");
			menu.add("Mi");
			menu.add("pints");
			menu.add("cups");
			menu.add("Fl oz");
			menu.add("C");
			menu.add("K");
			menu.add("F");
			convertfrom = true;
		}
		convertfrombuttonclick = false;
		if (converttobuttonclick == true)
		{
			// Setting title for ContextMenu
			menu.setHeaderTitle("Convert To?");
			String unit = convertfrombutton.getText().toString();
			if (unit.equals("Kg") || unit.equals("g") || unit.equals("mg") || unit.equals("tons") ||
					unit.equals("lbs") || unit.equals("oz") || unit.equals("Troy oz") || unit.equals("Stones")){
				menu.add("Kg");
				menu.add("g");
				menu.add("mg");
				menu.add("tons");
				menu.add("lbs");
				menu.add("oz");
				menu.add("Troy oz");
				menu.add("Stones");
			}
			if (unit.equals("km") || unit.equals("m") || unit.equals("mm") || unit.equals("Mi") || unit.equals("Yds")
					|| unit.equals("Ft") || unit.equals("in") || unit.equals("ly")){
				menu.add("Km");
				menu.add("m");
				menu.add("mm");
				menu.add("Mi");
				menu.add("Yds");
				menu.add("Ft");
				menu.add("in");
				
			}
			if (unit.equals("L") || unit.equals("mL") || unit.equals("Gallons") || unit.equals("pints") 
					|| unit.equals("cups") || unit.equals("Fl oz")){
				menu.add("L");
				menu.add("mL");
				menu.add("Gallons");
				menu.add("pints");
				menu.add("cups");
				menu.add("Fl oz");
			}
			if (unit.equals("C") || unit.equals("K") || unit.equals("F")){
				menu.add("C");
				menu.add("K");
				menu.add("F");
			}
			converttobuttonclick = false;
			convertto = true;
			
		}
 
		
	}
	
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		// Get the notes name
		String unit = item.getTitle().toString();
		
		if (convertfrom == true && convertto == false){
			
			convertfrombutton.setText(unit);
		}
		convertfrom = false;
		
		if (convertto == true && convertfrom == false){
			
			converttobutton.setText(unit);
		}
		convertto = false;
 
        return super.onContextItemSelected(item);
	}

	public void onButtonClick(View v)
	{
		View sender;
		switch(v.getId())
		{
		case R.id.convertfrom:
			convertfrombuttonclick = true;
			sender = findViewById(R.id.convertfrom);
			registerForContextMenu(sender); 
		    openContextMenu(sender);
		    unregisterForContextMenu(sender);
			convertfrombuttonclick = false;
			break;
			
		case R.id.convertto:
			converttobuttonclick = true;
			sender = findViewById(R.id.convertto);
			registerForContextMenu(sender); 
		    openContextMenu(sender);
		    unregisterForContextMenu(sender);
			converttobuttonclick = false;
			break;
			
		case R.id.convertbutton:
			EditText editinput = (EditText) findViewById(R.id.input);
			EditText editoutput = (EditText) findViewById(R.id.output);
			Double input = Double.parseDouble(editinput.getText().toString());
			String unit = convertfrombutton.getText().toString();
			String unitto = converttobutton.getText().toString();
			if (unit.equals("Kg") || unit.equals("g") || unit.equals("mg") || unit.equals("tons") ||
					unit.equals("lbs") || unit.equals("oz") || unit.equals("Troy oz") || unit.equals("Stones")){
				if (unitto.equals("Kg") || unitto.equals("g") || unitto.equals("mg") || unitto.equals("tons") ||
					unitto.equals("lbs") || unitto.equals("oz") || unitto.equals("Troy oz") || unitto.equals("Stones")){
				if (unit.equals("Kg")){
					input = (input*1000);
				}
				if (unit.equals("mg")){
					input = input/1000;
				}
				if (unit.equals("tons")){
					input = input*907184.74;
				}
				if (unit.equals("lbs")){
					input = input*453.59237;
				}
				if (unit.equals("oz")){
					input = input*28.349523;
				}
				if (unit.equals("Troy oz")){
					input = input*31.103477;
				}
				if (unit.equals("Stones")){
					input = input*6350.29318;
				}
				if (unitto.equals("Kg")){
					input = (input/1000);
				}
				if (unitto.equals("mg")){
					input = input*1000;
				}
				if (unitto.equals("tons")){
					input = input/907184.74;
				}
				if (unitto.equals("lbs")){
					input = input/453.59237;
				}
				if (unitto.equals("oz")){
					input = input/28.349523;
				}
				if (unitto.equals("Troy oz")){
					input = input/31.103477;
				}
				if (unitto.equals("Stones")){
					input = input/6350.29318;
				}
			}
				else{
					Toast.makeText(getApplicationContext(), "Units Do Not Match",
							   Toast.LENGTH_LONG).show();
					break;
				}
			}
			if (unit.equals("km") || unit.equals("m") || unit.equals("mm") || unit.equals("Mi") || unit.equals("Yds")
					|| unit.equals("Ft") || unit.equals("in") || unit.equals("ly")){
				if (unitto.equals("km") || unitto.equals("m") || unitto.equals("mm") || unitto.equals("Mi") || unitto.equals("Yds")
						|| unitto.equals("Ft") || unitto.equals("in") || unitto.equals("ly")){
				if (unit.equals("km")){
					input = input*1000;
				}
				if (unit.equals("mm")){
					input = input/1000;
				}
				if (unit.equals("Mi")){
					input = input*1609.344;
				}
				if (unit.equals("Yds")){
					input = input*0.9144;
				}
				if (unit.equals("Ft")){
					input = input*0.3048;
				}
				if (unit.equals("in")){
					input = input*0.0254;
				}
				if (unitto.equals("km")){
					input = input/1000;
				}
				if (unitto.equals("mm")){
					input = input*1000;
				}
				if (unitto.equals("Mi")){
					input = input/1609.344;
				}
				if (unitto.equals("Yds")){
					input = input/0.9144;
				}
				if (unitto.equals("Ft")){
					input = input/0.3048;
				}
				if (unitto.equals("in")){
					input = input/0.0254;
				}
			}
				else{
					Toast.makeText(getApplicationContext(), "Units Do not Match",
							   Toast.LENGTH_LONG).show();
					break;
				}
			}
			if (unit.equals("L") || unit.equals("mL") || unit.equals("Gallons") || unit.equals("pints") 
					|| unit.equals("cups") || unit.equals("Fl oz")){
				if (unitto.equals("L") || unitto.equals("mL") || unitto.equals("Gallons") || unitto.equals("pints") 
						|| unitto.equals("cups") || unitto.equals("Fl oz")){
				if (unit.equals("mL")){
					input = input*1000;
				}
				if (unit.equals("Gallon")){
					input = input*3.785412;
				}
				if (unit.equals("pints")){
					input = input*0.473176;
				}
				if (unit.equals("cups")){
					input = input*0.236588;
				}
				if (unit.equals("Fl oz")){
					input = input*0.029574;
				}
				if (unitto.equals("mL")){
					input = input/1000;
				}
				if (unitto.equals("Gallon")){
					input = input/3.785412;
				}
				if (unitto.equals("pints")){
					input = input/0.473176;
				}
				if (unitto.equals("cups")){
					input = input/0.236588;
				}
				if (unitto.equals("Fl oz")){
					input = input/0.029574;
				}
				}else{
					Toast.makeText(getApplicationContext(), "Units Do Not Match",
							   Toast.LENGTH_LONG).show();
					break;
				}
			}
			if (unit.equals("C") || unit.equals("K") || unit.equals("F")){
				if (unitto.equals("C") || unitto.equals("K") || unitto.equals("F")){
				if (unit.equals("K")){
					input = input - 273;
				}
				if (unit.equals("F")){
					input = ((input-32)*5)/9;
				}
				if (unitto.equals("K")){
					input = input + 273;
				}
				if (unit.equals("F")){
					input = input*(9/5) + 32;
				}
				}else{
					Toast.makeText(getApplicationContext(), "Units Do Not Match",
							   Toast.LENGTH_LONG).show();
					break;
				}
			}
			
			editoutput.setText(input.toString());
			break;


		default:
		}
	}
}