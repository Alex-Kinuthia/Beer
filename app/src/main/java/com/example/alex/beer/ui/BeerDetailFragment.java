package com.example.alex.beer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.beer.Constants;
import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;



public class BeerDetailFragment extends Fragment implements View.OnClickListener {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    @Bind(R.id.beernameTextView) TextView mnameLabel;
    @Bind(R.id.beerwineryTextView) TextView mwineryLabel;
    @Bind(R.id.beervarietalTextView) TextView mvarietalLabel;
    @Bind(R.id.beerpriceTextView) TextView mpriceLabel;
    @Bind(R.id.beervintageTextView) TextView mvintageLabel;
    @Bind(R.id.beerImageView) TextView mimageLabel;
    @Bind(R.id.beerlinkTextView) TextView mlinkLabel;

    @Bind(R.id.saveBeerButton) TextView msaveBeerButton;

    private Beer mBeer;

    public static BeerDetailFragment newInstance(Beer beer) {
        BeerDetailFragment beerDetailFragment = new BeerDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("beer", Parcels.wrap(beer));
        beerDetailFragment.setArguments(args);
        return beerDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeer = Parcels.unwrap(getArguments().getParcelable("beer"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer_detail, container, false);
        ButterKnife.bind(this, view);

//        Picasso.with(view.getContext()).load(mBeer.getImageUrl()).into(mImageUrlLabel);

        mnameLabel.setText(mBeer.getName());
       mwineryLabel.setText(mBeer.getWinery());
        mvarietalLabel.setText(mBeer.getVarietal());
        mpriceLabel.setText(mBeer.getPrice());
        mvintageLabel.setText(mBeer.getVintage());
        mimageLabel.setText(mBeer.getImage());
        mlinkLabel.setText(mBeer.getLink());


        msaveBeerButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == msaveBeerButton) {
            DatabaseReference beerRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_BEERS);
            beerRef.push().setValue(mBeer);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
    }