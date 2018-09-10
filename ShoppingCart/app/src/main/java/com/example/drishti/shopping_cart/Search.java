package com.example.drishti.shopping_cart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.drishti.shopping_cart.R;

public class Search extends AppCompatActivity {
    Button button;
    ImageView img;
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        button = findViewById(R.id.searchBtn);
        final Context context=this;
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditText textmanufac;
                EditText textmodel;
                EditText textmin;
                EditText textmax;

                Intent myIntent = new Intent(context, MainActivity.class);
                textmanufac =findViewById(R.id.txtmanufacturer);
                textmodel =findViewById(R.id.txtmodel);
                textmin = findViewById(R.id.minPrice);
                textmax = findViewById(R.id.maxPrice);

                String valuemanuf = textmanufac.getText().toString();
                String valuemodel = textmodel.getText().toString();
                String valueminimum = textmin.getText().toString();
                String valuemaximum = textmax.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("valuemanuf", valuemanuf);
                bundle.putString("valuemodel", valuemodel);
                bundle.putString("valueminimum", valueminimum);
                bundle.putString("valuemaximum", valuemaximum);

               myIntent.putExtras(bundle);
               startActivity(myIntent);
            }
        });
    }
}
