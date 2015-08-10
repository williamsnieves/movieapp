package com.example.willians.movieapp.rest;

import com.example.willians.movieapp.rest.models.AuthorIdResponse;
import com.example.willians.movieapp.rest.models.MovieListResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Created by willians on 06/08/15.
 */
public interface MovieListApiService {
    @Headers("Content-Type: application/json")
    @GET(ApiConstants.URL_AUTHOR_SEARCH)
    void getAuthorId(@Query(ApiConstants.PARAM_QUERY) String authorName, Callback<AuthorIdResponse> serverResponse);



    @Headers("Content-Type: application/json")
    @GET(ApiConstants.URL_MOVIE_SEARCH)
    void getMovieList(@Query(ApiConstants.PARAM_PEOPLE) Integer idAuthor, Callback<MovieListResponse> serverResponse);


}
