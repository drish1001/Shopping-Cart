package com.example.drishti.shopping_cart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drishti.shopping_cart.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ViewClickListener{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }
    TextView model;
    TextView manufacturer;
    TextView price;
    Context context;
    List<PhoneList> lalala ;
    RecyclerView recyclerView;
    RecyclerView.Adapter recycler_view_Adapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView  = findViewById(R.id.my_recycler_view);
        recyclerViewLayoutManager =new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiClient api = retrofit.create(ApiClient.class);
        Bundle getBundle = null;
        getBundle = this.getIntent().getExtras();
        Call<List<PhoneList>> call = api.getPhoneItems();


        if (getBundle!=null){
            String manuf = getBundle.getString("valuemanuf",null);
            String model = getBundle.getString("valuemodel",null);
            String min = getBundle.getString("valueminimum",null);
            String max  = getBundle.getString("valuemaximum",null);

            if ((manuf==null)&&(model==null)&&(min==null)&&(max==null)){
                call = api.getPhoneItems();
            }
            else {
                call = api.getPhoneItems(manuf,model,min,max);
            }
        }
        call.enqueue(new Callback<List<PhoneList>>() {
            @Override
            public void onResponse(Call<List<PhoneList>> call, Response<List<PhoneList>> response) {
                lalala = response.body();
                recycler_view_Adapter = new RecyclerViewAdapter(context,lalala,listener);
                recyclerView.setAdapter(recycler_view_Adapter);
            }
            @Override
            public void onFailure(Call<List<PhoneList>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        context = getApplicationContext();
    }
    ViewClickListener listener=this::onClick;
    @Override
    public void onClick(View view, int pos) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String modelinfo = lalala.get(pos).getModel();

        view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        builder.setView(view);
        builder.setTitle("Buy Product :");


        final EditText user = view.findViewById(R.id.username);
        final EditText qty = view.findViewById(R.id.quantity);


        builder.setPositiveButton("Buy", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {


                Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

                ApiClient api = retrofit.create(ApiClient.class);
                Call<Purchase> call = api.getBuyer(modelinfo, user.getText().toString(), qty.getText().toString());

                call.enqueue(new Callback<Purchase>() {

                    @Override
                    public void onResponse(Call<Purchase> call, Response<Purchase> response) {

                        Toast.makeText(MainActivity.this, "Details Entered. Thanks for buying!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Purchase> call, Throwable t) {
                        Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });

            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancelled Purchase", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.infoOpt){
            Intent intent = new Intent(this,SalesActivity.class);
            startActivity(intent);
        }
        if (id==R.id.searchOpt){
            Intent intent  = new Intent(this, Search.class);
            startActivity(intent);
        }
        return true;
    }
    }