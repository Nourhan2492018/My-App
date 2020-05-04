package com.example.myapp.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.myapp.Interface.ApiInterface;
import com.example.myapp.Interface.PresenterInterface;
import com.example.myapp.Model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviePresenter {
private Context context;
private Retrofit retrofit;
private ApiInterface apiInterface;
private List<MovieModel.Results> moviesList;
private PresenterInterface presenterInterface;

    public MoviePresenter(PresenterInterface presenterInterface) {
        this.presenterInterface = presenterInterface;
    }

    public void DataFromRetrofit()
    {
        retrofit=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        Call<MovieModel.Results>movieCall=apiInterface.getMovies();
        movieCall.enqueue(new Callback<MovieModel.Results>() {
            @Override
            public void onResponse(Call<MovieModel.Results> call, Response<MovieModel.Results> response) {
                 moviesList = (List<MovieModel.Results>) response.body();
                 presenterInterface.SetItemMovieInRecycleView(moviesList);
            }

            @Override
            public void onFailure(Call<MovieModel.Results> call, Throwable t) {
                Toast.makeText(context,"onFailure Response",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<MovieModel.Results> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(List<MovieModel.Results> moviesList) {
        this.moviesList = moviesList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public void setApiInterface(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }


    public PresenterInterface getPresenterInterface() {
        return presenterInterface;
    }

    public void setPresenterInterface(PresenterInterface presenterInterface) {
        this.presenterInterface = presenterInterface;
    }
}
