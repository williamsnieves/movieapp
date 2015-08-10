package com.example.willians.movieapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.willians.movieapp.ui.AuthorFragment;

public class MainActivity extends AppCompatActivity {

    TextView authorInput;

    private String authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    //.add(R.id.main_container, new MovieListFragment())
                    .add(R.id.frist_fragment, new AuthorFragment())
                    .commit();
        }*/
    }


    public void searchActor(View v){
        authorInput = (TextView)findViewById(R.id.name_actor);
        setAuthorName(authorInput.getText().toString());


        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .add(R.id.first_fragment, new AuthorFragment())
                .commit();


        /*FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .add(R.id.frist_fragment, new AuthorFragment())
                .commit();*/

        /*FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.main_container, new MovieListFragment())
                .commit();*/
        //Toast.makeText(this, authorInput.getText(), Toast.LENGTH_SHORT).show();

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
