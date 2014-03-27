package com.MobShop.app.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.MobShop.app.R;
import com.MobShop.app.models.Category;
import com.MobShop.app.util.download.ImageLoader;

import java.util.ArrayList;

public class GridViewContent extends BaseAdapter {

    public ArrayList<Category> categories;
    int loader = R.drawable.loader;
    ImageLoader imgLoader;
    private Context context;

    public GridViewContent(Context c, ArrayList<Category> data) {

        context = c;
        imgLoader = new ImageLoader(c);
        this.categories = data;

    }

    @Override
    public int getCount() {

        // TODO Auto-generated method stub
        return (categories.size());
    }

    @Override
    public Object getItem(int position) {

        return categories.get(position);
    }

    @Override
    public long getItemId(int arg0) {

        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category category = categories.get(position);
        if (convertView == null) {
            LayoutInflater li = LayoutInflater.from(context);
            convertView = li.inflate(R.layout.grid_view_row, null);
        }
        ImageView categoryImage = (ImageView) convertView.findViewById(R.id.imageGridViewContent);
        TextView categoryText = (TextView) convertView.findViewById(R.id.categoryGridViewContent);

        String URL = categories.get(position).getPhotoURL();
        if (URL.equals("null")) {
            categoryImage.setImageResource(R.drawable.ic_launcher);
        } else {
            imgLoader.SetImage(URL, loader, categoryImage);
        }
        categoryText.setText(category.getCategoryName());


        return convertView;
    }
}
