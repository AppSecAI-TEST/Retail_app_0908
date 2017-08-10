package com.example.fnspl.retail_app.Actvities.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.fnspl.retail_app.Actvities.models.Login_model;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding ;
    private Login_model login_model;
    String TAG ="dev";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        login_model = new Login_model();
        binding.setUser(login_model);
        binding.setActivity(LoginActivity.this);

    }


    public void login(){

        Log.d(TAG, "login"+ login_model.getUsername());
        login_model.getUsername();
        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
        finish();
    }

    public void signup(){

        Log.d(TAG, "signup");
        startActivity(new Intent(LoginActivity.this,SignupActivity.class));
    }

    public void forgetpassoword(){

        startActivity(new Intent(LoginActivity.this,ForgetpasswordActivity.class));

    }
}

