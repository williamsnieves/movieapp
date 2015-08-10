package com.example.willians.movieapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.example.willians.movieapp.MainActivity;
import com.example.willians.movieapp.R;
import com.example.willians.movieapp.rest.MovieListApiAdapter;
import com.example.willians.movieapp.rest.models.AuthorIdResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by willians on 09/08/15.
 */
public class AuthorFragment extends Fragment implements Callback<AuthorIdResponse> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivity activity = (MainActivity)getActivity();

        String author = activity.getAuthorName();

        /*if(author != null)
            Toast.makeText(getActivity(), "FRAGMENT ARG " + author, Toast.LENGTH_SHORT).show();*/

        if(author != null){
            MovieListApiAdapter.getApiService()
                    .getAuthorId(author, this);
        }
    }

    @Override
    public void success(AuthorIdResponse authorIdResponse, Response response) {
        Log.e("success fragmentauthor", authorIdResponse.getAuthorMovieId().toString());

        MovieListFragment fragmentMovie = new MovieListFragment();

        Bundle bundle = new Bundle();

        bundle.putInt("authorId", authorIdResponse.getAuthorMovieId());

        fragmentMovie.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .add(R.id.main_container, fragmentMovie)
                .commit();


    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }
}
