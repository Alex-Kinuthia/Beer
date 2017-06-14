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



public class BeerDetailFragment extends Fragment {
    @Bind(R.id.beerNameTextView) TextView mNameLabel;
    @Bind(R.id.beerIdTextView) TextView mIdLabel;
    @Bind(R.id.beerTypeTextView) TextView mTypeLabel;
    @Bind(R.id.beerIsAlcoholicTextView) TextView mIsAlcoholicLabel;
    @Bind(R.id.beerDescriptionTextView) TextView mDescriptionLabel;
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

        mNameLabel.setText(mBeer.getName());
        mIdLabel.setText(mBeer.getId());
        mTypeLabel.setText(mBeer.getType());
        mIsAlcoholicLabel.setText(mBeer.getIsAlcoholic());
        mDescriptionLabel.setText(mBeer.getDescription());



        return view;
    }



    }