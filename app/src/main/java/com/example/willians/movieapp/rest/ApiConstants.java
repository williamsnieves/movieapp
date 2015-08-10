package com.example.willians.movieapp.rest;

/**
 * Created by willians on 06/08/15.
 */
public class ApiConstants {

    public static final String API_KEY = "55b49c23b7f03bad1b9931b37a447216";
    public static final String URL_BASE = "http://api.themoviedb.org/";
    public static final String PATH_VERSION = "/3";

    public static final String PATH_SEARCH = "/search";
    public static final String PATH_PERSON = "/person";

    public static final String PATH_DISCOVER = "/discover";
    public static final String PATH_MOVIE = "/movie";

    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_QUERY = "query";

    public static final String PARAM_PEOPLE = "with_people";

    public static final String VALUE_ID = "12835";


    public static final String VALUE_QUERY = "Vin";

    public static final String URL_MOVIE_SEARCH = PATH_VERSION + PATH_DISCOVER + PATH_MOVIE + "?" + PARAM_API_KEY + "=" + API_KEY + "&" + PARAM_PEOPLE + "=" + VALUE_ID;

    public static final String URL_AUTHOR_SEARCH = PATH_VERSION + PATH_SEARCH + PATH_PERSON + "?" + PARAM_API_KEY + "=" + API_KEY;
}
