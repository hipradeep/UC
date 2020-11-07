package com.example.uc297;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AddOnActivity extends AppCompatActivity {
String categoryTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_on);
        categoryTitle = getIntent().getStringExtra("categoryName");
        setToolBar(categoryTitle);
        RecyclerView addOnRecyclerView=findViewById(R.id.add_on_recycler_view);

        List<AddOnModel> addOnModelList=new ArrayList<>();

        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add ", "39"));
        addOnModelList.add(new AddOnModel(R.drawable.placeholder_img,"Add On Service", "39"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        addOnRecyclerView.setLayoutManager(gridLayoutManager);
        AddOnAdapter adapter=new AddOnAdapter(addOnModelList);
        addOnRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AddOnActivity.this,AgreeActivity.class );
                intent.putExtra("categoryName", categoryTitle);
                startActivity(intent);
            }
        });


    }
    private void setToolBar(String title) {

        Toolbar toolbar = findViewById(R.id.toolbar_hc);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}