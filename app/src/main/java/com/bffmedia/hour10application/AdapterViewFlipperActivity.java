package com.bffmedia.hour10application;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class AdapterViewFlipperActivity extends Activity {
    AdapterViewFlipper adapterViewFlipper;
    String[] pies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_view_flipper);
        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFlipper);
        Resources resources = getResources();
        pies = resources.getStringArray(R.array.pie_array);
        adapterViewFlipper.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, pies));
        adapterViewFlipper.setAutoStart(true);
        adapterViewFlipper.setFlipInterval(2000);

    }
}
