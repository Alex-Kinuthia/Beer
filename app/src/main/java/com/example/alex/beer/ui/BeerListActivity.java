package com.example.alex.beer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alex.beer.R;

public class BeerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_list_item);
    }
}
