package com.example.willians.movieapp.domains;

/**
 * Created by willians on 05/08/15.
 */
public class Movie {

    //this is the movie name in the item_layout to the recycler view list
    private String movieName;
    //this is the variable to set image url from server request
    private String movieImageUrl;
    //this is the variable to set movie average from server
    private String movieAverage;
    // this is the variable to set the movie description from server
    private String movieOverview;

    //constructor class empty
    public Movie(){

    }

    //get movie name from variable
    public String getMovieName() {
        return movieName;
    }
    //setter to set moviename value
    public void setMovieName(String name) {
        this.movieName = name;
    }
    //get url image from a movie
    public String getMovieImageUrl() {
        return movieImageUrl;
    }
    //set url image in movie
    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    //get movie average

    public String getMovieAverage() {
        return movieAverage;
    }

    //set movie average from the server
    public void setMovieAverage(String movieAverage) {
        this.movieAverage = movieAverage;
    }


    //get movie description
    public String getMovieOverview() {
        return movieOverview;
    }

    //set descriotion from server
    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }


}
