package com.example.alex.beer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;
import com.example.alex.beer.services.BeerService;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;

public class BeersActivity extends AppCompatActivity {
    public static final String TAG = BeersActivity.class.getSimpleName();


    @Bind(R.id.liquorEditText)
    EditText mLiquorTextView;
    @Bind(R.id.ListView)
    ListView mListView;
//
//    private String[] beers = new String[] {"Sweet Hereafter", "Cricket", "Hawthorne Fish House", "Viking Soul Food",
//            "Red Square", "Horse Brass", "Dick's Kitchen", "Taco Bell", "Me Kha Noodle Bar",
//            "La Bonita Taqueria", "Smokehouse Tavern", "Pembiche", "Kay's Bar", "Gnarly Grey", "Slappy Cakes", "Mi Mero Mole" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, beers);
//        mListView.setAdapter(adapter);
//
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String beer = ((TextView)view).getText().toString();
//                Toast.makeText(BeersActivity.this, beer, Toast.LENGTH_LONG).show();
//            }
//        });
//
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        mLiquorTextView.setText("Here are all the beers: " + name);

        getBeers(name);
    }

    private void getBeers(String name) {
        final BeerService beerService = new BeerService();

        beerService.findBeers(name, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mBeers = beerService.processResults(response);

                BeersActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] restaurantNames = new String[mBeers.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mBeers.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(BeersActivity.this,
                                android.R.layout.simple_list_item_1, beerNames);
                        mListView.setAdapter(adapter);

                        for (Beer beer : mBeers) {
                            Log.d(TAG, "Id: " + beer.getId());
                            Log.d(TAG, "Name: " + beer.getName());
                            Log.d(TAG, "Abv: " + beer.getAbv());
                            Log.d(TAG, "StyleId: " + beer.getStyleId());
                            Log.d(TAG, "Status: " + beer.getStatus());
                            Log.d(TAG, "Description: " + beer.getDescription());

                        }
                    }
                });
            }
        });
    }
}