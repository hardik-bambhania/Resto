package com.be.msu.resto.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.model.Order;

import java.util.List;


public class ViewOrderAdapter extends RecyclerView.Adapter<ViewOrderAdapter.ViewHolder> {

    List<Order> list;
    private String[] orderList = {"Punjabi", "Chinese", "Soup", "Pizza", "Salad"};
    public Context mContext;
    private TextView mOrderCategory;

    public ViewOrderAdapter(List<Order> orderList) {
        super();
        list = orderList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_order_list, parent, false);
        mOrderCategory = (TextView) v.findViewById(R.id.order_category);
        // v.setOnClickListener(mItemNameClickListener);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list, parent, false);
        }
        // Lookup view for data population
        TextView orderCategory = (TextView) convertView.findViewById(R.id.order_category);

        return convertView;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Order mOrder = list.get(position);
        holder.name.setText(mOrder.getName());
        holder.tableNo.setText("" + mOrder.getTableNo());

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(mContext, R.layout.order_list, orderList);
        holder.categoryList.setAdapter(arrayAdapter);
        holder.categoryList.setDivider(mContext.getResources().getDrawable(android.R.color.transparent));


        int totalHeight = 0;
        for (int i = 0; i < orderList.length; i++) {
            View listItem = arrayAdapter.getView(i, null, holder.categoryList);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = holder.categoryList.getLayoutParams();
        params.height = totalHeight + (holder.categoryList.getDividerHeight() * (orderList.length - 1));
        holder.categoryList.setLayoutParams(params);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView tableNo;
        public ListView categoryList;

        ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.name);
            tableNo = (TextView) v.findViewById(R.id.table_no);
            categoryList = (ListView) v.findViewById(R.id.order_list);
        }
    }

}
