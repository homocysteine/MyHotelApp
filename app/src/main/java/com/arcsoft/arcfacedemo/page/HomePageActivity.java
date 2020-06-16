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
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.activity.MainActivity;
import com.arcsoft.arcfacedemo.adapter.RecycleAdapter_Hotel;
import com.arcsoft.arcfacedemo.adapter.RecycleAdapter_PopularLocation;
import com.arcsoft.arcfacedemo.modalclass.HotelModalClass;
import com.arcsoft.arcfacedemo.modalclass.LocationModalClass;

import java.util.ArrayList;



public class HomePageActivity extends AppCompatActivity {

    EditText edtsearch;

    ViewPager viewPager;
    private int[] layouts1;

    MyViewPagerAdapter myViewPagerAdapter;
    private TextView[] dots1;

    LinearLayout dotsLayout1;

    RecyclerView popular_location_recycleview,hotel_recyclevview,offer_recycleview;

    RecycleAdapter_PopularLocation adapter_popularLocation;
    RecycleAdapter_Hotel adapter_hotel;

    private ArrayList<LocationModalClass> locationModalClassArrayList;
    private ArrayList<HotelModalClass> hotelModalClassArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        edtsearch = (EditText)findViewById(R.id.edtsearch);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout1 = (LinearLayout) findViewById(R.id.layoutDots1);

        popular_location_recycleview = (RecyclerView)findViewById(R.id.popular_location_recycleview);
        hotel_recyclevview = (RecyclerView)findViewById(R.id.hotel_recyclevview);
        offer_recycleview = (RecyclerView)findViewById(R.id.offer_recycleview);




        layouts1 = new int[]{

                R.layout.item_viewpager1,
                R.layout.item_viewpager1,
                R.layout.item_viewpager1

        };

        addBottomDots(0);
        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


        // popular location - add data in to arraylist

        locationModalClassArrayList  = new ArrayList();
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.servicecenter,"联系客服"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.helpyourself,"自助餐"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.bookingmeal,"订餐"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.banquet,"宴会"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.gym1,"健身"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.vip,"vip服务"));
        locationModalClassArrayList.add(new LocationModalClass(R.drawable.washingclothes,"洗衣服务"));


        //popular location adapter

        adapter_popularLocation = new RecycleAdapter_PopularLocation(HomePageActivity.this,locationModalClassArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false);
        popular_location_recycleview.setLayoutManager(linearLayoutManager);
        popular_location_recycleview.setItemAnimator(new DefaultItemAnimator());
        popular_location_recycleview.setAdapter(adapter_popularLocation);


        //recommended hotel - add data in to arraylist

        hotelModalClassArrayList  = new ArrayList();
        hotelModalClassArrayList.add(new HotelModalClass("单人房"));
        hotelModalClassArrayList.add(new HotelModalClass("标准间"));
        hotelModalClassArrayList.add(new HotelModalClass("大床间"));
        hotelModalClassArrayList.add(new HotelModalClass("双床房"));
        hotelModalClassArrayList.add(new HotelModalClass("普通套间"));
        hotelModalClassArrayList.add(new HotelModalClass("总统套间"));

        //recommended hotel - set adapter
        adapter_hotel = new RecycleAdapter_Hotel(HomePageActivity.this,hotelModalClassArrayList);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false);
        hotel_recyclevview.setLayoutManager(linearLayoutManager1);
        hotel_recyclevview.setItemAnimator(new DefaultItemAnimator());
        hotel_recyclevview.setAdapter(adapter_hotel);

//        ImageView service = (ImageView)findViewById(R.id.homeimage);
//        service.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomePageActivity.this, MainActivity.class));
//            }
//        });

        //Offer of the week - add data in to arraylist

        hotelModalClassArrayList  = new ArrayList();
        hotelModalClassArrayList.add(new HotelModalClass("视觉AI科技主题房"));
        hotelModalClassArrayList.add(new HotelModalClass("情侣度假首选"));
        hotelModalClassArrayList.add(new HotelModalClass("商务人士首选"));
        hotelModalClassArrayList.add(new HotelModalClass("中国风酒店"));
        hotelModalClassArrayList.add(new HotelModalClass("欧洲古典风格酒店"));
        hotelModalClassArrayList.add(new HotelModalClass("毕业旅行首选"));

        //offer of the week - set adapter
        adapter_hotel = new RecycleAdapter_Hotel(HomePageActivity.this,hotelModalClassArrayList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false);
        offer_recycleview.setLayoutManager(linearLayoutManager2);
        offer_recycleview.setItemAnimator(new DefaultItemAnimator());
        offer_recycleview.setAdapter(adapter_hotel);



    }

    //set the viewpager dots
    private void addBottomDots(int currentPage) {
        dots1 = new TextView[layouts1.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout1.removeAllViews();
        for (int i = 0; i < dots1.length; i++) {
            dots1[i] = new TextView(this);
            dots1[i].setText(Html.fromHtml("&#8226;"));
            dots1[i].setTextSize(35);
            dots1[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout1.addView(dots1[i]);
        }

        if (dots1.length > 0)
            dots1[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    //Viewpager Adapter
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
