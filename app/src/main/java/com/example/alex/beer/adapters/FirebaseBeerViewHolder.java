package com.example.alex.beer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alex.beer.Constants;
import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;
import com.example.alex.beer.ui.BeerDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by alex on 6/16/17.
 */

public class FirebaseBeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    View mView;
    Context mContext;

    public FirebaseBeerViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindBeer(Beer beer) {
        TextView nameTextView = (TextView) mView.findViewById(R.id.beerNameTextView);
        TextView idTextView = (TextView) mView.findViewById(R.id.beerIdTextView);
        TextView typeTextView = (TextView) mView.findViewById(R.id.beerTypeTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.beerDescriptionTextView);

    }

    @Override
    public void onClick(View view) {
        final ArrayList<Beer> beers = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_BEERS);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    beers.add(snapshot.getValue(Beer.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, BeerDetailActivity.class);
                intent.putExtra("name", itemPosition + "");
//                intent.putExtra("restaurants", Parcels.wrap(restaurants));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}