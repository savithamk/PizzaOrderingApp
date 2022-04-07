package com.savithamaiya.pizzaapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.AppConstant;
import com.savithamaiya.pizzaapplication.R;
import com.savithamaiya.pizzaapplication.model.SizeList;

import java.util.List;

public class SauceAdapter extends RecyclerView.Adapter<SauceAdapter.ViewHolder> {
    private final Context context;
    private final List<SizeList> data;

    public SauceAdapter(Context context, List<SizeList> data) {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public SauceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_sauce, parent, false);
        return new SauceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SauceAdapter.ViewHolder holder, int position) {
        holder.name.setText(data.get(holder.getAdapterPosition()).getName());
        holder.name.setSelected(data.get(holder.getAdapterPosition()).getSelected());
        holder.itemView.setOnClickListener(view -> {
            unselectedAll(holder.getAdapterPosition());
            AppConstant.cartModel.getItems().add(
                    data.get(holder
                            .getAdapterPosition())
                            .getName()
            );
        });


    }

    private void unselectedAll(int adapterPosition) {

        data.get(adapterPosition).setSelected(
                !data.get(adapterPosition).getSelected()
        );
        notifyItemChanged(adapterPosition);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
        }
    }
}
