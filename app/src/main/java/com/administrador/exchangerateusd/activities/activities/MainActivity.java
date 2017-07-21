package com.administrador.exchangerateusd.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.administrador.exchangerateusd.R;
import com.administrador.exchangerateusd.activities.service.ServiceManager;
import com.administrador.exchangerateusd.activities.service.callback.CallBackChangeRates;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       ServiceManager.getCoinRatesUsd(new CallBackChangeRates() {
           @Override
           public void onSuccess(JsonObject ListCoinRates) {

               JsonObject jsonObject = ListCoinRates;
               Gson gson = new Gson();


           }

           @Override
           public void onError(String msgError, int indError) {

               Toast.makeText(MainActivity.this,msgError,Toast.LENGTH_LONG).show();

           }
       });


    }
}
