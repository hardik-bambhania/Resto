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
import com.be.msu.resto.bl.ViewMenuItemAdapter;
import com.be.msu.resto.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TANKBHAI on 30-11-2016.
 */
public class ViewItemFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ViewMenuItemAdapter mAdapter;
    private List<MenuItem> list = new ArrayList<>();
    public CardView cardView;
    public int categoryCode;
    public Bundle bundle;
    public String categoryName = "";

    public ViewItemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_menu, container, false);


        categoryCode = getArguments().getInt("categoryCode");
        //categoryName = getArguments().getString("categoryName");

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new ViewMenuItemAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        prepareItemList();
        Toast.makeText(getContext(), "count=" + mAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
        cardView = (CardView) view.findViewById(R.id.cardView2);

        return view;
    }

    public void prepareItemList() {
        switch (categoryCode) {
            case 1:
                prepareGujaratiList();
                break;
            case 2:
                preparePunjabiList();
                break;
        }
    }

    public void prepareGujaratiList() {
        MenuItem guj1 = new MenuItem();
        guj1.setImage(R.mipmap.img_login_background2);
        guj1.setCategory("Gujarati");
        guj1.setName("Masala Bhindi");
        guj1.setPrice(80);
        list.add(guj1);
    }

    public void preparePunjabiList() {
        MenuItem punjabi1 = new MenuItem();
        punjabi1.setImage(R.mipmap.img_login_background2);
        punjabi1.setCategory("Punjabi");
        punjabi1.setName("Paneer Angara");
        punjabi1.setPrice(180);
        list.add(punjabi1);

        MenuItem punjabi2 = new MenuItem();
        punjabi2.setImage(R.mipmap.img_login_background2);
        punjabi2.setCategory("Punjabi");
        punjabi2.setName("Paneer Tikka Masala");
        punjabi2.setPrice(120);
        list.add(punjabi2);

        MenuItem punjabi3 = new MenuItem();
        punjabi3.setImage(R.mipmap.img_login_background2);
        punjabi3.setCategory("Punjabi2");
        punjabi3.setName("Paneer Tawa Masala");
        punjabi3.setPrice(140);
        list.add(punjabi3);

        MenuItem punjabi4 = new MenuItem();
        punjabi4.setImage(R.mipmap.img_login_background2);
        punjabi4.setCategory("Punjabi2");
        punjabi4.setName("Paneer Patiyala");
        punjabi4.setPrice(170);
        list.add(punjabi4);

        MenuItem punjabi5 = new MenuItem();
        punjabi5.setImage(R.mipmap.img_login_background2);
        punjabi5.setCategory("Punjabi2");
        punjabi5.setName("Paneer Bhurji");
        punjabi5.setPrice(140);
        list.add(punjabi5);
    }
}

