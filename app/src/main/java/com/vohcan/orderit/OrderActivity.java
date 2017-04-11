package com.vohcan.orderit;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.vohcan.orderit.adapter.DishAdapter;
import com.vohcan.orderit.adapter.DishSelectedAdapter;
import com.vohcan.orderit.fragments.RespondDishSelectedFragment;
import com.vohcan.orderit.model.Dish;
import com.vohcan.orderit.model.Dishes;
import com.vohcan.orderit.model.SelectedDish;
import com.vohcan.orderit.model.Table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerDishSelected;
    private RecyclerView.Adapter selectedAdapter;
    private RecyclerView.LayoutManager selectedLManager;
    public List<SelectedDish> dishSelected;

    public static final String EXTRA_PARAM_ID = "com.vohcan.orderit.extra.ID";
    private static final int OPINION_REQUEST_CODE = 1 ;

    private Table orderDetail;

    private TextView tableNameOrder;
    private  FloatingActionButton fab;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //use toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //obtain table name
        orderDetail = Table.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        tableNameOrder = (TextView) findViewById(R.id.name_table_order);

        chargeOrderTable();

        fab = (FloatingActionButton) findViewById(R.id.add_dish_FAB);
        fab.setOnClickListener(this);

        dishSelected = new LinkedList<>();

        dishSelected.add(new SelectedDish("elvis",12.50, R.drawable.yankee_g, "patatas fritas"));
        dishSelected.add(new SelectedDish("elvis",12.50,R.drawable.yankee_g, "patatas fritas"));


        recyclerDishSelected = (RecyclerView) findViewById(R.id.dish_selected_recycler);


        selectedLManager = new LinearLayoutManager(this);
        recyclerDishSelected.setLayoutManager(selectedLManager);

        selectedAdapter = new DishSelectedAdapter(dishSelected);
        recyclerDishSelected.setAdapter(selectedAdapter);






    }

    private void chargeOrderTable(){



        tableNameOrder.setText(orderDetail.getName());


    }

    @Override
    public void onClick(View v) {

        Snackbar.make(v,"Ir a carta de Platos", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        Intent intent = new Intent(this, DishListActivity.class);
        startActivityForResult(intent, OPINION_REQUEST_CODE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //MenuItem billMenu = menu.add("Cuenta");
        getMenuInflater().inflate(R.menu.menu_bill, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean superReturn = super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.show_bill_item) {
            //double total = 0.0;


            Log.v("toque", "se ha pulsado cuenta");
            AlertDialog.Builder billDialog = new AlertDialog.Builder(this);
            billDialog.setTitle("Factura");
            billDialog.setMessage("La cuenta es "+ getBill() +" €");

            billDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.v("toque", "se ha pulsado ok");
                }
            });
//          billDialog.setNegativeButton(android.R.string.cancel, null);

            billDialog.show();
            return true;
        }
        return superReturn;


    }
    public double getBill(){
        double total = 0.0;
        for (int i = 0; i< dishSelected.size();i++){
            total += dishSelected.get(i).getPriceSelected();
        }
        return total;
    }
}
