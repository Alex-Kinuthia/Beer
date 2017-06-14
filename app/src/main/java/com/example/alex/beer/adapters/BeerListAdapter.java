package com.example.alex.beer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.beer.R;
import com.example.alex.beer.models.Beer;
import com.example.alex.beer.ui.BeerDetailActivity;
import com.example.alex.beer.ui.BeerDetailFragment;
import com.example.alex.beer.ui.BeerListActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by alex on 6/9/17.
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

    public class BeerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.beerNameTextView) TextView mNameTextView;
        @Bind(R.id.beerIdTextView) TextView mIdTextView;
        @Bind(R.id.beerTypeTextView) TextView mTypeTextView;


        private Context mContext;

        public BeerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }
        public void bindBeer(Beer beer) {

            mNameTextView.setText(beer.getName());
            mIdTextView.setText(beer.getId());
            mTypeTextView.setText(beer.getType());

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, BeerDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("beers", Parcels.wrap(mBeers));
            mContext.startActivity(intent);
        }
    }
}