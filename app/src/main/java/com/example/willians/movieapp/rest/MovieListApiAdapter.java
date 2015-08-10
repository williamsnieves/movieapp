package com.example.willians.movieapp.rest;

import com.example.willians.movieapp.rest.deserializer.MovieListDeserializer;
import com.example.willians.movieapp.rest.models.MovieListResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by willians on 06/08/15.
 */
public class MovieListApiAdapter {

    private static MovieListApiService API_SERVICE;

    public static MovieListApiService getApiService(){
        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(buildLastFmApiGsonConverter())
                    .build();

            API_SERVICE = adapter.create(MovieListApiService.class);
        }

        return API_SERVICE;
    }

    private static GsonConverter buildLastFmApiGsonConverter(){
        Gson gsonConf = new GsonBuilder()
                .registerTypeAdapter(MovieListResponse.class, new MovieListDeserializer())
                .create();

        return new GsonConverter(gsonConf);
    }
}
