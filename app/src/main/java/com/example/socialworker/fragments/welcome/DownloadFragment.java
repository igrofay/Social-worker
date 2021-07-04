package com.example.socialworker.fragments.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.socialworker.MainActivity;
import com.example.socialworker.R;
import com.example.socialworker.WelcomeActivity;
import com.example.socialworker.entity.SocialWorker;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.EventListener;

import static com.example.socialworker.Parser.parserSocialWorker;
import static com.example.socialworker.WelcomeActivity.APP_PREFERENCES;
import static com.example.socialworker.WelcomeActivity.LOGIN_CASEWORKER;
import static com.example.socialworker.WelcomeActivity.PASSWORD_CASEWORKER;


public class DownloadFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = (requireActivity()).getSharedPreferences(APP_PREFERENCES , Context.MODE_PRIVATE) ;
        String login = preferences.getString(LOGIN_CASEWORKER , null);
        String password = preferences.getString(PASSWORD_CASEWORKER , "");
        if( login == null) NavHostFragment.findNavController(this).navigate(R.id.authorizationFragment);
        else authorization(login , password);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_download, container, false);
    }

    void finishActivity(){
        Intent intent = new Intent(requireActivity() , MainActivity.class);
        startActivity(intent);
        requireActivity().finish();
    }
    void authorization(String log , String password){
        FirebaseDatabase firebaseApp = FirebaseDatabase.getInstance();
        firebaseApp.getReference("SocialWorkers").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot child: snapshot.getChildren()){
                    String logData = child.child("SocialWorkerLogin").getValue().toString();
                    String passwordData = child.child("SocialWorkerPassword").getValue().toString();
                    if(log.equals(logData) && password.equals(passwordData)){
                        SocialWorker socialWorker = parserSocialWorker(child);
                        ((WelcomeActivity) requireActivity()).socialWorker = socialWorker;
                        downloadAllData(socialWorker);
                        return;
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void downloadAllData(SocialWorker socialWorker){

    }


}
