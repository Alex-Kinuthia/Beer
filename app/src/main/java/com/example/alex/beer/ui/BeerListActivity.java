package com.example.alex.beer.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.alex.beer.Constants;
import com.example.alex.beer.R;
import com.example.alex.beer.adapters.BeerListAdapter;
import com.example.alex.beer.models.Beer;
import com.example.alex.beer.services.BeerService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.R.attr.name;

public class BeerListActivity extends AppCompatActivity {

    public static final String TAG = BeerListActivity.class.getSimpleName() ;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private BeerListAdapter mAdapter;

    public ArrayList<Beer> mBeers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        getBreweries(name);
    }

    private void getBreweries(String name) {
        final BeerService beerService = new BeerService();
        beerService.findBeers(name, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {

                mBeers = BeerService.processResults(response);

                BeerListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new BeerListAdapter(getApplicationContext(), mBeers);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BeerListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });


            }
        });
    }
}