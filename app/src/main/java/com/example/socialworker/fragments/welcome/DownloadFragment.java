package com.example.socialworker.fragments.welcome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.socialworker.R;


import static com.example.socialworker.WelcomeActivity.APP_PREFERENCES;
import static com.example.socialworker.WelcomeActivity.LOGIN_CASEWORKER;


public class DownloadFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = (requireActivity()).getSharedPreferences(APP_PREFERENCES , Context.MODE_PRIVATE) ;
        String login = preferences.getString(LOGIN_CASEWORKER , null);
        if( login == null){
            NavHostFragment.findNavController(this).navigate(R.id.action_downloadFragment_to_authorizationFragment);
        }
        String password = preferences.getString(LOGIN_CASEWORKER , "");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_download, container, false);
    }
}