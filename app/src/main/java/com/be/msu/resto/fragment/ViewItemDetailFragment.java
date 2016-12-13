package com.be.msu.resto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.be.msu.resto.R;

/**
 * Created by TANKBHAI on 30-11-2016.
 */
public class ViewItemDetailFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView mCategoryName, mItemName, mRupees, mDesc;
    private RatingBar mRatingBar;

    private String categoryName, itemName, rupees;
    private Float rating;
    private int itemCode;

    public ViewItemDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_details, container, false);

        categoryName = getArguments().getString("categoryName");
        itemName = getArguments().getString("itemName");
        rupees = getArguments().getString("Rupees");
        rating = getArguments().getFloat("Rating");

        mCategoryName = (TextView) view.findViewById(R.id.category_name);
        mItemName = (TextView) view.findViewById(R.id.item_name);
        mRupees = (TextView) view.findViewById(R.id.rupees);
        mRatingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        mCategoryName.setText(categoryName);
        mItemName.setText(itemName);
        mRupees.setText(rupees);
        mRatingBar.setRating(rating);

        return view;
    }
}