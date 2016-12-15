package com.be.msu.resto.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.fragment.FoodItemListFragment;
import com.be.msu.resto.model.MenuCategory;

import java.util.List;

/**
 * Created by TANKBHAI on 28-11-2016.
 */
public class FoodItemCategoryAdapter extends RecyclerView.Adapter<FoodItemCategoryAdapter.ViewHolder> {

    List<MenuCategory> list;
    public Bundle bundle;
    private static final String CATEGORY_CODE = "categoryCode";

    public FoodItemCategoryAdapter(List<MenuCategory> menuCategoryList) {
        super();
        list = menuCategoryList;
    }

    private final View.OnClickListener mCategoryNameClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            FoodItemListFragment foodItemListFragment = new FoodItemListFragment();
            final FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_container, foodItemListFragment);
            fragmentTransaction.commit();

            bundle = new Bundle();
            TextView categoryName = (TextView) ((CardView) v).findViewById(R.id.category_name);

            if ((categoryName.getText()).equals("Gujarati")) {
                bundle.putInt(CATEGORY_CODE, 1);
            } else if ((categoryName.getText()).equals("Punjabi")) {
                bundle.putInt(CATEGORY_CODE, 2);
            }
            foodItemListFragment.setArguments(bundle);
        }
    };
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_category, parent, false);

        v.setOnClickListener(mCategoryNameClickListener);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        MenuCategory mMenuCategory = list.get(position);
        holder.categoryImage.setImageResource(mMenuCategory.getImage());
        holder.categoryName.setText(mMenuCategory.getmCategory());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryImage;
        public TextView categoryName;

        public ViewHolder(View view) {
            super(view);

            categoryImage = (ImageView) view.findViewById(R.id.category_image);
            categoryName = (TextView) view.findViewById(R.id.category_name);

        }
    }
}
