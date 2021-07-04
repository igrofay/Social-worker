package com.example.socialworker.fragments.welcome;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.socialworker.R;

import java.util.ArrayList;

import static com.example.socialworker.WelcomeActivity.APP_PREFERENCES;
import static com.example.socialworker.WelcomeActivity.LOGIN_CASEWORKER;
import static com.example.socialworker.WelcomeActivity.PASSWORD_CASEWORKER;


public class AuthorizationFragment extends Fragment {
    EditText inputLog ;
    EditText inputPassword ;
    Button signIn ;
    String log;
    String password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_authorization, container, false);
        inputLog = v.findViewById(R.id.input_login);
        inputPassword = v.findViewById(R.id.input_password);
        signIn = v.findViewById(R.id.sign_in);

        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signIn.setOnClickListener(v -> {
            String textLog = inputLog.getText().toString();
            String[] strListLog = textLog.split(" ");
            String textPassword = inputPassword.getText().toString() ;
            String[] strListPassword = textPassword.split(" ");
            if(strListLog.length != 0 && !textLog.equals("")
                    && strListPassword.length != 0 && !textPassword.equals("")
            ){
                ArrayList<String> stringsLog = new ArrayList<>();
                ArrayList<String> stringsPassword = new ArrayList<>();
                for (String str:  strListLog) {
                    if(!str.equals("")) stringsLog.add(str);
                }
                for (String str:  strListPassword) {
                    if(!str.equals("")) stringsPassword.add(str);
                }
                log = String.join(" ", stringsLog);
                password = String.join(" ", stringsPassword);
            }else {
                Toast.makeText(requireContext(), "Текст не может быть пустым", Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences.Editor editor = ((requireActivity()).getSharedPreferences(APP_PREFERENCES , Context.MODE_PRIVATE)).edit() ;
            editor.putString(LOGIN_CASEWORKER , log);
            editor.putString(PASSWORD_CASEWORKER , password);
            editor.apply();
            NavHostFragment.findNavController(this).navigate(R.id.downloadFragment);
        });
    }
}