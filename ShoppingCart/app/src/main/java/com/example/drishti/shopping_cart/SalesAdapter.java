package com.example.drishti.shopping_cart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.drishti.shopping_cart.R;

import java.util.List;

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.ViewHolder>{
    List<Sales> values;
    Context context2;

    public SalesAdapter(Context context, List<Sales> values){
        this.values = values;
        context2 = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView model;
        public TextView username;
        public TextView invoice;
        public TextView quantity;

        public ViewHolder(View v) {
            super(v);
            model = v.findViewById(R.id.model);
            quantity = v.findViewById(R.id.quantity);
            username = v.findViewById(R.id.username);
            invoice = v.findViewById(R.id.invoicenum);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context2).inflate(R.layout.recycler_view_sales,parent,false);
        final ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.invoice.setText("Invoice Number : "+values.get(position).getInvoiceNum());
        holder.model.setText("Model :"+values.get(position).getModel());
        holder.quantity.setText("Quantity : "+values.get(position).getQuantity());
        holder.username.setText("Username : "+values.get(position).getUsername());
    }
    public int getItemCount() {
        return values.size();
    }
}
