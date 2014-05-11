package com.example.labassistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);


        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // do nothing
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                //do nothing
            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                //do nothing

            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                String optionSelected = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if (optionSelected.equals("Basic Calculator")) {
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
                else if (optionSelected.equals("Molar Weight")) {
                    Intent molIntent = new Intent(MainActivity.this, MolActivity.class);
                    startActivity(molIntent);
                }
                else if (optionSelected.equals("Solutions")) {
                    Intent solutionsIntent = new Intent(MainActivity.this, SolutionsActivity.class);
                    startActivity(solutionsIntent);
                }
                else if (optionSelected.equals("Dilutions")) {
                    Intent dilutionsIntent = new Intent(MainActivity.this, DilutionsActivity.class);
                    startActivity(dilutionsIntent);
                }
                else if (optionSelected.equals("Unit Converter")) {
                    Intent unitIntent = new Intent(MainActivity.this, UnitConverterActivity.class);
                    startActivity(unitIntent);
                }
                else if (optionSelected.equals("Notepad")) {
                    Intent notepadIntent = new Intent(MainActivity.this, NotepadActivity.class);
                    startActivity(notepadIntent);
                }
                else if (optionSelected.equals("Periodic Table")) {
                    Intent periodicIntent = new Intent(MainActivity.this, PeriodicTableActivity.class);
                    startActivity(periodicIntent);
                }
                else if (optionSelected.equals("Chemical Equation Balancer")) {
                    Intent eqnIntent = new Intent(MainActivity.this, EqnBalancer.class);
                    startActivity(eqnIntent);
                }
                else if (optionSelected.equals("About This App")) {
                    Intent aboutIntent = new Intent(MainActivity.this, AboutAppActivity.class);
                    startActivity(aboutIntent);
                }
                return false;
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        listDataHeader.add("Calculators");
        listDataHeader.add("Experiments");
        listDataHeader.add("Chemistry Applications");
        listDataHeader.add("Using Lab Assistant");

        List<String> calculators = new ArrayList<String>();
        calculators.add("Basic Calculator");
        calculators.add("Molar Weight");
        calculators.add("Solutions");
        calculators.add("Dilutions");
        calculators.add("Unit Converter");;

        List<String> experiments = new ArrayList<String>();
        experiments.add("Notepad");

        List<String> applications = new ArrayList<String>();
        applications.add("Periodic Table");
        applications.add("Chemical Equation Balancer");

        List<String> about = new ArrayList<String>();
        about.add("About This App");
        about.add("Help Pages");

        listDataChild.put(listDataHeader.get(0), calculators);
        listDataChild.put(listDataHeader.get(1), experiments);
        listDataChild.put(listDataHeader.get(2), applications);
        listDataChild.put(listDataHeader.get(3), about);
    }
}