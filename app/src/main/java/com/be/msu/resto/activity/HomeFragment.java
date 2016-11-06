package com.be.msu.resto.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.model.Order;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private static final String TAG = HomeFragment.class.getName();
    private TextView mTxtEmptyOrder;
    private RecyclerView mRecyclerListOrder;
    private ArrayList<Order> mOrderList;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "--OnCreate(HomeFragment)--");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mTxtEmptyOrder = (TextView) view.findViewById(R.id.txt_no_order);
        mRecyclerListOrder = (RecyclerView) view.findViewById(R.id.recycler_running_order);

        setEmptyView();

        return view;
    }

    /**
     * Get list of running order
     *
     * @return running order list
     */
    private ArrayList<Order> getOrderList() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        return orderList;
    }

    /**
     * Needs to display empty view or order list
     */
    private void setEmptyView() {
        mOrderList = getOrderList();

        if (mOrderList.isEmpty() || mOrderList.size() <= 0) {
            mRecyclerListOrder.setVisibility(View.GONE);
            mTxtEmptyOrder.setVisibility(View.VISIBLE);
        } else {
            mRecyclerListOrder.setVisibility(View.VISIBLE);
            mTxtEmptyOrder.setVisibility(View.GONE);
        }
    }


}
