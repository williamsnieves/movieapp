package com.example.willians.movieapp.rest.deserializer;

import android.util.Log;

import com.example.willians.movieapp.domains.Movie;
import com.example.willians.movieapp.rest.models.JsonKey;
import com.example.willians.movieapp.rest.models.MovieListResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by willians on 07/08/15.
 */
public class MovieListDeserializer implements JsonDeserializer<MovieListResponse> {
    @Override
    public MovieListResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        MovieListResponse response  = gson.fromJson(json, MovieListResponse.class);

        JsonArray movieResponseData = json.getAsJsonObject().getAsJsonArray(JsonKey.MOVIE_RESULTS);

        response.setMovies(extractMoviesFromJsonArray(movieResponseData));
        Log.e("data", movieResponseData.toString());

        return response;
    }

    private ArrayList<Movie> extractMoviesFromJsonArray(JsonArray jsonArray){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < jsonArray.size() ; i++) {
            JsonObject movieData = jsonArray.get(i).getAsJsonObject();

            Movie currentMovie = new Movie();

            String name = movieData.get(JsonKey.MOVIE_NAME).getAsString();

            currentMovie.setMovieName(name);

            movies.add(currentMovie);
        }

        return movies;
    }
}
