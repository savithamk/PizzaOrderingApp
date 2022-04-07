package com.savithamaiya.pizzaapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.AppConstant;
import com.savithamaiya.pizzaapplication.R;
import com.savithamaiya.pizzaapplication.model.SizeList;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.ViewHolder> {
    private final Context context;
    private final List<SizeList> data;
    private String from;

    public SizeAdapter(Context context, List<SizeList> data, String from) {
        this.context = context;
        this.data=data;
        this.from = from;
    }

    @NonNull
    @Override
    public SizeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items_size, parent, false);
        return new SizeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SizeAdapter.ViewHolder holder, int position) {
      holder.name.setText(data.get(holder.getAdapterPosition()).getName());
      holder.price.setText("$".concat(data.get(holder.getAdapterPosition()).getPrice().toString()));
        holder.name.setSelected(data.get(holder.getAdapterPosition()).getSelected());
        holder.price.setSelected(data.get(holder.getAdapterPosition()).getSelected());
        holder.outer.setSelected(data.get(holder.getAdapterPosition()).getSelected());

                holder.itemView.setOnClickListener(view ->{
                    unselectedAll(holder.getAdapterPosition());
                    if (from.equals("Crust")){
                        AppConstant.cartModel
                                .setExtraPrice(data.get(holder
                                        .getAdapterPosition())
                                        .getPrice());
                    }else {
                        AppConstant.cartModel
                                .setPrice(data.get(holder
                                        .getAdapterPosition())
                                        .getPrice());
                    }
                });

    }

    private void unselectedAll(int adapterPosition) {
        for (int a = 0; a<data.size(); a++ ){
            if(data.get(a).getSelected()){
                data.get(a).setSelected(false);
                notifyItemChanged(a);
            }
        }
        data.get(adapterPosition).setSelected(true);
        notifyItemChanged(adapterPosition);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        LinearLayout outer;
        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            price = view.findViewById(R.id.price);
            outer = view.findViewById(R.id.outer);
        }
    }
}
