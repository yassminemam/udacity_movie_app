package com.example.movies.moviesappfirstpart.view.moviedetails;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movies.moviesappfirstpart.R;
import com.example.movies.moviesappfirstpart.pojo.Result;
import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {
    private Result movie;
    private String MOVIE = "MOVIE";
    private TextView movieNameTV, movieYearTV, movieDescripTV, movieRatingTV, makeFavTV;
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
    private String IMAGE_SIZE = "w500";
    private ImageView posterIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        setTitle("MovieDetails");
        movieNameTV = findViewById(R.id.tv_movie_name);
        movieYearTV = findViewById(R.id.tv_movie_year);
        movieDescripTV = findViewById(R.id.tv_movie_descrip);
        movieRatingTV = findViewById(R.id.tv_movie_rating);
        makeFavTV = findViewById(R.id.tv_make_fav);
        posterIV = findViewById(R.id.iv_movie_poster);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(MOVIE) && intent.getParcelableExtra(MOVIE) != null) {
            movie = intent.getParcelableExtra(MOVIE);
            if (movie.getTitle() != null)
                movieNameTV.setText(movie.getTitle());
            if (movie.getReleaseDate() != null)
                movieYearTV.setText(movie.getReleaseDate());
            movieRatingTV.setText(movie.getVoteAverage() + " / " + movie.getVoteCount());
            if (movie.getPosterPath() != null)
                Picasso.with(this)
                        .load(Uri.parse(IMAGE_BASE_URL + IMAGE_SIZE + movie.getPosterPath())).into(posterIV);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (movie != null)
        {
            if (movie.getTitle() != null)
                movieNameTV.setText(movie.getTitle());
            if (movie.getReleaseDate() != null)
                movieYearTV.setText(movie.getReleaseDate());
            movieRatingTV.setText(movie.getVoteAverage() + " / 10");
            if (movie.getPosterPath() != null)
                Picasso.with(this)
                        .load(Uri.parse(IMAGE_BASE_URL + IMAGE_SIZE + movie.getPosterPath())).into(posterIV);
            if (movie.getOverview() != null)
                movieDescripTV.setText(movie.getOverview());
        }

    }
}
