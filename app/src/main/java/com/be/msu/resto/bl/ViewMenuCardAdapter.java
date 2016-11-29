package com.be.msu.resto.bl;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.be.msu.resto.R;
import com.be.msu.resto.model.MenuCategory;

import java.util.List;

/**
 * Created by TANKBHAI on 28-11-2016.
 */
public class ViewMenuCardAdapter extends RecyclerView.Adapter<ViewMenuCardAdapter.ViewHolder> {

    List<MenuCategory> list;

    public ViewMenuCardAdapter(List<MenuCategory> menuCategoryList) {
        super();
        //list = new ArrayList<MenuCategory>();
        list = menuCategoryList;
        /*for(int i=0;i<category.length;i++)
        {
            MenuCategory item =new MenuCategory();
            item.setmCategory(category[i]);
            item.setImage(image[i]);
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MenuCategory mMenuCategory = list.get(position);
        holder.categoryImage.setImageResource(mMenuCategory.getImage());
        holder.categoryName.setText(mMenuCategory.getmCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView categoryImage;
        public TextView categoryName;

        public ViewHolder(View view) {
            super(view);

            categoryImage = (ImageView) view.findViewById(R.id.category_image);
            categoryName = (TextView) view.findViewById(R.id.category_name);

        }
    }
}
