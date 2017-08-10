package com.example.fnspl.retail_app.Actvities.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fnspl.retail_app.Actvities.models.Login_model;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends AppCompatActivity {

    private ActivityProductDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        binding.setActivity(ProductDetailActivity.this);
    }

    public void onBack(){
        finish();
    }

    public void onItemLike(){

    }
}
