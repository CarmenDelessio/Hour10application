package com.bffmedia.hour10application;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;


public class GridViewActivity extends Activity {
    GridView gridView;
    String[] pies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        Resources resources = getResources();
        pies = resources.getStringArray(R.array.pie_array);
        gridView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, pies));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        pies[position], Toast.LENGTH_SHORT).show();
            }
        });
    }



}
