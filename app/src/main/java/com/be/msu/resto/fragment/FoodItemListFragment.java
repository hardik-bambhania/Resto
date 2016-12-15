package com.be.msu.resto.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.be.msu.resto.R;
import com.be.msu.resto.adapter.FoodItemListAdapter;
import com.be.msu.resto.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TANKBHAI on 30-11-2016.
 */
public class FoodItemListFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FoodItemListAdapter mAdapter;
    private List<MenuItem> list = new ArrayList<>();
    public CardView cardView;
    public int categoryCode;
    public Bundle bundle;
    public String categoryName = "";

    public FoodItemListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_menu, container, false);


        categoryCode = getArguments().getInt("categoryCode");

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_food_menu);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FoodItemListAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareItemList();
        Toast.makeText(getContext(), "code=" + categoryCode, Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(), "count=" + mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
        cardView = (CardView) view.findViewById(R.id.cardView_menu_items);

        return view;
    }

    /**
     * This method is used to create dummy food item list based on selected food category
     */
    private void prepareItemList() {
        switch (categoryCode) {
            case 1:
                prepareGujaratiList();
                break;
            case 2:
                preparePunjabiList();
                break;
        }
    }

    private void prepareGujaratiList() {
        MenuItem guj1 = new MenuItem();
        guj1.setImage(R.mipmap.img_login_background2);
        guj1.setCategory("" + getText(R.string.gujarati));
        guj1.setName("" + getText(R.string.masala_bhindi));
        guj1.setPrice(80);
        list.add(guj1);
    }

    private void preparePunjabiList() {
        MenuItem punjabi1 = new MenuItem();
        punjabi1.setImage(R.mipmap.img_login_background2);
        punjabi1.setCategory("" + getText(R.string.punjabi));
        punjabi1.setName("" + getText(R.string.paneer_angara));
        punjabi1.setPrice(180);
        list.add(punjabi1);

        MenuItem punjabi2 = new MenuItem();
        punjabi2.setImage(R.mipmap.img_login_background2);
        punjabi2.setCategory("" + getText(R.string.punjabi));
        punjabi2.setName("" + getText(R.string.paneer_tikka_masala));
        punjabi2.setPrice(120);
        list.add(punjabi2);
    }
}

