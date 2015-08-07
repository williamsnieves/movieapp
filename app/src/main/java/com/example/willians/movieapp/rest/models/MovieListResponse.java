package com.example.willians.movieapp.rest.models;

import com.example.willians.movieapp.domains.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by willians on 06/08/15.
 */
public class MovieListResponse {

    @SerializedName(JsonKey.MOVIE_RESULTS)
    MovieListResults results;

    public ArrayList<Movie> getMovies(){
        return results.movies;
    }

    public void setMovies(ArrayList<Movie> movies){
        this.results.movies = movies;
    }

    public class MovieListResults{

        ArrayList<Movie> movies;
    }
}
