package com.example.drishti.shopping_cart;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.drishti.shopping_cart.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<PhoneList> values;
    Context context1;

    ViewClickListener speaker;
    public RecyclerViewAdapter(Context context2, List<PhoneList> values2, ViewClickListener speaker) {
        this.speaker = speaker;
        this.values = values2;
        context1 = context2;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView model;
        public TextView manufac;
        public TextView prc;
        public ImageView imageView;
        public CardView linearLayout;

        public ViewHolder(View v) {
            super(v);
            linearLayout = v.findViewById(R.id.cardview1);
            model = v.findViewById(R.id.model);
            manufac = v.findViewById(R.id.manufacturer);
            prc = v.findViewById(R.id.price);
        }
        public ImageView getImageView() {
            imageView = itemView.findViewById(R.id.img);
            return imageView;
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context1).inflate(R.layout.recycler_view_items, parent, false);
        final ViewHolder viewHolder1 = new ViewHolder(view1);
        return viewHolder1;
    }
    public int getItemCount () {
        return values.size();
    }
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String model = values.get(position).getModel();
        holder.model.setText(model);
        holder.manufac.setText(values.get(position).getManufacturer());
        String priceee = "Only Rs." + values.get(position).getPrice().toString();
        holder.prc.setText(priceee);
        Glide.with(context1).load(Uri.parse(values.get(position).getImage())).into(holder.getImageView());

        holder.getImageView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v) {
                speaker.onClick(v,position);
            }

        });
    }
}