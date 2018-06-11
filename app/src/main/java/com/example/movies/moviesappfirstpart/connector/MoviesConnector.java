package com.example.movies.moviesappfirstpart.connector;

import com.example.movies.moviesappfirstpart.BaseCallback;
import com.example.movies.moviesappfirstpart.api.APIClient;
import com.example.movies.moviesappfirstpart.api.APIInterface;
import com.example.movies.moviesappfirstpart.pojo.PopularMoviesResource;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesConnector {
    public static MoviesConnector instance = null;
    APIInterface apiInterface;

    public static MoviesConnector getInstance() {
        if (instance == null) {
            instance = new MoviesConnector();
        }
        return instance;
    }
    public void getPopularMovies(final BaseCallback baseCallback, String api_key){

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<PopularMoviesResource> call = apiInterface.doGetPopularMoviesResources(api_key);
        call.enqueue(new Callback<PopularMoviesResource>() {
            @Override
            public void onResponse(Call<PopularMoviesResource> call, Response<PopularMoviesResource> response) {
                int responseCode = response.code();
                if (responseCode == 200) {
                    PopularMoviesResource popularMoviesResource = response.body();
                    baseCallback.onSuccess(popularMoviesResource);
                }
                else {
                    baseCallback.onFail("doGetClubsList::Error::Code"+responseCode);

                }
            }

            @Override
            public void onFailure(Call<PopularMoviesResource> call, Throwable t) {
                call.cancel();
                baseCallback.onFail("doGetClubsList::Error");
            }
        });
    }

    public void getTopMovies(final BaseCallback topMoviesBaseCallback, String api_key) {

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<PopularMoviesResource> call = apiInterface.doGetTopMoviesResources(api_key);
        call.enqueue(new Callback<PopularMoviesResource>() {
            @Override
            public void onResponse(Call<PopularMoviesResource> call, Response<PopularMoviesResource> response) {
                int responseCode = response.code();
                if (responseCode == 200) {
                    PopularMoviesResource popularMoviesResource = response.body();
                    topMoviesBaseCallback.onSuccess(popularMoviesResource);
                }
                else {
                    topMoviesBaseCallback.onFail("doGetClubsList::Error::Code"+responseCode);

                }
            }

            @Override
            public void onFailure(Call<PopularMoviesResource> call, Throwable t) {
                call.cancel();
                topMoviesBaseCallback.onFail("doGetClubsList::Error");
            }
        });
    }
}

