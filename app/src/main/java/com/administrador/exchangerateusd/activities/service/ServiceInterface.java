package com.administrador.exchangerateusd.activities.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrador on 03/06/2017.
 */

public interface ServiceInterface {


    @GET("latest?base=USD")
    Call<JsonObject> getCoinRates();
/*
    @POST("usuario.json")
    Call<JsonObject> createPeople(@Body PeopleModel person);*/


}

