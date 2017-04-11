package com.vohcan.orderit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vohcan.orderit.adapter.DishAdapter;
import com.vohcan.orderit.adapter.TableAdapter;
import com.vohcan.orderit.model.Dish;
import com.vohcan.orderit.model.Dishes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import android.util.Log;

import static com.vohcan.orderit.model.Table.items;

public class DishListActivity extends AppCompatActivity  {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private static final String JSON_URL = "http://www.mocky.io/v2/587f6021270000eb00f0dcb0";
    private Dish dish;
    public List<Dish> items;
    public List<Dishes> dishes;

//    private OnDishSelectedListener mOnClickSelected = null;


    public DishListActivity() {
    }

//    public interface OnDishSelectedListener {
//        public void onDishSelected(View v, Dish dish)
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_list);

        //use toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         List<Dish> items = new ArrayList<>();

//        mOnClickSelected = new OnDishSelectedListener() {
//            public void onDishSelected(View v, Dish dish) {
//
//                Log.d("Hemos retornado el plat");
//            }
//        };

        AsyncTask<Void, Integer, List<Dish>> DishAsyncTask = new AsyncTask<Void, Integer, List<Dish>>() {

//            public List<Dish> items;
            List<Dish> items = new ArrayList<>();
            ProgressDialog p;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                p= new ProgressDialog(DishListActivity.this);
                p.show();
            }

            @Override
            protected List<Dish> doInBackground(Void... params) {

                URL url = null;
                InputStream input = null;
                try{

                    url = new URL(JSON_URL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    int responseLength = connection.getContentLength();
                    byte data[] = new byte[1024];
                    long currentBytes = 0;
                    int downloadedBytes;
                    input = connection.getInputStream();
                    StringBuilder sb = new StringBuilder();
                    while((downloadedBytes = input.read(data)) != -1){
                        sb.append(new String(data, 0, downloadedBytes));
                    }



                    //convert data from json to code
                    JSONObject jsonRoot = new JSONObject(sb.toString());
                    JSONArray dishes = jsonRoot.getJSONArray("dishes");
                    for (int i = 0; i < dishes.length(); i++) {
                        JSONObject dish = dishes.getJSONObject(i);
                        String name_item = dish.getString("name");
                        double price_item = dish.getDouble("price");
                        String description_item = dish.getString("description");
                        String image = dish.getString("image");
                        String allergen1 = dish.getString("allergen1");
                        String allergen2 = dish.getString("allergen2");
                        String allergen3 = dish.getString("allergen3");
                        //convert image and allergen to drawable
                        //            int imageInt = Integer.parseInt(image);
                        //            int allergen1Int = Integer.parseInt(allergen1);
                        //            int allergen2Int = Integer.parseInt(allergen2);
                        //            int allergen3Int = Integer.parseInt(allergen3);
                        int image_convert = 0;
                        if(image.equals("R.drawable.chipotle_g")){
                            image_convert = R.drawable.chipotle_g;
                        }
                        else if(image.equals("R.drawable.m30_g")){
                            image_convert = R.drawable.m30_g;
                        }
                        else if(image.equals("R.drawable.yankee_g")){
                            image_convert = R.drawable.yankee_g;
                        }
                        else if(image.equals("R.drawable.puchi_g")){
                            image_convert = R.drawable.puchi_g;
                        }
                        int allergen_1convert = 0;
                        if(allergen1.equals("R.drawable.frutos32")){
                            allergen_1convert = R.drawable.frutos32;
                        }
                        else if(allergen1.equals("R.drawable.cacahuete32")){
                            allergen_1convert = R.drawable.cacahuete32;
                        }
                        else if(allergen1.equals("R.drawable.mostaza32")){
                            allergen_1convert = R.drawable.mostaza32;
                        }
                        else if(allergen1.equals("R.drawable.gluten32")){
                            allergen_1convert = R.drawable.gluten32;
                        }
                        else if(allergen1.equals("R.drawable.sesamo32")){
                            allergen_1convert = R.drawable.sesamo32;
                        }
                        else if(allergen1.equals("R.drawable.lacteos32")){
                            allergen_1convert = R.drawable.lacteos32;
                        }
                        else if(allergen1.equals("R.drawable.frutos32")){
                            allergen_1convert = R.drawable.frutos32;
                        }
                        else if(allergen1.equals("R.drawable.huevo32")){
                            allergen_1convert = R.drawable.huevo32;
                        }
                        int allergen_2convert = 0;
                        if(allergen2.equals("R.drawable.frutos32")){
                            allergen_2convert = R.drawable.frutos32;
                        }
                        else if(allergen2.equals("R.drawable.cacahuete32")){
                            allergen_2convert = R.drawable.cacahuete32;
                        }
                        else if(allergen2.equals("R.drawable.mostaza32")){
                            allergen_2convert = R.drawable.mostaza32;
                        }
                        else if(allergen2.equals("R.drawable.gluten32")){
                            allergen_2convert = R.drawable.gluten32;
                        }
                        else if(allergen2.equals("R.drawable.sesamo32")){
                            allergen_2convert = R.drawable.sesamo32;
                        }
                        else if(allergen2.equals("R.drawable.lacteos32")){
                            allergen_2convert = R.drawable.lacteos32;
                        }
                        else if(allergen2.equals("R.drawable.frutos32")){
                            allergen_2convert = R.drawable.frutos32;
                        }
                        else if(allergen2.equals("R.drawable.huevo32")){
                            allergen_2convert = R.drawable.huevo32;
                        }
                        int allergen_3convert = 0;
                        if(allergen3.equals("R.drawable.frutos32")){
                            allergen_3convert = R.drawable.frutos32;
                        }
                        else if(allergen3.equals("R.drawable.cacahuete32")){
                            allergen_3convert = R.drawable.cacahuete32;
                        }
                        else if(allergen3.equals("R.drawable.mostaza32")){
                            allergen_3convert = R.drawable.mostaza32;
                        }
                        else if(allergen3.equals("R.drawable.gluten32")){
                            allergen_3convert = R.drawable.gluten32;
                        }
                        else if(allergen3.equals("R.drawable.sesamo32")){
                            allergen_3convert = R.drawable.sesamo32;
                        }
                        else if(allergen3.equals("R.drawable.lacteos32")){
                            allergen_3convert = R.drawable.lacteos32;
                        }
                        else if(allergen3.equals("R.drawable.frutos32")){
                            allergen_3convert = R.drawable.frutos32;
                        }
                        else if(allergen3.equals("R.drawable.huevo32")){
                            allergen_3convert = R.drawable.huevo32;
                        }
//                    //create dishObject

                        // Simulate timeout
                        Thread.sleep(1000);

                        items.add (new Dish(name_item, description_item, price_item, image_convert, allergen_1convert, allergen_2convert, allergen_3convert));
                    }
                    return items;




                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(List<Dish> dishes) {

                //super.onPostExecute(dishes);

               items = dishes;
                Dishes.setDishes(dishes);

                adapter = new DishAdapter(Dishes.getDishes());
                recycler.setAdapter(adapter);
                p.dismiss();


            }
        };







//        items.add(new Dish("Elvis","Platano dorado, bacon y crema de cacahuete. Inspirada en el sandwich preferido de Elvis", 12.50 , R.drawable.yankee_g,R.drawable.frutos32, R.drawable.cacahuete32,R.drawable.cacahuete32));
//        items.add(new Dish("Puchi","Queso Americano, Bacon, Salsa Barbacoa y Champiñones en su Salsa. Nuestra versión de Bacon - Cheeseburger",10.10, R.drawable.chipotle_g,R.drawable.cacahuete32, R.drawable.cacahuete32,R.drawable.cacahuete32));
//        items.add(new Dish("Kevin Bacon","Picamos la Carne de la Hamburguesa en la Plancha y la Rellenamos con Trozos de Bacon, Cebolla Crunchy y Queso Americano",11.50, R.drawable.m30_g,R.drawable.cacahuete32, R.drawable.cacahuete32,R.drawable.cacahuete32));




        recycler = (RecyclerView) findViewById(R.id.recycler);
        //recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);


        if (Dishes.getDishes() == null){
            DishAsyncTask.execute();
        }
        else{
            //dar a adapter los platos descargados
            adapter = new DishAdapter(Dishes.getDishes());
            recycler.setAdapter(adapter);

        }







    }


    //create alert dialog when select a dish
    public AlertDialog createRadioListDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final CharSequence[] complements = new CharSequence[3];

        complements[0] = "Patatas Fritas";
        complements[1] = "Patata Asada";
        complements[2] = "Ensalada de col";

        builder.setTitle("Elige el complemento")
                .setSingleChoiceItems(complements, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                DishListActivity.this,
                                "Seleccionaste: " + complements[which],
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        return builder.create();
    }

/*public interface OnDishClickListener{
    public void onDishClick(int position, Dish dish);

}*/

}
