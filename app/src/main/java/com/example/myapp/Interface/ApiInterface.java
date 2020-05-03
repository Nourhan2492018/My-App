package com.example.myapp.Interface;

import com.example.myapp.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("3/movie/now_playing?api_key=32c913288edad9470662db02b7263518&language=en-US&page=2&fbclid=IwAR0rykeE6C8-WA1a38IfWPm7qairgJ0lGbw6xjojms_gNEKE1-C0lTbKUNU")
    public Call<MovieModel.Results> getMovies();
}
