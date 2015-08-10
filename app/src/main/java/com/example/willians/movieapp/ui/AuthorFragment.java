package com.example.willians.movieapp.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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

        //get context activity to allow access from its methods
        MainActivity activity = (MainActivity)getActivity();

        //variable to set author name value from the activity getter method
        String author = activity.getAuthorName();

        /*if(author != null)
            Toast.makeText(getActivity(), "FRAGMENT ARG " + author, Toast.LENGTH_SHORT).show();*/

        //Condition to call api service to start a request to get an author id
        if(author != null){
            MovieListApiAdapter.getApiService()
                    .getAuthorId(author, this);
        }
    }

    @Override
    public void success(AuthorIdResponse authorIdResponse, Response response) {

        //this create an instance of Movielist fragment
        MovieListFragment fragmentMovie = new MovieListFragment();
        //this get an instance of bundle class
        Bundle bundle = new Bundle();
        //this set an argument to use in other fragment
        bundle.putInt("authorId", authorIdResponse.getAuthorMovieId());
        //this pass the argument to fragment
        fragmentMovie.setArguments(bundle);

        //get framelayout from activity
        Fragment frag = getActivity().getSupportFragmentManager().findFragmentById(R.id.main_container);
        //check if framelayout is null to add a fragment with recycler view list, else replace container fragment
        if(frag == null){
            addFragmentContent(fragmentMovie);
        }else{
            updateFragmentContent(fragmentMovie);
        }

    }

    @Override
    public void failure(RetrofitError error) {
        //show errors if exists
        error.printStackTrace();
    }


    //this method add a Moviefragment to main container
    private void addFragmentContent(MovieListFragment fragmentMovie){
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .add(R.id.main_container, fragmentMovie)
                .commit();
    }


    //this method replace a fragment in the main container
    private void updateFragmentContent(MovieListFragment fragmentMovie){
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .replace(R.id.main_container, fragmentMovie)
                .commit();
    }
}
