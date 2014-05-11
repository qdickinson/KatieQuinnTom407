package com.example.labassistant;

import java.util.ArrayList;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;

public class NotepadActivity extends Activity {
	public static final String PREFS = "com.example.LabAssistant.notes";
	MultiAutoCompleteTextView textView;
	boolean newclick = false;
	boolean openclick = false;
	boolean deleteclick = false;
	boolean overwrite = false;
	String tempstring;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notepad);
		textView = (MultiAutoCompleteTextView) findViewById(R.id.notepadtextbox);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
	{
		// Get all the notes names.
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		Map<String, ?> prefs = preferences.getAll(); // Question mark stands for a separate representative
 
		if(prefs.isEmpty())
		{
			Toast.makeText(this, "Sorry, no notes saved!", Toast.LENGTH_SHORT).show();
			return;
		}
 
		// Setting title for ContextMenu
		menu.setHeaderTitle("Saved Notes");
 
		// Iterating through all the items in SharedPreferences
		for(Map.Entry<String, ?> entry : prefs.entrySet()) 
		{
			// Extracting the key, which is actually a drawing name.
		    String key = entry.getKey().toString();
 
		    // Add them to menus.
		    menu.add(key);
		}
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		
		if (openclick == true){
			tempstring = item.getTitle().toString();
			EditText notetext = (EditText)findViewById(R.id.notetext);
			if (!notetext.getText().toString().equals("")){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
			    .setNegativeButton("No", dialogClickListener).show();
			}else{
				EditText noteName = (EditText)findViewById(R.id.notename);
    			noteName.setText(tempstring, TextView.BufferType.EDITABLE);
     
    			openExistingNote(tempstring);
    			
    			tempstring = "";
    			openclick = false;
			}
		}
		if (deleteclick == true){
			tempstring = item.getTitle().toString();
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
			    .setNegativeButton("No", dialogClickListener).show();
		}
		
 
        return super.onContextItemSelected(item);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		View openExistingButtonView = findViewById(R.id.openbutton);
		registerForContextMenu(openExistingButtonView);	
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/**
	 * Method to open an existing drawing board.
	 * 
	 * @param noteName	Drawing Title given by user earlier
	 */
	public void openExistingNote(String noteName)
	{
		String text = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString(noteName, "No notes found");
		
		EditText editText = (EditText)findViewById(R.id.notetext);
		editText.setText(text, TextView.BufferType.EDITABLE);
		}
	SharedPreferences preferences;
	
	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
	    @Override
	    public void onClick(DialogInterface dialog, int which) {
	        switch (which){
	        case DialogInterface.BUTTON_POSITIVE:
	        	if (openclick == true){
	        		// Get the notes name
	        			EditText noteName = (EditText)findViewById(R.id.notename);
	        			noteName.setText(tempstring, TextView.BufferType.EDITABLE);
	         
	        			openExistingNote(tempstring);
	        			
	        			tempstring = "";
	        			openclick = false;
	        		
	        	}
	        	if (newclick == true){
	        		EditText textField = (EditText)findViewById(R.id.notetext);
	        		EditText notename = (EditText)findViewById(R.id.notename);
	        		textField.setText("", TextView.BufferType.EDITABLE);
	        		notename.setText("", TextView.BufferType.EDITABLE);
	        		newclick = false;
	        	}
	        	if (overwrite == true){
	        		saveNote();
	        	}
	        	if (deleteclick == true){
	        		
	        		// Get all the notes names.
	    			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	    			Map<String, ?> prefs = preferences.getAll(); // Question mark stands for a separate representative
	    			// Iterating through all the items in SharedPreferences
	    			for(Map.Entry<String, ?> entry : prefs.entrySet()) 
	    			{
	    				// Extracting the key, which is actually a drawing name.
	    			    String key = entry.getKey().toString();
	    			    
	    			    	if (key.equals(tempstring)){
	    			    		deleteNote(key);
	    			    	
	    			    	}
	    			    
	    			}
	        		
	        	}
	        	deleteclick = false;
	            
	            break;

	        case DialogInterface.BUTTON_NEGATIVE:
	            //No button clicked
	            break;
	        }
	    }
	};
	
	public void onButtonClick(View v)
	{
		switch(v.getId())
		{
		case R.id.openbutton:
			openclick = true;
			openContextMenu(findViewById(R.id.openbutton));
			
			break;
 
		case R.id.newbutton:
			newclick = true;
			EditText notetext = (EditText)findViewById(R.id.notetext);
			if (!notetext.getText().toString().equals("")){
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
			    .setNegativeButton("No", dialogClickListener).show();
			}else{
				EditText textField = (EditText)findViewById(R.id.notetext);
        		EditText notename = (EditText)findViewById(R.id.notename);
        		textField.setText("", TextView.BufferType.EDITABLE);
        		notename.setText("", TextView.BufferType.EDITABLE);
        		newclick = false;
			}
			
			break;
			
		case R.id.savebutton:
			// Get all the notes names.
			SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			Map<String, ?> prefs = preferences.getAll(); // Question mark stands for a separate representative
			// Iterating through all the items in SharedPreferences
			for(Map.Entry<String, ?> entry : prefs.entrySet()) 
			{
				// Extracting the key, which is actually a drawing name.
			    String key = entry.getKey().toString();
			    EditText notename = (EditText)findViewById(R.id.notename);
			    	if (key.equals(notename.getText().toString())){
			    		overwrite = true;
			    		
			    	}
			    
			}
			if (overwrite == true){
				Builder builder = new AlertDialog.Builder(this);
				builder.setMessage("Do you want to overwrite?").setPositiveButton("Yes", dialogClickListener)
				    .setNegativeButton("No", dialogClickListener).show();
				
			}else{
				saveNote();
				overwrite = false;
			}
				
			break;
			
		case R.id.deletebutton:
			deleteclick = true;
			openContextMenu(findViewById(R.id.openbutton));
			
			break;
 
		default:
		}
		
	}
	
	public void saveNote(){
	    Activity parentActivity = NotepadActivity.this;
	     
		// Get drawing title from the EditText
		String NoteName =  ((EditText)parentActivity.findViewById(R.id.notename)).getText().toString();
 
		// Prompt user to give a drawing name if he/she has not already entered
		if(NoteName == null || NoteName.equals(""))
		{
			Toast.makeText(parentActivity, "Please enter a name for your note", Toast.LENGTH_SHORT).show();
			return;
		}
 
		if(((EditText)parentActivity.findViewById(R.id.notetext)).getText().toString().equals(""))
		{
			Toast.makeText(parentActivity, "No Note found!", Toast.LENGTH_SHORT).show();
			return;
		}

		// Store the generated string and commit the changes.
		PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().putString(NoteName, ((EditText)parentActivity.findViewById(R.id.notetext)).getText().toString()).commit(); 
 
		Toast.makeText(parentActivity, "'" + NoteName + "' saved successfully.", Toast.LENGTH_SHORT).show();
		overwrite = false;
	}
	public void deleteNote(String deleted){
		Activity parentActivity = NotepadActivity.this;
		PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit().remove(deleted).commit(); 
		deleteclick = false;
	}
	
	

 
	}


