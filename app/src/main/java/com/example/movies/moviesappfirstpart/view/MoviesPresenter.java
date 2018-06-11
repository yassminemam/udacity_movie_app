package com.example.movies.moviesappfirstpart.view;

import com.example.movies.moviesappfirstpart.BaseCallback;
import com.example.movies.moviesappfirstpart.connector.MoviesConnector;
import com.example.movies.moviesappfirstpart.pojo.PopularMoviesResource;

public class MoviesPresenter {

    private MoviesConnector connector;
    private MoviesInteractor interactor;
    public MoviesPresenter(MoviesConnector connector, MoviesInteractor interactor){
        this.connector = connector;
        this.interactor = interactor;
    }

    public void getPopMoviess(String api_key)
    {
        connector.getPopularMovies(popularMoviesBaseCallback, api_key);
    }

    BaseCallback popularMoviesBaseCallback = new BaseCallback() {
        @Override
        public void onSuccess(Object dataModule) {

            interactor.initPopularMoviesList((PopularMoviesResource) dataModule);
        }

        @Override
        public void onFail(String error) {
            interactor.errorGetPopularMoviesList(error);
        }
    };

    public void getTopMovies(String api_key)
    {
        connector.getTopMovies(topMoviesBaseCallback, api_key);
    }

    BaseCallback topMoviesBaseCallback = new BaseCallback() {
        @Override
        public void onSuccess(Object dataModule) {

            interactor.initPopularMoviesList((PopularMoviesResource) dataModule);
        }

        @Override
        public void onFail(String error) {
            interactor.errorGetPopularMoviesList(error);
        }
    };
}
