package com.bffmedia.hour10application;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DataCollectionActivity extends Activity {
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;
    CheckBox checkbox;
    RadioButton radioButtonPositive;
    RadioButton radioButtonNegative;
    Button buttonShowData;
    TextView textViewResults;
    String[] pies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_collection);
        spinner = (Spinner)findViewById(R.id.spinner);
        Resources resources = getResources();
        pies = resources.getStringArray(R.array.pie_array);
        spinner.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, pies));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        pies[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, pies));


        checkbox = (CheckBox) findViewById(R.id.checkBox);
        radioButtonNegative = (RadioButton) findViewById(R.id.radioButtonNegative);
        radioButtonPositive = (RadioButton) findViewById(R.id.radioButtonPositive);
        textViewResults = (TextView)findViewById(R.id.textViewResults);

        buttonShowData = (Button) findViewById(R.id.buttonShowData);
        buttonShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.getSelectedItem();
                autoCompleteTextView.getText();
                checkbox.isChecked();
                radioButtonNegative.isChecked();
                radioButtonPositive.isChecked();

                StringBuffer results = new StringBuffer();
                results.append("Spinner " + spinner.getSelectedItem());
                results.append("\n");
                results.append("AutoCompleteTextView  " + autoCompleteTextView.getText());
                results.append("\n");
                results.append("CheckBox  " +checkbox.isChecked());
                results.append("\n");
                results.append("RadioButton Yes  " +radioButtonPositive.isChecked());
                results.append("\n");
                results.append("Radio Button No  " +radioButtonNegative.isChecked());
                results.append("\n");

                textViewResults.setText(results.toString());



            }
        });
    }
}
