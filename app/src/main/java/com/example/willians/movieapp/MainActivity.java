package com.example.willians.movieapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Toast;

import com.example.willians.movieapp.ui.MovieListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .add(R.id.main_container, new MovieListFragment())
                    .commit();
        }
    }


    public void searchActor(View v){
        Toast.makeText(this, "testing...", Toast.LENGTH_SHORT).show();
    }

}
