package com.example.alex.beer.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alex.beer.Constants;
import com.example.alex.beer.R;
import com.example.alex.beer.adapters.FirebaseBeerViewHolder;
import com.example.alex.beer.models.Beer;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedBeerListActivity extends AppCompatActivity {
    private DatabaseReference mBeerReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_beer);
        ButterKnife.bind(this);

        mBeerReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEERS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Beer, FirebaseBeerViewHolder>
                (Beer.class, R.layout.beer_list_item, FirebaseBeerViewHolder.class,
                        mBeerReference) {

            @Override
            protected void populateViewHolder(FirebaseBeerViewHolder viewHolder,
                                              Beer model, int position) {
                viewHolder.bindBeer(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}