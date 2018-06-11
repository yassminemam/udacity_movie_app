package com.example.movies.moviesappfirstpart.view;

import com.example.movies.moviesappfirstpart.pojo.PopularMoviesResource;

public interface MoviesInteractor {
    void initPopularMoviesList(PopularMoviesResource dataModule);

    void errorGetPopularMoviesList(String error);
}
