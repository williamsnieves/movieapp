package com.example.willians.movieapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willians.movieapp.R;
import com.example.willians.movieapp.domains.Movie;
import com.example.willians.movieapp.ui.adapters.MovieListAdapter;

import java.util.ArrayList;

/**
 * Created by willians on 05/08/15.
 */
public class MovieListFragment extends Fragment {

    private RecyclerView mMoviewList;
    private MovieListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MovieListAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_movie_list, container, false);

        mMoviewList = (RecyclerView)fragment.findViewById(R.id.movie_list);

        setupMovieList();
        setDummyData();

        return fragment;
    }


    public void setupMovieList(){
        mMoviewList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMoviewList.setAdapter(adapter);
        mMoviewList.setItemAnimator(new DefaultItemAnimator());
    }

    public void setDummyData(){
        ArrayList<Movie> artists = new ArrayList<>();

        for (int i=0;i<10;i++){
            artists.add(new Movie("Artist" + i, "description" + i, "average" + i));
        }

        adapter.addAll(artists);
    }
}
