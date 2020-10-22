package com.uc.moviedb_0706011910022.util;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class Constants {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY  = "1e806466ca9404d54f72b63163e05bb9";
    public static final String IMG_BASE_URL = "https://image.tmdb.org/t/p/original";


    @Retention(SOURCE)
    @StringDef
    public @interface Type {
        String MOVIES = "movie";
        String TV_SHOWS = "tv";
    }
}
