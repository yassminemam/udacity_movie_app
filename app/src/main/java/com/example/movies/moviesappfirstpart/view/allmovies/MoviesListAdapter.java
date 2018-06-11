package com.example.movies.moviesappfirstpart.view.allmovies;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.movies.moviesappfirstpart.R;
import com.example.movies.moviesappfirstpart.pojo.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MyViewHolder> {
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
    private String IMAGE_SIZE = "w500";
    private Activity context;
    private MoviesListListener listener;
    private ArrayList<Result> results;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView movieCoverPhotoIV;

        public MyViewHolder(View view) {
            super(view);
            movieCoverPhotoIV = view.findViewById(R.id.iv_movie_cover);
            movieCoverPhotoIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickMovieCover(results.get(getAdapterPosition()));
                }
            });
        }

    }

    public MoviesListAdapter(Activity mContext, ArrayList<Result> results, MoviesListListener listener) {
        this.context = mContext;
        this.results = results;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_cover, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        final Result result = results.get(position);

        if (result.getBackdropPath() != null && !result.getBackdropPath().isEmpty())
        {
            Picasso.with(context)
                    .load(Uri.parse(IMAGE_BASE_URL + IMAGE_SIZE + result.getBackdropPath())).into(holder.movieCoverPhotoIV);

        }

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

}
