package com.example.intagpc.spinnerdemo;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPlanets;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        populateSpinnerItems();
        spinnerItemsListener();
    }

    public void initWidgets() {

        spinnerPlanets = (Spinner) findViewById(R.id.spinnerPlanets);
    }

    public void populateSpinnerItems() {
        arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.spinnerPlanets, android.R.layout.simple_list_item_1);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPlanets.setAdapter(arrayAdapter);


    }

    public void spinnerItemsListener() {

        spinnerPlanets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String itemPosition = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, itemPosition, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "you have not selected", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
