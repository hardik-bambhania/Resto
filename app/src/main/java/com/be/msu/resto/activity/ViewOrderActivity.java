package com.be.msu.resto.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.be.msu.resto.R;
import com.be.msu.resto.adapter.ViewOrderAdapter;
import com.be.msu.resto.model.Order;

import java.util.ArrayList;
import java.util.List;

public class ViewOrderActivity extends AppCompatActivity {

    private ListView mListView;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ViewOrderAdapter mAdapter;
    private List<Order> list = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        mListView = (ListView) findViewById(R.id.order_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_order);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ViewOrderAdapter(list);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        prepareData();

    }

    void prepareData() {
        String[] categoryList = {"Punjabi", "Gujarati"};

        Order order = new Order();
        order.setName("Rashmi");
        order.setTableNo(16);
        order.setCategoryList(categoryList);
        list.add(order);
    }
}
