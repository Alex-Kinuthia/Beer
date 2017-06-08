package com.example.alex.beer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alex.beer.models.Beer;
import com.example.alex.beer.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alex on 6/7/17.
 */

public class BeerListAdapter extends RecyclerView.Adapter<BeerListAdapter.BeerViewHolder> {
    private ArrayList<Beer> mBeers = new ArrayList<>();
    private Context mContext;

    public BeerListAdapter(Context context, ArrayList<Beer> beers) {
        mContext = context;
        mBeers = beers;
    }

    @Override
    public BeerListAdapter.BeerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_list_item, parent, false);
        BeerViewHolder viewHolder = new BeerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeerListAdapter.BeerViewHolder holder, int position) {
        holder.bindBeer(mBeers.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }


    public class BeerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.beerIdTextView) TextView mIdTextView;
        @Bind(R.id.beerNameTextView) TextView mNameTextView;
        @Bind(R.id.beerLabelTextView) TextView mLabelTextView;
        @Bind(R.id.beerAbvTextView) TextView mAbvTextView;
        @Bind(R.id.beerStyleIdTextView) TextView mStyleIdTextView;



        private Context mContext;

        public BeerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBeer(Beer beer) {
            mIdTextView.setText(beer.getId());
            mNameTextView.setText(beer.getName());
            mLabelTextView.setText(beer.getLabel());
            mAbvTextView.setText(beer.getAbv());
            mStyleIdTextView.setText(beer.getStyleId());




        }
    }
}
