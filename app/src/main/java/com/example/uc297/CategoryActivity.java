package com.example.uc297;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uc297.Data.CategoriesDataClass;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.uc297.Fragments.HomeFragment.MEN_HAIR_CUT;
import static com.example.uc297.Fragments.HomeFragment.SALON_AT_HOME;

public class CategoryActivity extends AppCompatActivity implements PositionInterface{

    String categoryTitle;
    List<SubCategoryModel> salonAtHomeSubServicesList;
    List<SubCategoryModel> menHairCutSubServicesList;
    List<SubCategoryModel> extSubServicesList;

    public CategoryActivity() {
        CategoriesDataClass categoriesDataClass = new CategoriesDataClass();
        salonAtHomeSubServicesList = categoriesDataClass.getSalonAtHomeSubServicesList();
        menHairCutSubServicesList = categoriesDataClass.getMenHairCutSubServicesList();
        extSubServicesList = categoriesDataClass.getExtSubServicesList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        int[] gallery_img = {R.drawable.placeholder_img, R.drawable.placeholder_img, R.drawable.placeholder_img, R.drawable.placeholder_img,};

        for (int value : gallery_img) {
            setFlipperImage(value);
        }

        categoryTitle = getIntent().getStringExtra("categoryName");
        String categoryDesc = getIntent().getStringExtra("categoryDesc");
        int SERVICE_NO = getIntent().getIntExtra("serviceNo", -1);
        setCollapsingToolbar(categoryTitle, categoryDesc);
        setSubServices(SERVICE_NO);


    }

    private void setSubServices(int SERVICE_NUMBER) {
        LinearLayout recyclerViewContainer = findViewById(R.id.recyclerViewContainer);
        LinearLayout recyclerViewContainerList = findViewById(R.id.recyclerViewContainerList);

        RecyclerView recyclerView = findViewById(R.id.rvSubServicesSAH);
        RecyclerView recyclerViewList = findViewById(R.id.rvSubserviceList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(CategoryActivity.this, 3));

        recyclerViewList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewList.setLayoutManager(linearLayoutManager);


        if (SERVICE_NUMBER == SALON_AT_HOME) {
            recyclerViewContainer.setVisibility(View.VISIBLE);
            recyclerViewContainerList.setVisibility(View.GONE);
            SubCategoryAdapter subServicesAdapter = new SubCategoryAdapter(salonAtHomeSubServicesList, this);
            recyclerView.setAdapter(subServicesAdapter);
        } else if (SERVICE_NUMBER == MEN_HAIR_CUT) {
            recyclerViewContainer.setVisibility(View.VISIBLE);
            recyclerViewContainerList.setVisibility(View.GONE);
            SubCategoryAdapter subServicesAdapter = new SubCategoryAdapter(menHairCutSubServicesList, this);
            recyclerView.setAdapter(subServicesAdapter);


        } else if (SERVICE_NUMBER >= 20 && SERVICE_NUMBER < 30) {
            recyclerViewContainer.setVisibility(View.VISIBLE);
            recyclerViewContainerList.setVisibility(View.GONE);
            SubCategoryAdapter subServicesAdapter = new SubCategoryAdapter(extSubServicesList, this);
            recyclerView.setAdapter(subServicesAdapter);

        } else if (SERVICE_NUMBER >= 30 && SERVICE_NUMBER < 40) {
            recyclerViewContainer.setVisibility(View.GONE);
            recyclerViewContainerList.setVisibility(View.VISIBLE);
            List<SubCategoryListModel> subCategoryListModelList = new ArrayList<>();
            subCategoryListModelList.add(new SubCategoryListModel("Repair/Servicing"));
            subCategoryListModelList.add(new SubCategoryListModel("Installation/Un-Installation"));


            SubCategoryListAdapter adapter = new SubCategoryListAdapter(subCategoryListModelList);
            recyclerViewList.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }


    }

    private void setCollapsingToolbar(final String titleTxt, String catDes) {
        final Toolbar toolbar = findViewById(R.id.toolbarx);
        TextView catDesc = findViewById(R.id.categoryDesc);
        TextView catTitle = findViewById(R.id.categoryTitle);
        catTitle.setText(titleTxt);
        catDesc.setText(catDes);
        setSupportActionBar(toolbar);
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingToolbarx);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbarx);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(titleTxt);
                    collapsingToolbar.setCollapsedTitleTextColor(Color.rgb(0, 0, 0));
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setDisplayShowHomeEnabled(true);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    isShow = false;
                }
            }
        });
    }

    private void setFlipperImage(int res) {
        ViewFlipper viewFlipper = findViewById(R.id.view_flipper_in_appBar);
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundResource(res);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setDisplayedChild(0);
        viewFlipper.startFlipping();
    }



    @Override
    public void getPosition(int position) {
        Intent serviceActivityIntent=new Intent(this, ServiceActivity.class);
        serviceActivityIntent.putExtra("position", position);
        serviceActivityIntent.putExtra("categoryName", categoryTitle);
        startActivity(serviceActivityIntent);
    }
}