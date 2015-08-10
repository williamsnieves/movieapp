package com.example.willians.movieapp.rest.models;

import com.example.willians.movieapp.domains.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by willians on 06/08/15.
 */
public class MovieListResponse {

    /*@SerializedName(JsonKey.AUTHOR_RESULTS)
    AuthorListResults[] results;*/

    @SerializedName(JsonKey.MOVIE_RESULTS)
    ArrayList<Movie> resultsMovie;

    public ArrayList<Movie> getMovies(){
        return resultsMovie;
    }

    public void setMovies(ArrayList<Movie> movies){
        this.resultsMovie = movies;
    }

    /*public Integer getAuthorMovieId(){
        return results[0].id;
    }*/

    /*public void setMovies(ArrayList<Movie> movies){
        this.results.movies = movies;
    }*/

    /*public class MovieListResults{
        @SerializedName(JsonKey.MOVIE_ARRAY)
        ArrayList<Movie> movies;
    }*/

    /*public class AuthorListResults{
        //@SerializedName(JsonKey.MOVIE_ARRAY)
        Integer id;
    }*/

}
