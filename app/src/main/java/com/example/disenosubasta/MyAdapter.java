package com.example.disenosubasta;


import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Category> mList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        protected TextView category;


        public MyViewHolder(View view) {
            super(view);
            this.category = (TextView) view.findViewById(R.id.category);
        }
    }

    public MyAdapter(ArrayList<Category> list) {
        this.mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_text, viewGroup, false);

        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewholder, int position) {

        viewholder.category.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        viewholder.category.setGravity(Gravity.CENTER);
        viewholder.category.setText(mList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}