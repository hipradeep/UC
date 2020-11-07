package com.example.uc297;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import static com.example.uc297.Fragments.HomeFragment.APPLIANCE_REPAIR;
import static com.example.uc297.Fragments.HomeFragment.CLEANING_AND_DUST;
import static com.example.uc297.Fragments.HomeFragment.SALON_AT_HOME;

public class SliderAdapter extends PagerAdapter {
    private List<CategoryModel> sliderModelList1;

    public SliderAdapter(List<CategoryModel> sliderModelList1) {
        this.sliderModelList1 = sliderModelList1;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.slider_image,container,false);
        final CardView bannerContainer=view.findViewById(R.id.banner_container);
        //bannerContainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(sliderModelList.get(position).getBackgroundColor())));
         ImageView banner=view.findViewById(R.id.banner_slide);
        banner.setImageResource(sliderModelList1.get(position).getCategoryImg());

        container.addView(view,0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation scaleAnim = AnimationUtils.loadAnimation(container.getContext(), R.anim.scale_anim);
                bannerContainer.startAnimation(scaleAnim);


            }
        });
        return view;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return sliderModelList1.size();
    }
}
