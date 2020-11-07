package com.example.uc297;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import java.util.Objects;

public class PaymentActivity extends AppCompatActivity {
    String categoryTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        categoryTitle = getIntent().getStringExtra("categoryName");
        setToolBar(categoryTitle);
    }
    private void setToolBar(String title) {

        Toolbar toolbar = findViewById(R.id.toolbar_hc);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}