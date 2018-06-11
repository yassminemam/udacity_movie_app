package com.example.movies.moviesappfirstpart.api;

import com.example.movies.moviesappfirstpart.pojo.PopularMoviesResource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yahme on 12/2/2017.
 */

public interface APIInterface {

    @GET("movie/popular?")
    Call<PopularMoviesResource> doGetPopularMoviesResources(@Query("api_key") String api_key);
    @GET("movie/top_rated?")
    Call<PopularMoviesResource> doGetTopMoviesResources(@Query("api_key") String api_key);
}
