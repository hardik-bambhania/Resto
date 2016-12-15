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
import com.be.msu.resto.adapter.FoodItemCategoryAdapter;
import com.be.msu.resto.model.MenuCategory;

import java.util.ArrayList;
import java.util.List;


public class FoodMenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FoodItemCategoryAdapter mAdapter;
    private List<MenuCategory> list = new ArrayList<>();
    public CardView cardView;

    public FoodMenuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_menu, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_food_menu);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new FoodItemCategoryAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareCategoryList();
        Toast.makeText(getContext(), "count=" + mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();

        return view;
    }

    /**
     * This method is used to create dummy food category list
     */

    private void prepareCategoryList() {
        MenuCategory gujrati = new MenuCategory();
        gujrati.setImage(R.mipmap.img_login_background2);
        gujrati.setmCategory("" + getText(R.string.gujarati));
        list.add(gujrati);

        MenuCategory punjabi = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("" + getText(R.string.punjabi));
        list.add(punjabi);

        MenuCategory chinese = new MenuCategory();
        chinese.setImage(R.mipmap.img_login_background2);
        chinese.setmCategory("" + getText(R.string.chinese));
        list.add(chinese);

        MenuCategory pizza = new MenuCategory();
        pizza.setImage(R.mipmap.img_login_background2);
        pizza.setmCategory("" + getText(R.string.pizza));
        list.add(pizza);

    }
}
