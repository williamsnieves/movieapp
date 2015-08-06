package com.example.willians.movieapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.willians.movieapp.R;
import com.example.willians.movieapp.domains.Movie;

import java.util.ArrayList;

/**
 * Created by willians on 05/08/15.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    ArrayList<Movie> movies;
    Context context;

    public MovieListAdapter(Context context){
        this.context = context;
        this.movies = new ArrayList<>();

    }

    @Override
    public MovieListAdapter.MovieListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie_list, parent, false);

        return new MovieListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MovieListViewHolder holder, int position) {
        Movie currentMovie = movies.get(position);

        holder.setMovieName(currentMovie.getMovieName());
        holder.setMovieDesc(currentMovie.getMovieDesc());
        holder.setMovieAverage(currentMovie.getMovieAverage());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void addAll(ArrayList<Movie> movies){
        if(movies == null)
            throw new NullPointerException("The items cannot be null");

        this.movies.addAll(movies);
        notifyDataSetChanged();


    }


    public class MovieListViewHolder extends RecyclerView.ViewHolder{

        ImageView imgUrl;
        TextView movieName;
        TextView movieDesc;
        TextView movieAvg;

        public MovieListViewHolder(View itemView) {

            super(itemView);

            movieName = (TextView)itemView.findViewById(R.id.movie_name);
            movieDesc =(TextView)itemView.findViewById(R.id.movie_desc);
            movieAvg =(TextView)itemView.findViewById(R.id.movie_avg);
        }

        public void setMovieImage(String url){
            //imgUrl.src(url);
            //picasso
        }

        public void setMovieName(String name){
            movieName.setText(name);


        }

        public void setMovieDesc(String description){
            movieDesc.setText(description);
        }

        public void setMovieAverage(String average){
            movieAvg.setText(average);
        }
    }
}
