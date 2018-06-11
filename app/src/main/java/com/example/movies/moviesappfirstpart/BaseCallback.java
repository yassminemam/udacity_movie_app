package com.example.movies.moviesappfirstpart;

/**
 * Created by Yassmin Emam on 1/8/2018.
 */

public interface BaseCallback {

    void onSuccess(Object dataModule);
    void onFail(String error);
}
