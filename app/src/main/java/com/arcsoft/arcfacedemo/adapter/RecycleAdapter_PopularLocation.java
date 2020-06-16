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
import android.widget.Toast;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.activity.MainActivity;
import com.arcsoft.arcfacedemo.modalclass.LocationModalClass;
import com.arcsoft.arcfacedemo.page.HomePageActivity;

import java.util.List;


public class RecycleAdapter_PopularLocation extends RecyclerView.Adapter<RecycleAdapter_PopularLocation.MyViewHolder> {
    Context context;

    private List<LocationModalClass> modalClasses;




    public RecycleAdapter_PopularLocation(HomePageActivity homePageActivity, List<LocationModalClass> modalClassList) {
        this.modalClasses = modalClassList;
        this.context = homePageActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_popular_location, parent, false);



        return new MyViewHolder(itemView);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        LocationModalClass modalClass = modalClasses.get(position);
        holder.image.setImageResource(modalClass.getImage());
        holder.name.setText(modalClass.getName());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecycleAdapter_PopularLocation.this.context.startActivity(new Intent(RecycleAdapter_PopularLocation.this.context, MainActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return modalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView name;


        public MyViewHolder(View view) {
            super(view);


            image = (ImageView) view.findViewById(R.id.homeimage);
            name = (TextView) view.findViewById(R.id.textname);

        }

    }






}



