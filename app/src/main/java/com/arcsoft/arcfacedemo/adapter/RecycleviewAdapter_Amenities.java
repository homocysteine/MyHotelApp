package com.arcsoft.arcfacedemo.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.modalclass.AmenitiesModalClass;

import java.util.List;



public class RecycleviewAdapter_Amenities extends RecyclerView.Adapter<RecycleviewAdapter_Amenities.MyViewHolder> {

    Context context;
    private List<AmenitiesModalClass> amenitiesModalClasses;


    public RecycleviewAdapter_Amenities(Context mainActivityContacts, List<AmenitiesModalClass> listModalClassList) {
        this.amenitiesModalClasses = listModalClassList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_amenities, parent, false);


        return new MyViewHolder(itemView);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        AmenitiesModalClass modalClass = amenitiesModalClasses.get(position);
        holder.img.setImageResource(modalClass.getImage());
        holder.name.setText(modalClass.getName());
    }

    @Override
    public int getItemCount() {
        return amenitiesModalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView name, date, price;
        ImageView img;


        public MyViewHolder(View view) {
            super(view);


            name = (TextView) view.findViewById(R.id.amities_name);
            img = (ImageView) view.findViewById(R.id.amities_image);


        }

    }
}
