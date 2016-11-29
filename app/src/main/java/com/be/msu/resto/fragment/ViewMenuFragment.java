package com.be.msu.resto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.be.msu.resto.R;
import com.be.msu.resto.bl.ViewMenuCardAdapter;
import com.be.msu.resto.model.MenuCategory;

import java.util.ArrayList;
import java.util.List;


public class ViewMenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ViewMenuCardAdapter mAdapter;
    private List<MenuCategory> list = new ArrayList<>();
    public ViewMenuFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_menu, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ViewMenuCardAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareCategoryList();

        return view;
    }

    public void prepareCategoryList() {
        MenuCategory gujrati = new MenuCategory();
        gujrati.setImage(R.mipmap.img_login_background2);
        gujrati.setmCategory("Gujarati");
        list.add(gujrati);

        MenuCategory punjabi = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("Punjabi");
        list.add(punjabi);

        MenuCategory chinese = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("Chinese");
        list.add(chinese);

        MenuCategory southIndian = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("South Indian");
        list.add(southIndian);

        MenuCategory fastFood = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("Fast Food");
        list.add(fastFood);

        MenuCategory soup = new MenuCategory();
        punjabi.setImage(R.mipmap.img_login_background2);
        punjabi.setmCategory("Soup");
        list.add(soup);


    }
}
