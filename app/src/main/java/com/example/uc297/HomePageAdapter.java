package com.example.uc297;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {
    private List<HomePageModel> homePageModelsList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelsList) {
        this.homePageModelsList = homePageModelsList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }


    @Override
    public int getItemViewType(int position) {
        switch (homePageModelsList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;
            case 1:
                return HomePageModel.STRIP_AD_BANNER;
            case 2:
                return HomePageModel.AVAILABLE_SERVICE_IN_AREA_VIEW;
            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            case 4:
                return HomePageModel.SPOTLIGHT_SLIDER;
            default:
                return -1;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case HomePageModel.BANNER_SLIDER:
                View bannerSliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliding_ad_layout, parent, false);
                return new BannerSlider(bannerSliderView);
           case HomePageModel.STRIP_AD_BANNER:
                View stripAdBannerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.strip_ad_layout, parent, false);
                return new StripAdBannerViewHolder(stripAdBannerView);

            case HomePageModel.AVAILABLE_SERVICE_IN_AREA_VIEW:
                View availableServiceView = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_available_in_your_area, parent, false);
                return new AvailableServicesInArea(availableServiceView);

            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_grid_layout, parent, false);
                return new GridViewService(gridView);
            case HomePageModel.SPOTLIGHT_SLIDER:
                View spotlightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spotlight_view_pager, parent, false);
                return new SpotlightViewPager(spotlightView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (homePageModelsList.get(position).getType()) {
            case HomePageModel.BANNER_SLIDER:
               boolean isCusView=homePageModelsList.get(position).isCustomerView();
                List<CategoryModel> sliderModelList = homePageModelsList.get(position).getCategoryModelList();
                String titleCusView=homePageModelsList.get(position).getTitle();
                String descCusView=homePageModelsList.get(position).getDescription();
                ((BannerSlider)holder).setBannerSlider(isCusView,titleCusView, descCusView, sliderModelList);
                break;
            case HomePageModel.STRIP_AD_BANNER:
                int resource = homePageModelsList.get(position).getAdStripImg();
                String color = homePageModelsList.get(position).getBgColor();
                ((StripAdBannerViewHolder) holder).setStripAd(resource, color);
                break;

            case HomePageModel.AVAILABLE_SERVICE_IN_AREA_VIEW:
                String title = homePageModelsList.get(position).getTitle();
                List<CategoryModel> cml=homePageModelsList.get(position).getCategoryModelList();
                ((AvailableServicesInArea) holder).setAvailableServicesInArea(title, cml);
                break;

            case HomePageModel.GRID_PRODUCT_VIEW:
                String gridTitle = homePageModelsList.get(position).getTitle();
                List<CategoryModel> gridList=homePageModelsList.get(position).getCategoryModelList();
                String gridDes=homePageModelsList.get(position).getDescription();
                int SERVICE_NO=homePageModelsList.get(position).getSERVICE_NO();
                ((GridViewService) holder).setGridData(SERVICE_NO,gridTitle, gridDes, gridList);
                break;
            case HomePageModel.SPOTLIGHT_SLIDER:
                String spotlightTitle = homePageModelsList.get(position).getTitle();
                String spotlightDescription=homePageModelsList.get(position).getDescription();
                List<CategoryModel> spotlightList=homePageModelsList.get(position).getCategoryModelList();
                int serNo=homePageModelsList.get(position).getSERVICE_NO();
                ((SpotlightViewPager) holder).setSpotlightViewPager(serNo,spotlightTitle, spotlightDescription,spotlightList);
                break;


            default:
        }

    }

    @Override
    public int getItemCount() {
        return homePageModelsList.size();
    }

    public static class BannerSlider extends RecyclerView.ViewHolder {
        private ViewPager bannerSlider;
        private TextView title;
        private TextView description;
        private ConstraintLayout banner_container;

        public BannerSlider(@NonNull View itemView) {
            super(itemView);
            bannerSlider = itemView.findViewById(R.id.bannerSliderViewPager);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            banner_container=itemView.findViewById(R.id.banner_container);

        }

        private void setBannerSlider(boolean isCusView,String titleTxt, String descTxt,  final List<CategoryModel> sliderModelList) {
            if (isCusView){
                title.setVisibility(View.VISIBLE);
                description.setVisibility(View.VISIBLE);
                banner_container.setBackgroundColor(Color.WHITE);
                if (!(titleTxt.equals("null") && descTxt.equals("null"))){
                    title.setText(titleTxt);
                    description.setText(descTxt);
                }

            }else {
                title.setVisibility(View.GONE);
                description.setVisibility(View.GONE);
                banner_container.setBackgroundColor(Color.TRANSPARENT);

            }

            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            bannerSlider.setAdapter(sliderAdapter);
            bannerSlider.setClipToPadding(false);
            bannerSlider.setPageMargin(20);




        }
    }

    public static class StripAdBannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView stripAdImage;
        private CardView stripAdContainer;

        public StripAdBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            stripAdImage = itemView.findViewById(R.id.strip_ad_image);
            stripAdContainer = itemView.findViewById(R.id.strip_container);
        }
        private void setStripAd(int resource, String color) {
            stripAdImage.setImageResource(resource);
            stripAdContainer.setBackgroundColor(Color.parseColor(color));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Animation scaleAnim = AnimationUtils.loadAnimation(itemView.getContext(), R.anim.scale_anim);
                    stripAdContainer.startAnimation(scaleAnim); }
            });
        }
    }

    public static class AvailableServicesInArea extends RecyclerView.ViewHolder{
        private TextView title;
        private RecyclerView serviceAvailableRecyclerView;

        public AvailableServicesInArea(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.areaTitle);
            serviceAvailableRecyclerView=itemView.findViewById(R.id.rvAvailableServicesInArea);
        }
        private void setAvailableServicesInArea(String titleTxt, List<CategoryModel> categoryModelList){

            title.setText(titleTxt);
            serviceAvailableRecyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 4);
            serviceAvailableRecyclerView.setLayoutManager(gridLayoutManager);
            serviceAvailableRecyclerView.setAdapter(new AvailableServicesGridRecyclerAdapter(categoryModelList));


        }
    }

    public static class GridViewService extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private RecyclerView grid_recyclerView;
        private Button viewAll;

        public GridViewService(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            viewAll=itemView.findViewById(R.id.view_all_btn);
            grid_recyclerView=itemView.findViewById(R.id.grid_recycler_view);
        }
        private void setGridData(final int SERVICE_NO, String titleTxt, String descriptionTxt, List<CategoryModel> categoryModel){
            title.setText(titleTxt);
            description.setText(descriptionTxt);


            GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), 2);
            grid_recyclerView.setLayoutManager(gridLayoutManager);
            GridRecyclerAdapter adapter=new GridRecyclerAdapter(categoryModel);
            grid_recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

            viewAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryListActivity.class);
                    categoryIntent.putExtra("serviceNo", SERVICE_NO);
                    itemView.getContext().startActivity(categoryIntent);
                }
            });

        }
    }

    public static class SpotlightViewPager extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private Button btnExperienceSpotlight;
        private ViewPager spotlightViewPager;
        public SpotlightViewPager(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            btnExperienceSpotlight=itemView.findViewById(R.id.btnExperienceSpotlight);
            spotlightViewPager=itemView.findViewById(R.id.vpExperienceSpotlight);
        }
        private void setSpotlightViewPager(final int SERVICE_NO, String  titletxt, String dectxt, List<CategoryModel> categoryModels){
            title.setText(titletxt);
            description.setText(dectxt);
            ViewPagerSpotLightAdapter sliderAdapter = new ViewPagerSpotLightAdapter(categoryModels);
            //SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            spotlightViewPager.setAdapter(sliderAdapter);
            spotlightViewPager.setClipToPadding(false);
            spotlightViewPager.setPageMargin(20);

            btnExperienceSpotlight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent categoryIntent = new Intent(itemView.getContext(), CategoryListActivity.class);
                    categoryIntent.putExtra("serviceNo", SERVICE_NO);
                    itemView.getContext().startActivity(categoryIntent);
                }
            });
        }
    }
}
