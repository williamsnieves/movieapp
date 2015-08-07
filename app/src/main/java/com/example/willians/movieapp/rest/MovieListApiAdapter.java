package com.example.willians.movieapp.rest;

import retrofit.RestAdapter;

/**
 * Created by willians on 06/08/15.
 */
public class MovieListApiAdapter {

    private static MovieListApiService API_SERVICE;

    public static MovieListApiService getApiService(){
        if(API_SERVICE == null){
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstants.URL_BASE)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            API_SERVICE = adapter.create(MovieListApiService.class);
        }

        return API_SERVICE;
    }
}
