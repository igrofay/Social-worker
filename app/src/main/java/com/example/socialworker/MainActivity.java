package com.example.socialworker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Проверка данных( Логин и пароль)
    // Отправка Get запрос (true)
    // Отправка черз NavHost на авторизация (false)
}