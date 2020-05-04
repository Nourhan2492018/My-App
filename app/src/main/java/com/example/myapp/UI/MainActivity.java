package com.example.myapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapp.Adapter.MovieAdapter;
import com.example.myapp.Interface.PresenterInterface;
import com.example.myapp.Model.MovieModel;
import com.example.myapp.Presenter.MoviePresenter;
import com.example.myapp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PresenterInterface {
private RecyclerView nRecyclerView;
private MovieAdapter nMovieAdapter;
private MoviePresenter nMoviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_movie_main);

        nRecyclerView=findViewById(R.id.recycler_view);

        nRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        nMoviePresenter=new MoviePresenter( this);

        nMoviePresenter.DataFromRetrofit();
        SetItemMovieInRecycleView(nMoviePresenter.getMoviesList());

    }

    @Override
    public void SetItemMovieInRecycleView(List<MovieModel.Results> MoviesList)
    {
        nMovieAdapter=new MovieAdapter(MainActivity.this,MoviesList);
        nRecyclerView.setAdapter(nMovieAdapter);

    }
}
