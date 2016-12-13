package com.be.msu.resto.bl;

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
import android.widget.RatingBar;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.fragment.ViewItemDetailFragment;
import com.be.msu.resto.model.MenuItem;

import java.util.List;

/**
 * Created by TANKBHAI on 30-11-2016.
 */
public class ViewMenuItemAdapter extends RecyclerView.Adapter<ViewMenuItemAdapter.ViewHolder> {

    List<MenuItem> list;
    public Bundle bundle;
    public MenuItem menuItem;

    public ViewMenuItemAdapter(List<MenuItem> menuItemList) {
        super();
        list = menuItemList;
    }

    private final View.OnClickListener mItemNameClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            ViewItemDetailFragment viewItemDetailFragment = new ViewItemDetailFragment();
            final FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
            final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_container, viewItemDetailFragment);
            fragmentTransaction.commit();

            bundle = new Bundle();
            menuItem = new MenuItem();


            TextView itemName = (TextView) ((CardView) v).findViewById(R.id.item_name);
            TextView rupees = (TextView) ((CardView) v).findViewById(R.id.rupees);
            RatingBar ratingBar = (RatingBar) ((CardView) v).findViewById(R.id.ratingBar);

            bundle.putString("categoryName", (list.get(0)).getCategory());
            bundle.putString("itemName", itemName.getText().toString());
            bundle.putString("Rupees", rupees.getText().toString());
            bundle.putFloat("Rating", ratingBar.getRating());

            viewItemDetailFragment.setArguments(bundle);
        }
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_items, parent, false);
        v.setOnClickListener(mItemNameClickListener);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuItem mMenuItem = list.get(position);
        holder.itemImage.setImageResource(mMenuItem.getImage());
        holder.itemName.setText(mMenuItem.getName());
        holder.itemRs.setText("" + mMenuItem.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public TextView itemRs;

        public ViewHolder(View view) {
            super(view);

            itemImage = (ImageView) view.findViewById(R.id.item_image);
            itemName = (TextView) view.findViewById(R.id.item_name);
            itemRs = (TextView) view.findViewById(R.id.rupees);
        }
    }
}
