package com.example.socialworker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {
    // Ключи
    public static final String APP_PREFERENCES = "APP_PREFERENCES=APP_PREFERENCES" ;
    public static final String LOGIN_CASEWORKER = "LOGIN_CASEWORKER=LOGIN_CASEWORKER";
    public static final String PASSWORD_CASEWORKER = "PASSWORD_CASEWORKER=PASSWORD_CASEWORKER" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



    }
}