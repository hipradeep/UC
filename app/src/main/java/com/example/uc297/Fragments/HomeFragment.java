package com.example.uc297.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uc297.Data.CategoriesDataClass;
import com.example.uc297.CategoryModel;
import com.example.uc297.HomePageAdapter;
import com.example.uc297.HomePageModel;
import com.example.uc297.ToolbarActivities.LocationActivity;
import com.example.uc297.R;
import com.example.uc297.ToolbarActivities.SearchProductsActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    public static int SALON_AT_HOME=50;
    public static int MEN_HAIR_CUT=60;

    public static int CLEANING_AND_DUST=20;
    public static int BATHROOM_CLEANING=21;
    public static int SOFA_CLEANING=22;
    public static int KITCHEN_CLEANING=23;
    public static int CARPET_CLEANING=24;

    public static int APPLIANCE_REPAIR=30;
    public static int AC_SERVICE=31;
    public static int GEYSER_SERVICE=32;
    public static int RO_WATER_PURIFIER=33;
    public static int WASHING_MACHINE=34;

    public static int CONST=100;
    public static int SPOTLIGHT =1000;

    List<CategoryModel> bannerSliderList;
    List<CategoryModel> customersViewsSliderList;
    List<CategoryModel> cleaningAndPestControlList;
    List<CategoryModel> appliancesServiceAndRepair;
    List<CategoryModel> spotlightExperienceList;
    public HomeFragment() {
        // Required empty public constructor
        CategoriesDataClass categoriesDataClass=new CategoriesDataClass();
        bannerSliderList= categoriesDataClass.getBannerSliderList();
        customersViewsSliderList= categoriesDataClass.getCustomersViewsSliderList();
        cleaningAndPestControlList=categoriesDataClass.getCleaningAndPestControlList();
        appliancesServiceAndRepair=categoriesDataClass.getAppliancesServiceAndRepair();
        spotlightExperienceList=categoriesDataClass.getSpotlightExperienceList();
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        assert activity != null;
        activity.setSupportActionBar(toolbar);

        openLocationActivity(view);

        openSearchProductsActivity(view);

        ////////////////////////////available services

        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(SALON_AT_HOME,R.drawable.fackpackcolor, "Salon at Home","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(MEN_HAIR_CUT, R.drawable.haircut, "Hair Cut at Home","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CLEANING_AND_DUST,R.drawable.dustcleaner, "Cleaning & Disinfection","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(APPLIANCE_REPAIR,R.drawable.applicationrepair, "Application Repair","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.acimg, "AC Service & Repair","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.carpenter, "Painters","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.electrician, "Electrician","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.plumbing_logo, "Plumbers","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.carpenter, "Carpenter","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.disinfection, "Pest Control","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.yoga, "Massage Therapy","Services allowed as per governments order" ));
        categoryModelList.add(new CategoryModel(CONST,R.drawable.yoga, "Online Yoga","Services allowed as per governments order" ));
        ////////////////////////////available services



        RecyclerView recyclerView=view.findViewById(R.id.home_page_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<HomePageModel> homePageModelList=new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, false,"null", "null",bannerSliderList));
        homePageModelList.add(new HomePageModel(1, R.drawable.special_offers_logo, "#E5F1FA"));
        homePageModelList.add(new HomePageModel(2, "Service Available in Your Area", categoryModelList ));
        homePageModelList.add(new HomePageModel(3, CLEANING_AND_DUST,"Cleaning & Pest Control","Removes hard stains & more", cleaningAndPestControlList ));
        homePageModelList.add(new HomePageModel(4, SPOTLIGHT,"Experience in the Spotlight","Hygienic, Low-Contact Services", spotlightExperienceList ));
        homePageModelList.add(new HomePageModel(0, true,"Customer safety is our priority","What customers are saying about our safety standards",customersViewsSliderList));

        homePageModelList.add(new HomePageModel(3,APPLIANCE_REPAIR, "Appliances: Services & Repair","Expert technicians at your doorstep in 2 hours", appliancesServiceAndRepair ));

        HomePageAdapter adapter=new HomePageAdapter(homePageModelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;

    }



    //------Open Search For Products Activities

    private void openSearchProductsActivity(View view) {
        view.findViewById(R.id.searchServices).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchProductsActivity.class));
            }
        });
    }

    //------Open Location Activity

    private void openLocationActivity(View view) {
        view.findViewById(R.id.locationHeader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LocationActivity.class));
            }
        });
    }


}