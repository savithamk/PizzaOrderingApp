package com.savithamaiya.pizzaapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.AppConstant;
import com.savithamaiya.pizzaapplication.CustomizeActivity;
import com.savithamaiya.pizzaapplication.R;
import com.savithamaiya.pizzaapplication.model.VegList;

import java.util.List;

public class TopItemListAdapter extends RecyclerView.Adapter<TopItemListAdapter.ViewHolder> {

    private final Context context;
    private final List<VegList> data;

    public TopItemListAdapter(Context context, List<VegList> data) {
        this.context = context;
        this.data=data;
    }
    @NonNull
    @Override
    public TopItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_list, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull TopItemListAdapter.ViewHolder holder, int position) {
        holder.image.setImageDrawable(context
                .getDrawable(data.get(holder.getAdapterPosition()).getImage()));

        holder.itemView.setOnClickListener(view ->{
            AppConstant.cartModel.setImage(data.get(holder.getAdapterPosition()).getImage());
            AppConstant.cartModel.setName(data.get(holder.getAdapterPosition()).getName());

            context.startActivity(new Intent(context, CustomizeActivity.class)) ;
                    }
        );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        public ViewHolder(View view) {
            super(view);
            image= view.findViewById(R.id.image);

        }
    }
}
