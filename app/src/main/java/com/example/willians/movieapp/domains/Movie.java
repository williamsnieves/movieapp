package com.example.willians.movieapp.domains;

import java.util.Date;

/**
 * Created by willians on 05/08/15.
 */
public class Movie {


    private String movieName;
    private String movieImageUrl;
    private String movieAverage;
    private Date movieDate;


    public Movie(String movieName, String movieImageUrl, String movieAverage, Date movieDate){

        this.movieName = movieName;
        this.movieImageUrl = movieImageUrl;
        this.movieAverage = movieAverage;
        this.movieDate = movieDate;

    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public String getMovieAverage() {
        return movieAverage;
    }

    public void setMovieAverage(String movieAverage) {
        this.movieAverage = movieAverage;
    }

    public Date getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Date movieDate) {
        this.movieDate = movieDate;
    }


}
