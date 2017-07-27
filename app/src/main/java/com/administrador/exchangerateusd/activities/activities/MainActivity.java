package com.administrador.exchangerateusd.activities.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.administrador.exchangerateusd.R;
import com.administrador.exchangerateusd.activities.model.RatesUsd;
import com.administrador.exchangerateusd.activities.service.ServiceManager;
import com.administrador.exchangerateusd.activities.service.callback.CallBackChangeRates;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;

import static com.administrador.exchangerateusd.activities.service.constans.ClasConstans.COIN_BASE_RATES;
import static com.administrador.exchangerateusd.activities.service.constans.ClasConstans.LABEL_COIN_BASE;
import static com.administrador.exchangerateusd.activities.service.constans.ClasConstans.LABEL_DATE_CHANGE;
import static com.administrador.exchangerateusd.activities.service.constans.ClasConstans.VALUE_CONTAINER_COIN;

public class MainActivity extends AppCompatActivity {

    ArrayList<RatesUsd> mArrayListRatesCoin = new ArrayList<RatesUsd>();
    String containerValue;
    String rates = "rates";
    String baseCoin;
    String changeFechRates;

    boolean ratebase;
    boolean ratedate;
    boolean ratecoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       ServiceManager.getCoinRatesUsd(new CallBackChangeRates() {
           @Override
           public void onSuccess(JsonObject ListCoinRates) {

               JsonObject jsonObject = ListCoinRates;
               Gson gson = new Gson();
               for (Map.Entry<String,JsonElement> entry : jsonObject.entrySet()){
                   RatesUsd mRatesCoin = new RatesUsd();
                   containerValue = entry.getKey();

                   if (containerValue.equals(LABEL_COIN_BASE)){baseCoin = entry.getValue().toString();}
                   if (containerValue.equals(LABEL_DATE_CHANGE)){changeFechRates = entry.getValue().toString();}
                   if (containerValue.equals(VALUE_CONTAINER_COIN)){
                       mRatesCoin = gson.fromJson(entry.getValue(), RatesUsd.class);





                       mArrayListRatesCoin.add(mRatesCoin);
                   }
                 }



           }

           @Override
           public void onError(String msgError, int indError) {

               Toast.makeText(MainActivity.this,msgError,Toast.LENGTH_LONG).show();

           }
       });


    }
}
