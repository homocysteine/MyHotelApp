package com.arcsoft.arcfacedemo.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.activity.ProcessPaymentActivity;
import com.arcsoft.arcfacedemo.adapter.RecycleviewAdapter_Amenities;
import com.arcsoft.arcfacedemo.adapter.RecycleviewAdapter_GuestReview;
import com.arcsoft.arcfacedemo.modalclass.AmenitiesModalClass;
import com.arcsoft.arcfacedemo.modalclass.ReviewModalClass;

import java.util.ArrayList;



public class HotelDetailActivity extends AppCompatActivity {


    RecyclerView amities_recycleview,review_recycleview;

    RecycleviewAdapter_Amenities adapter_amenities;
    RecycleviewAdapter_GuestReview adapter_guestReview;

    private ArrayList<ReviewModalClass> reviewModalClassArrayList;

    ViewPager viewPager;
    ImageView left_nav,rightNav;
    private int[] layouts1;
    MyViewPagerAdapter myViewPagerAdapter;
    TextView booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);



        amities_recycleview = (RecyclerView)findViewById(R.id.amities_recycleview);
        review_recycleview = (RecyclerView)findViewById(R.id.review_recycleview);

        viewPager = (ViewPager) findViewById(R.id.viewpager);


        left_nav = (ImageView) findViewById(R.id.left_nav);
        rightNav = (ImageView)findViewById(R.id.right_nav);

        booking = (TextView)findViewById(R.id.txtbook);
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HotelDetailActivity.this, ProcessPaymentActivity.class));
            }
        });

// Images left navigation
        left_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                if (tab > 0) {
                    tab--;
                    viewPager.setCurrentItem(tab);
                } else if (tab == 0) {
                    viewPager.setCurrentItem(tab);
                }
            }
        });

        // Images right navigatin
        rightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tab = viewPager.getCurrentItem();
                tab++;
                viewPager.setCurrentItem(tab);
            }
        });


        ArrayList<AmenitiesModalClass> list= new ArrayList();
        list.add(new AmenitiesModalClass(R.drawable.wifi,"Wifi"));
        list.add(new AmenitiesModalClass(R.drawable.breakfast,"早餐"));
        list.add(new AmenitiesModalClass(R.drawable.spa,"Spa"));
        list.add(new AmenitiesModalClass(R.drawable.laundry,"洗衣房"));
        list.add(new AmenitiesModalClass(R.drawable.gym,"健身房"));


        adapter_amenities = new RecycleviewAdapter_Amenities(HotelDetailActivity.this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false);
        amities_recycleview.setLayoutManager(linearLayoutManager);
        amities_recycleview.setItemAnimator(new DefaultItemAnimator());
        amities_recycleview.setAdapter(adapter_amenities);



        // Guest Review - Add the data into arraylist

        ArrayList<ReviewModalClass> list1= new ArrayList();

        list1.add(new ReviewModalClass("Aaryan Rathod","22 Oct","Every amenitie at a pocket friendly\n" +
                "price. The best part of it is very\n" +
                "cooperatice staff ."));

        list1.add(new ReviewModalClass("Priya Panchal","20 Oct","Good ambience and peaceful\n" +
                "and economic hotel to stay."));

        list1.add(new ReviewModalClass("Aaryan Rathod","22 Oct","Every amenitie at a pocket friendly\n" +
                "price. The best part of it is very\n" +
                "cooperatice staff ."));

        list1.add(new ReviewModalClass("Priya Panchal","20 Oct","Good ambience and peaceful\n" +
                "and economic hotel to stay."));
        list1.add(new ReviewModalClass("Aaryan Rathod","22 Oct","Every amenitie at a pocket friendly\n" +
                "price. The best part of it is very\n" +
                "cooperatice staff ."));

        list1.add(new ReviewModalClass("Priya Panchal","20 Oct","Good ambience and peaceful\n" +
                "and economic hotel to stay."));



        //Guest Review - Set the adaoter
        adapter_guestReview = new RecycleviewAdapter_GuestReview(HotelDetailActivity.this,list1);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false);
        review_recycleview.setLayoutManager(linearLayoutManager1);
        review_recycleview.setItemAnimator(new DefaultItemAnimator());
        review_recycleview.setAdapter(adapter_guestReview);



        layouts1 = new int[]{

                R.layout.activity_hotel_detail_image,
                R.layout.activity_hotel_detail_image,
                R.layout.activity_hotel_detail_image,
                R.layout.activity_hotel_detail_image

        };

       // addBottomDots(0);
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private class MyViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts1[position], container, false);
            container.addView(view);

            return view;
        }


        @Override
        public int getCount() {
            return layouts1.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
