package com.be.msu.resto.adapter;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.be.msu.resto.R;
import com.be.msu.resto.model.Order;

import java.util.ArrayList;


public class AddOrderAdapter extends RecyclerView.Adapter<AddOrderAdapter.NewOrderViewHolder> {

    ArrayList<Order> mOrderList = new ArrayList<>();

    public AddOrderAdapter(ArrayList<Order> list) {
        mOrderList = list;
    }

    @Override
    public NewOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_order_list_item, parent, false);
        return new NewOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewOrderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

    public class NewOrderViewHolder extends RecyclerView.ViewHolder {

        EditText mEdTxtItemName;
        EditText mEdTxtItemCategory;
        FloatingActionButton mFabAdd;
        FloatingActionButton mFabDelete;

        public NewOrderViewHolder(View itemView) {
            super(itemView);
            mEdTxtItemCategory = (EditText) itemView.findViewById(R.id.edtxt_food_category);
            mEdTxtItemName = (EditText) itemView.findViewById(R.id.edTxt_customer_name);
        }
    }
}
