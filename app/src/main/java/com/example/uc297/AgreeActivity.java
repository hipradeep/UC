package com.example.uc297;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class AgreeActivity extends AppCompatActivity {
    String categoryTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);
        categoryTitle = getIntent().getStringExtra("categoryName");
        setToolBar(categoryTitle);

        findViewById(R.id.agreeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AgreeActivity.this, PaymentActivity.class);
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