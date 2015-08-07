package com.example.willians.movieapp.rest.deserializer;

import android.util.Log;

import com.example.willians.movieapp.rest.models.MovieListResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by willians on 07/08/15.
 */
public class MovieListDeserializer implements JsonDeserializer<MovieListResponse> {
    @Override
    public MovieListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        MovieListResponse response  = gson.fromJson(json, MovieListResponse.class);

        //JsonArray authorResponseData = json.getAsJsonArray(JsonKey.MOVIE_RESULTS);

        Log.e("data", json.getAsString());

        return response;


    }
}
