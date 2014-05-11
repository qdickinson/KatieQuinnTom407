package com.example.labassistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
			// Setting title for ContextMenu
			menu.setHeaderTitle("Calculators");
			menu.add("Scientific");
			menu.add("Mol Weight");
			menu.add("Solutions");
			menu.add("Dilutions");
			menu.add("Unit Converter");
			 
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		// Get the notes name
		String name = item.getTitle().toString();
		
		if (name.equals("Scientific")){
			
			ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();

			final PackageManager pm = getPackageManager();
			List<PackageInfo> packs = pm.getInstalledPackages(0);
			for (PackageInfo pi : packs) {
			if( pi.packageName.toString().toLowerCase().contains("calcul")){
			    HashMap<String, Object> map = new HashMap<String, Object>();
			    map.put("appName", pi.applicationInfo.loadLabel(pm));
			    map.put("packageName", pi.packageName);
			    items.add(map);
			 }
			}

			if(items.size()>=1){
				String packageName = (String) items.get(0).get("packageName");
				Intent i = pm.getLaunchIntentForPackage(packageName);
				if (i != null)
				  startActivity(i);
				}
				else{
				      // Application not found
				   }
			
		}
		if (name.equals("Mol Weight")){
			Intent molIntent = new Intent(MainActivity.this, MolActivity.class);
			startActivity(molIntent);

		}
		if (name.equals("Solutions")){
			Intent solutionsIntent = new Intent(MainActivity.this, SolutionsActivity.class);
			startActivity(solutionsIntent);

		}
		if (name.equals("Dilutions")){
			 Intent dilutionsIntent = new Intent(MainActivity.this, DilutionsActivity.class);
			startActivity(dilutionsIntent);
		}
		if (name.equals("Unit Converter")){
			Intent converterIntent = new Intent(MainActivity.this, UnitConverterActivity.class);
			startActivity(converterIntent);
		}
 
        return super.onContextItemSelected(item);
	}
	
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		
		case R.id.calculatorbutton:
			
			
			View sender = findViewById(R.id.calculatorbutton);
			registerForContextMenu(sender); 
		    openContextMenu(sender);
		    unregisterForContextMenu(sender);
			

			break;
			/* All taken care of in context menu
		case R.id.scientificbutton:

			ArrayList<HashMap<String,Object>> items =new ArrayList<HashMap<String,Object>>();

			final PackageManager pm = getPackageManager();
			List<PackageInfo> packs = pm.getInstalledPackages(0);
			for (PackageInfo pi : packs) {
			if( pi.packageName.toString().toLowerCase().contains("calcul")){
			    HashMap<String, Object> map = new HashMap<String, Object>();
			    map.put("appName", pi.applicationInfo.loadLabel(pm));
			    map.put("packageName", pi.packageName);
			    items.add(map);
			 }
			}

			if(items.size()>=1){
				String packageName = (String) items.get(0).get("packageName");
				Intent i = pm.getLaunchIntentForPackage(packageName);
				if (i != null)
				  startActivity(i);
				}
				else{
				      // Application not found
				   }

			break;

		case R.id.molweightbutton:

			Intent molIntent = new Intent(MainActivity.this, MolActivity.class);
			startActivity(molIntent);

			break;

		case R.id.solutionsbutton:

			Intent solutionsIntent = new Intent(MainActivity.this, SolutionsActivity.class);
			startActivity(solutionsIntent);

			break;

		case R.id.dilutionsbutton:

            Intent dilutionsIntent = new Intent(MainActivity.this, DilutionsActivity.class);
			startActivity(dilutionsIntent);

			break;

		case R.id.unitconverterbutton:

			Intent converterIntent = new Intent(MainActivity.this, UnitConverterActivity.class);
			startActivity(converterIntent);

			break;
			*/

		case R.id.notepadbutton:

			Intent notepadIntent = new Intent(MainActivity.this, NotepadActivity.class);
			startActivity(notepadIntent);

			break;

        case R.id.eqn_balancer:
            Intent balanceIntent = new Intent(MainActivity.this, EqnBalancer.class);
            startActivity(balanceIntent);

            break;

		case R.id.backbutton:

			setContentView(R.layout.activity_main);

			break;

        case R.id.periodicbutton:
              Intent periodicIntent = new Intent(this, PeriodicTableActivity.class);
            startActivity(periodicIntent);

		default:
		}
	}

}
