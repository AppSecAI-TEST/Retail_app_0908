package com.example.fnspl.retail_app.Actvities.models;

import android.databinding.BaseObservable;

/**
 * Created by FNSPL on 8/8/2017.
 */

public class Login_model extends BaseObservable {

    public String username , password ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
