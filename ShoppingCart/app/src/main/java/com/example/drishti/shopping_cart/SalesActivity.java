package com.example.drishti.shopping_cart;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drishti.shopping_cart.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SalesActivity extends AppCompatActivity {

    TextView model;
    TextView quantity;
    TextView username;
    Context contextnew;

    RecyclerView recyclerView;
    RecyclerView.Adapter srecycler_view_Adapter;
    RecyclerView.LayoutManager srecyclerViewLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        recyclerView  = findViewById(R.id.recycler_view_Sales);
        srecyclerViewLayoutManager =new GridLayoutManager(contextnew, 1);
        recyclerView.setLayoutManager(srecyclerViewLayoutManager);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        ApiClient api = retrofit.create(ApiClient.class);

        Call<List<Sales>> call = api.getSales();
        call.enqueue(new Callback<List<Sales>>() {
            @Override
            public void onResponse(Call<List<Sales>> call, Response<List<Sales>> response) {
                List<Sales> salesList= response.body();
                Toast.makeText(contextnew,"Bingo, here you go!", Toast.LENGTH_SHORT).show();
                srecycler_view_Adapter = new SalesAdapter(contextnew,salesList);
                recyclerView.setAdapter(srecycler_view_Adapter);
            }
            @Override
            public void onFailure(Call<List<Sales>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        contextnew = getApplicationContext();}
}
