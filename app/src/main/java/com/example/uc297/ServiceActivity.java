package com.example.uc297;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uc297.Data.CategoriesDataClass;
import com.example.uc297.Data.SubServicesDataClass;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;

public class ServiceActivity extends AppCompatActivity implements CartInterface{
    TabLayout tabLayout;
    String categoryTitle;

    List<ServiceModel> serviceModelList;
    List<SubCategoryModel> salonAtHomeSubServicesList;

    public ServiceActivity() {
        SubServicesDataClass subServicesDataClass = new SubServicesDataClass();
        CategoriesDataClass categoriesDataClass=new CategoriesDataClass();
        serviceModelList = subServicesDataClass.getServiceModelList();
        salonAtHomeSubServicesList=categoriesDataClass.getSalonAtHomeSubServicesList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        categoryTitle = getIntent().getStringExtra("categoryName");
        setToolBar(categoryTitle);
        setTabLayout();
        RecyclerView serviceRecyclerView = findViewById(R.id.service_recyclerView);

        int position = getIntent().getIntExtra("position", -1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        serviceRecyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.scrollToPositionWithOffset(position, 0);
        ServiceAdapter serviceAdapter = new ServiceAdapter(salonAtHomeSubServicesList, this);
        serviceRecyclerView.setAdapter(serviceAdapter);
        serviceAdapter.notifyDataSetChanged();

    }


    private void setToolBar(String title) {

        Toolbar toolbar = findViewById(R.id.toolbar_hc);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setTabLayout() {

        tabLayout = findViewById(R.id.tablayout_hc);
        for (int i = 0; i < salonAtHomeSubServicesList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(salonAtHomeSubServicesList.get(i).getSubCategoryTitle()));
        }

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(15, 12, 15, 12);
            tab.requestLayout();
        }

        /*tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                *//*switch (tab.getPosition()) {
                    case 0:
                        nsv_hair_cut.smoothScrollTo(0, hc_packages_deals.getTop());


                        tabLayout.getTabAt(0).select();
                        break;
                    case 1:
                        nsv_hair_cut.smoothScrollTo(0, hc_haircut_for_men.getTop());
                        tabLayout.getTabAt(1).select();
                        break;
                    case 2:
                        nsv_hair_cut.smoothScrollTo(0, hc_haircut_for_kids.getTop());
                        tabLayout.getTabAt(2).select();
                        break;
                    case 3:
                        nsv_hair_cut.smoothScrollTo(0, hc_shave_beard_mustache.getTop());
                        tabLayout.getTabAt(3).select();
                        break;
                    case 4:
                        nsv_hair_cut.smoothScrollTo(0, hc_hair_color.getTop());
                        tabLayout.getTabAt(4).select();
                        break;
                    case 5:
                        nsv_hair_cut.smoothScrollTo(0, hc_head_n_shoulder_Massage.getTop());
                        tabLayout.getTabAt(5).select();
                        break;

                    default:
                }*//*
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }

        });*/
    }


    @Override
    public void onAddCartButtonClick( int totalItems, int amount) {


        LinearLayout cartButtonLinear=findViewById(R.id.cartButtonLinear);
        TextView numberOfItems=findViewById(R.id.numberOfItems);
        TextView cartTotalAmount=findViewById(R.id.cartTotalAmount);
        if (amount<=0){
            cartButtonLinear.setVisibility(View.GONE);
        }else {
            cartButtonLinear.setVisibility(View.VISIBLE);
            cartTotalAmount.setText("₹"+amount);
            numberOfItems.setText(String.valueOf(totalItems));
        }

        cartButtonLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ServiceActivity.this, AddOnActivity.class);
                intent.putExtra("categoryName", categoryTitle);
                startActivity(intent);
            }
        });

    }
}