package com.arcsoft.arcfacedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.activity.MainActivity;
import com.arcsoft.arcfacedemo.modalclass.HotelModalClass;
import com.arcsoft.arcfacedemo.page.HomePageActivity;
import com.arcsoft.arcfacedemo.page.HotelDetailActivity;

import java.util.List;


public class RecycleAdapter_Hotel extends RecyclerView.Adapter<RecycleAdapter_Hotel.MyViewHolder> {
    Context context;

    private List<HotelModalClass> modalClasses;


    public RecycleAdapter_Hotel(HomePageActivity homePageActivity, List<HotelModalClass> modalClassList) {
        this.modalClasses = modalClassList;
        this.context = homePageActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hotel, parent, false);


        return new MyViewHolder(itemView);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        HotelModalClass modalClass = modalClasses.get(position);
        holder.name.setText(modalClass.getHotel_name());
        holder.roompic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecycleAdapter_Hotel.this.context.startActivity(new Intent(RecycleAdapter_Hotel.this.context, HotelDetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return modalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView strikeText;
        TextView name;
        ImageView roompic;


        public MyViewHolder(View view) {
            super(view);


            roompic = (ImageView)view.findViewById(R.id.roompic);
            strikeText = (TextView)view.findViewById(R.id.strikeText);
            name = (TextView) view.findViewById(R.id.hotel_name);

        }

    }


}



