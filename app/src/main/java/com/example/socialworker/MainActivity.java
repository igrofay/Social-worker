package com.example.socialworker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.socialworker.entity.SocialWorker;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.socialworker.WelcomeActivity.SOCIAL_WORKER;

public class MainActivity extends AppCompatActivity {
    public SocialWorker socialWorker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        socialWorker = getIntent().getParcelableExtra(SOCIAL_WORKER);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.fragment_main);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public SocialWorker getSocialWorker() {
        return socialWorker;
    }

}