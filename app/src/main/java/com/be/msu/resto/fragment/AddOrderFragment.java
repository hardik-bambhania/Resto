package com.be.msu.resto.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.be.msu.resto.R;
import com.be.msu.resto.adapter.AddOrderAdapter;
import com.be.msu.resto.model.Order;

import java.util.ArrayList;

public class AddOrderFragment extends Fragment {

    RecyclerView mRecyclerItems;
    AddOrderAdapter mAdapter;

    public AddOrderFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_order, container, false);
        mRecyclerItems = (RecyclerView) view.findViewById(R.id.recycler_add_order_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerItems.setLayoutManager(linearLayoutManager);

        mAdapter = new AddOrderAdapter(getdummyList());
        mRecyclerItems.setAdapter(mAdapter);

        return view;
    }


    private ArrayList<Order> getdummyList() {
        ArrayList<Order> list = new ArrayList<>();
        Order order = new Order();
        order.setId(1);
        order.setNumberOfItem(1);
        order.setVegetarian(true);
        list.add(order);

        Order order1 = new Order();
        order1.setId(1);
        order1.setNumberOfItem(1);
        order1.setVegetarian(true);
        list.add(order1);


        return list;
    }

}
