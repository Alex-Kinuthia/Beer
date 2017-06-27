package com.example.alex.beer.util;

/**
 * Created by alex on 6/16/17.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}