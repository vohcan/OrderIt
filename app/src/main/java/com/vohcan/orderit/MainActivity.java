package com.vohcan.orderit;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.vohcan.orderit.adapter.TableAdapter;
import com.vohcan.orderit.model.Table;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private TableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid);
        adapter = new TableAdapter(this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

        //use toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Table item = (Table) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra(OrderActivity.EXTRA_PARAM_ID, item.getId());


            startActivity(intent);


    }
}
