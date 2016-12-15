package com.be.msu.resto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.be.msu.resto.R;

/**
 * Created by TANKBHAI on 30-11-2016.
 */
public class FoodItemDetailFragment extends Fragment {

    private TextView mTxtCategoryName, mTxtItemName, mTxtRupees, mTxtDesc;
    private RatingBar mRatingBar;

    private String categoryName, itemName, rupees;
    private Float rating;
    private int itemCode;

    public FoodItemDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_details, container, false);

        categoryName = getArguments().getString("categoryName");
        itemName = getArguments().getString("itemName");
        rupees = getArguments().getString("Rupees");
        rating = getArguments().getFloat("Rating");

        mTxtCategoryName = (TextView) view.findViewById(R.id.category_name);
        mTxtItemName = (TextView) view.findViewById(R.id.item_name);
        mTxtRupees = (TextView) view.findViewById(R.id.rupees);
        mRatingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        mTxtCategoryName.setText(categoryName);
        mTxtItemName.setText(itemName);
        mTxtRupees.setText(rupees);
        mRatingBar.setRating(rating);

        return view;
    }
}