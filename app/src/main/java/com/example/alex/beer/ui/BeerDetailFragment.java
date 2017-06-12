package com.example.alex.beer.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;
import com.squareup.picasso.Picasso;


import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;



public class BeerDetailFragment extends Fragment {
    @Bind(R.id.beerImageUrlTextView) ImageView mImageUrlLabel;
    @Bind(R.id.beerNameTextView) TextView mNameLabel;
    @Bind(R.id.beerStyleIdTextView) TextView mStyleIdLabel;
    @Bind(R.id.beerAbvTextView) TextView mAbvLabel;
    @Bind(R.id.beerStatusTextView) TextView mStatusLabel;
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
        mStyleIdLabel.setText(mBeer.getStyleId());
        mAbvLabel.setText(mBeer.getAbv());
        mStatusLabel.setText(mBeer.getStatus());
        mDescriptionLabel.setText(mBeer.getDescription());

//        mCreateDateLabel.setText(mBeer.getCreateDate());
//        mUpdateDateLabel.setText(mBeer.getUpdateDate());
//        msaveBeerButton.setText(mBeer.getBeerButton());



        return view;
    }
    }