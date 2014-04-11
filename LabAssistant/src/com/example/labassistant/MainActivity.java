package com.example.labassistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.Menu;
import android.view.View;

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
	
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.calculatorbutton:
			
			setContentView(R.layout.view_calculators);
			
			break;
			
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
			
			setContentView(R.layout.view_calculators);
			
			break;
			
		case R.id.unitconverterbutton:
			
			setContentView(R.layout.view_calculators);
			
			break;
		
			
		case R.id.notepadbutton:
 
			Intent notepadIntent = new Intent(MainActivity.this, NotepadActivity.class);
			startActivity(notepadIntent);		
 
			break;
			
		case R.id.backbutton:
			
			setContentView(R.layout.activity_main);
			
			break;
 
		default:
		}
	}

}
