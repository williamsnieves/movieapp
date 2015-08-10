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
import com.example.willians.movieapp.rest.MovieListApiAdapter;
import com.example.willians.movieapp.rest.models.MovieListResponse;
import com.example.willians.movieapp.ui.adapters.MovieListAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by willians on 05/08/15.
 */
public class MovieListFragment extends Fragment implements Callback<MovieListResponse> {

    private RecyclerView mMoviewList;
    private MovieListAdapter adapter;

    private int authorId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get an instance from Movie List adapter
        adapter = new MovieListAdapter(getActivity());
        //get author id value from fragment arguments
        Integer idAuthor = getArguments().getInt("authorId");

        //call to api service to get movie array list passing authorid as parameter
        MovieListApiAdapter.getApiService()
                .getMovieList(idAuthor, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //this allow to inflate view to this fragment
        View fragment = inflater.inflate(R.layout.fragment_movie_list, container, false);
        //call recycler view object from id
        mMoviewList = (RecyclerView)fragment.findViewById(R.id.movie_list);
        //call method to config recycler view with adapter
        setupMovieList();

        //return fragment view
        return fragment;
    }

    //method config recycler view
    public void setupMovieList(){

        mMoviewList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMoviewList.setAdapter(adapter);
        mMoviewList.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void success(MovieListResponse movieListResponse, Response response) {

        //add movie array to adapter from server response
        adapter.addAll(movieListResponse.getMovies());
    }

    @Override
    public void failure(RetrofitError error) {
        //show response error
        error.printStackTrace();
    }

}
