package com.example.willians.movieapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willians.movieapp.R;

/**
 * Created by willians on 05/08/15.
 */
public class MovieListFragment extends Fragment {

    private RecyclerView mMoviewList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_movie_list, container, false);

        mMoviewList = (RecyclerView)fragment.findViewById(R.id.movie_list);

        return fragment;
    }
}
