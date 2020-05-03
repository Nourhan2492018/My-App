package com.example.myapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Interface.CardOnClickMovie;
import com.example.myapp.Model.MovieModel;

import com.example.myapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieView> {
    private Context mcontext;
    private List<MovieModel.Results> moviesList;
    private CardOnClickMovie cardOnClickMovie;

    public  void setOnItemClickListner(CardOnClickMovie listner)
    {
        cardOnClickMovie =listner;

    }
    public MovieAdapter(Context context, List<MovieModel.Results> movieItemsList)
    {
        mcontext=context;
        moviesList =movieItemsList;

    }

    @NonNull
    @Override
    public MovieView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.movie_view_item,parent,false);
        return new MovieView(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieView holder, int position) {
        MovieModel.Results movieItem= moviesList.get(position);
       // holder.mTextViewTitle.setText(movieItem.getTitle());
      //  holder.mViewOriginTitle.setText(movieItem.getmOriginTitle());
        holder.mTextViewTitle.setText(movieItem.getOverview());
        Picasso.with(mcontext).load("https://image.tmdb.org/t/p/w500"+movieItem.getBackdropPath()).fit().centerInside().into(holder.mIamageView);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

       public class MovieView extends RecyclerView.ViewHolder{
        public ImageView mIamageView;
        public TextView mTextViewTitle;

        public MovieView(@NonNull View itemMovie) {
            super(itemMovie);
            mIamageView=itemMovie.findViewById(R.id.image_movie_view);
            mTextViewTitle =itemMovie.findViewById(R.id.text_Title_view);


            itemMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardOnClickMovie !=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            cardOnClickMovie.OnClicTriposoItem(position);
                        }
                    }
                }
            });
        }
    }
}
