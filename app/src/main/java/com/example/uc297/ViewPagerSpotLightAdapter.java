package com.example.uc297;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.uc297.CategoryModel;
import com.example.uc297.R;
import java.util.List;

public class ViewPagerSpotLightAdapter extends PagerAdapter {

    private List<CategoryModel> categoryModelList;

    public ViewPagerSpotLightAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @Override
    public int getCount() {
        return categoryModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
         return view==object;
    }



    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.viewpager_spotlight_item,container,false);
        ImageView banner=view.findViewById(R.id.ivSpotlight);
        final LinearLayout banner_container=view.findViewById(R.id.banner_container);
        TextView serviceTitle=view.findViewById(R.id.service_title);
        TextView serviceFeatureOffer=view.findViewById(R.id.service_feature_offer);
        banner.setImageResource(categoryModelList.get(position).getCategoryImg());
        serviceTitle.setText(categoryModelList.get(position).getCategoryTitle());
        serviceFeatureOffer.setText(categoryModelList.get(position).getFeatureOffers());

        container.addView(view,0);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Animation scaleAnim = AnimationUtils.loadAnimation(container.getContext(), R.anim.scale_anim);
                banner_container.startAnimation(scaleAnim);


            }
        });
        return view;
       // return null;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
