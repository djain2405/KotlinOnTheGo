package com.example.divya.kotlinlearningjava.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.divya.kotlinlearningjava.R;
import com.example.divya.kotlinlearningjava.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private static final String LOG_TAG = "CategoryAdapter";
    List<Category> categories;
    public CategoryAdapter(List<Category> list) {
        categories = list;
        Log.d(LOG_TAG, "CategoryAdapter() size" + categories.size());
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.category_item, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Log.d(LOG_TAG, "onBindViewHolder() position" + categories.get(position).getTitle());
        holder.titleTextView.setText(categories.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        Log.d(LOG_TAG, "getItemCount() size" + categories.size());
        return categories.size();

    }

        class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
