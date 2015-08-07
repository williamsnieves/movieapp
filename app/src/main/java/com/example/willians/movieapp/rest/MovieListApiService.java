package com.example.willians.movieapp.rest;

import com.example.willians.movieapp.rest.models.MovieListResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by willians on 06/08/15.
 */
public interface MovieListApiService {
    @Headers("Content-Type: application/json")
    @GET(ApiConstants.URL_MOVIE_SEARCH)
    void getMovieList(Callback<MovieListResponse> serverResponse);
}
