package com.arcsoft.arcfacedemo.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.modalclass.ReviewModalClass;

import java.util.List;


public class RecycleviewAdapter_GuestReview extends RecyclerView.Adapter<RecycleviewAdapter_GuestReview.MyViewHolder> {

    Context context;
    private List<ReviewModalClass> reviewModalClasses;


    public RecycleviewAdapter_GuestReview(Context mainActivityContacts, List<ReviewModalClass> listModalClassList) {
        this.reviewModalClasses = listModalClassList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_guest_review, parent, false);


        return new MyViewHolder(itemView);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ReviewModalClass modalClass = reviewModalClasses.get(position);
        holder.review_name.setText(modalClass.getReview_name());
        holder.review_date.setText(modalClass.getReview_date());
        holder.review_desc.setText(modalClass.getReview_desc());
    }

    @Override
    public int getItemCount() {
        return reviewModalClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView review_name, review_date, review_desc;


        public MyViewHolder(View view) {
            super(view);


            review_name = (TextView) view.findViewById(R.id.review_name);
            review_date = (TextView) view.findViewById(R.id.review_date);
            review_desc = (TextView) view.findViewById(R.id.review_desc);



        }

    }
}
