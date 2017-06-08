package com.example.alex.beer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BeersActivity extends AppCompatActivity {

    @Bind(R.id.findLiquorsButton)
    Button mLiquorsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beers);
        ButterKnife.bind(this);
        mLiquorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BeersActivity.this, BeerListActivity.class);
                startActivity(intent);
            }
        });
    }
}
