package com.example.myapp.Interface;

import com.example.myapp.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/3/movie/upcoming?api_key=32c913288edad9470662db02b7263518&language=en-US&page=1&fbclid=IwAR3oC6xHTCIVh1hCy7N6cE6J99HEPKkxj2DkJXgnAnfZ_PGhtdPOY6LYpB8")
     Call<MovieModel.Results> getMovies();
}
