package com.example.willians.movieapp.rest.deserializer;

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
        //get instance of Gson class
        Gson gson = new Gson();
        //json from server response
        MovieListResponse response  = gson.fromJson(json, MovieListResponse.class);
        //get a json array to get Movie's data
        JsonArray movieResponseData = json.getAsJsonObject().getAsJsonArray(JsonKey.MOVIE_RESULTS);
        //call a method from model response to set the array movies
        response.setMovies(extractMoviesFromJsonArray(movieResponseData));

        return response;
    }
    //method to get each properties of json object inside json array and set a Movie instance with this data
    private ArrayList<Movie> extractMoviesFromJsonArray(JsonArray jsonArray){
        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < jsonArray.size() ; i++) {
            JsonObject movieData = jsonArray.get(i).getAsJsonObject();

            Movie currentMovie = new Movie();

            String name = movieData.get(JsonKey.MOVIE_NAME).getAsString();
            String average = movieData.get(JsonKey.MOVIE_AVERAGE).getAsString();

            String desc = movieData.get(JsonKey.MOVIE_DESCRIPTION).toString();


            String imageUrlId = movieData.get(JsonKey.MOVIE_IMAGE).getAsString();

            String urlImage = JsonKey.BASE_MOVIE_URL_IMAGE + imageUrlId;

            currentMovie.setMovieName(name);
            currentMovie.setMovieAverage(average);
            currentMovie.setMovieOverview(desc);
            currentMovie.setMovieImageUrl(urlImage);

            movies.add(currentMovie);
        }

        return movies;
    }
}
