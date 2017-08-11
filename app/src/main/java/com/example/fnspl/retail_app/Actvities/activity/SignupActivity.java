package com.example.fnspl.retail_app.Actvities.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.fnspl.retail_app.Actvities.models.Login_model;
import com.example.fnspl.retail_app.R;
import com.example.fnspl.retail_app.databinding.ActivityLoginBinding;
import com.example.fnspl.retail_app.databinding.ActivitySignupBinding;

/**
 * Created by FNSPL on 8/8/2017.
 */

public class SignupActivity extends AppCompatActivity{

    ActivitySignupBinding binding_signup ;
    private Login_model login_model;
    String TAG ="dev";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_signup);

        binding_signup = DataBindingUtil.setContentView(this,R.layout.activity_signup);
        login_model = new Login_model();
        binding_signup.setUser(login_model);
        binding_signup.setActivity(SignupActivity.this);

    }


    public void login(){

        Log.d(TAG, "login"+ login_model.getUsername());
        login_model.getUsername();
        supportFinishAfterTransition();
        overridePendingTransition(R.anim.slideinfromleft, R.anim.slideouttoright);
    }

    public void signup(){

        Log.d(TAG, "signup");
      //  startActivity(new Intent(LoginActivity.this,SignupActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        supportFinishAfterTransition();
        overridePendingTransition(R.anim.slideinfromleft, R.anim.slideouttoright);
    }


    @BindingAdapter("app:font_lite")
    public static  void setFont_lite(TextView tv , Typeface typeface){

        AssetManager assetManager = tv.getContext().getAssets();
        typeface = Typeface.createFromAsset(assetManager, "fonts/helviticaneulight.ttf");

        tv.setTypeface(typeface);
    }

    @BindingAdapter("app:font_thin")
    public static  void setFont_thin(TextView tv , Typeface typeface){

        AssetManager assetManager = tv.getContext().getAssets();
        typeface = Typeface.createFromAsset(assetManager, "fonts/helviticaneuthin.ttf");

        tv.setTypeface(typeface);
    }
}
