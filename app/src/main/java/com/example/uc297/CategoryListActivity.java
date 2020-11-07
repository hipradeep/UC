package com.example.uc297;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.uc297.Data.CategoriesDataClass;
import com.example.uc297.ToolbarActivities.SearchProductsActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.uc297.Fragments.HomeFragment.CLEANING_AND_DUST;
import static com.example.uc297.Fragments.HomeFragment.CONST;

public class CategoryListActivity extends AppCompatActivity {

    List<CategoryModel> appliancesServiceAndRepair;
    List<CategoryModel> cleaningAndPestControlList;

    public CategoryListActivity(){
        CategoriesDataClass categoriesDataClass=new CategoriesDataClass();
        appliancesServiceAndRepair=categoriesDataClass.getAppliancesServiceAndRepair();
        cleaningAndPestControlList=categoriesDataClass.getCleaningAndPestControlList();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        setToolBarLayout();


        int SERVICE_NO = getIntent().getIntExtra("serviceNo", -1);

        RecyclerView categoryListRecyclerView=findViewById(R.id.category_list_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        categoryListRecyclerView.setLayoutManager(layoutManager);
        List<CategoryListModel> categoryListModelList=new ArrayList<>();

        if (SERVICE_NO==CLEANING_AND_DUST){
            categoryListModelList.add(new CategoryListModel(CLEANING_AND_DUST,R.drawable.bathroom_cleaning,"Bathroom Deep Cleaning","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CLEANING_AND_DUST,R.drawable.sofa_cleaning,"Sofa Cleaning","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CLEANING_AND_DUST,R.drawable.placeholder_img,"Kitchen Deep Cleaning","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CLEANING_AND_DUST,R.drawable.carpet_cleaning,"Carpet Cleaning","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CLEANING_AND_DUST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));

        }else {
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));
            categoryListModelList.add(new CategoryListModel(CONST,R.drawable.placeholder_img,"Service","Services allowed as per governments order"));

        }

        CategoryListAdapter adapter;
        if (SERVICE_NO>=20 && SERVICE_NO<30){
         adapter =new CategoryListAdapter(cleaningAndPestControlList);
            categoryListRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
        if (SERVICE_NO>=30 && SERVICE_NO<40){
            adapter =new CategoryListAdapter(appliancesServiceAndRepair);
            categoryListRecyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }



    }
    private void setToolBarLayout() {

        findViewById(R.id.goHomeFromCleaningDisinfectionListActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        findViewById(R.id.searchCleaningDisinfectionListActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryListActivity.this, SearchProductsActivity.class));
            }
        });
    }
}