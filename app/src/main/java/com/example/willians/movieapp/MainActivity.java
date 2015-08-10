package com.example.willians.movieapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.willians.movieapp.ui.AuthorFragment;

public class MainActivity extends AppCompatActivity {

    //This variable allow to create a TextView element to get Author's name
    TextView authorInput;

    //this private variable is to set the author name
    private String authorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    //this method is trigger when we touch the search buttom
    public void searchActor(View v){

        //I set this variable with the inputElement from layout
        authorInput = (TextView)findViewById(R.id.name_actor);

        //this a setter method for authorName variable
        setAuthorName(authorInput.getText().toString());

        //This is to create a fragment manager to add a new fragment inside a framelayout
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                //.add(R.id.main_container, new MovieListFragment())
                .add(R.id.first_fragment, new AuthorFragment())
                .commit();

        //this clean the input Element from author
        authorInput.setText("");
        //THIS METHOD ALLOW TO CLOSE VIRTUAL KEYBOARD
        hideKeyboard();


    }

    //retrive author name value
    public String getAuthorName() {
        return authorName;
    }


    //set author name value
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        //if(view != null){
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            //inputManager.hideSoftInputFromInputMethod(getWindow().getAttributes().token, 0);
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        //}
    }




}
