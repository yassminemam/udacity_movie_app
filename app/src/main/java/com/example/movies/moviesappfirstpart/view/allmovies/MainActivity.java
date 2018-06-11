package com.example.movies.moviesappfirstpart.view.allmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.movies.moviesappfirstpart.AppUtilities;
import com.example.movies.moviesappfirstpart.R;
import com.example.movies.moviesappfirstpart.connector.MoviesConnector;
import com.example.movies.moviesappfirstpart.pojo.PopularMoviesResource;
import com.example.movies.moviesappfirstpart.pojo.Result;
import com.example.movies.moviesappfirstpart.view.MoviesInteractor;
import com.example.movies.moviesappfirstpart.view.MoviesPresenter;
import com.example.movies.moviesappfirstpart.view.moviedetails.MovieDetailsActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MoviesInteractor, MoviesListListener{
    private MoviesConnector moviesConnector;
    private MoviesPresenter moviesPresenter;
    private RecyclerView moviesRV;
    private final static int NUMBER_OF_COLUMNS = 2;
    private String MOVIE = "MOVIE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pop Movies");
        moviesRV = findViewById(R.id.rv_movies);
        moviesConnector = MoviesConnector.getInstance();
        moviesPresenter = new MoviesPresenter(moviesConnector, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesPresenter.getPopMoviess(AppUtilities.API_KEY);

    }

    @Override
    public void initPopularMoviesList(PopularMoviesResource dataModule) {
        MoviesListAdapter adapter = new MoviesListAdapter(this, (ArrayList<Result>) dataModule.getResults(), this);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this, NUMBER_OF_COLUMNS);
        moviesRV.setLayoutManager(mLayoutManager);
        moviesRV.setAdapter(adapter);
    }

    @Override
    public void errorGetPopularMoviesList(String error) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClickMovieCover(Result result) {
        Intent intent = new Intent(this, MovieDetailsActivity.class);
        intent.putExtra(MOVIE, result);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.top_rated:
                moviesPresenter.getTopMovies(AppUtilities.API_KEY);
                return true;
            case R.id.most_pop:
                moviesPresenter.getPopMoviess(AppUtilities.API_KEY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
