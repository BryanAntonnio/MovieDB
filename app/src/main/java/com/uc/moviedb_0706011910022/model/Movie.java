package com.uc.moviedb_0706011910022.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String cover;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String desc;

    @SerializedName("release_date")
    private String date;

    public Movie(){}

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Movie(String popularity, String poster, String cover, String title, String desc, String date) {
        this.popularity = popularity;
        this.poster = poster;
        this.cover = cover;
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.popularity);
        dest.writeString(this.poster);
        dest.writeString(this.cover);
        dest.writeString(this.title);
        dest.writeString(this.desc);
        dest.writeString(this.date);
    }

    protected Movie(Parcel in) {
        this.popularity = in.readString();
        this.poster = in.readString();
        this.cover = in.readString();
        this.title = in.readString();
        this.desc = in.readString();
        this.date = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
