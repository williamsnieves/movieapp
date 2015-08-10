package com.example.willians.movieapp.rest.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by willians on 09/08/15.
 */
public class AuthorIdResponse {

    @SerializedName(JsonKey.AUTHOR_RESULTS)
    AuthorListResults[] results;


    public Integer getAuthorMovieId(){
        return results[0].id;
    }

    public class AuthorListResults{
        //@SerializedName(JsonKey.MOVIE_ARRAY)
        Integer id;
    }
}
