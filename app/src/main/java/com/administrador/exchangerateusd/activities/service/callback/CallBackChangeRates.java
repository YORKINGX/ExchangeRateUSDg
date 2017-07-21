package com.administrador.exchangerateusd.activities.service.callback;

import com.administrador.exchangerateusd.activities.model.RatesUsd;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * Created by Administrador on 20/07/2017.
 */

public interface CallBackChangeRates {

    void onSuccess(JsonObject ListCoinRates);
    void onError(String msgError, int indError);

}
