package com.savithamaiya.pizzaapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.R;
import com.savithamaiya.pizzaapplication.model.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private final Context context;
    private final List<CartModel> data;
    private  RemoveItem removeItem;

    public CartListAdapter(Context context, List<CartModel> data, RemoveItem removeItem) {
        this.context = context;
        this.data=data;
        this.removeItem =  removeItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cart, parent, false);
        return new CartListAdapter.ViewHolder(view);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageDrawable(context
                .getDrawable(data.get(holder.getAdapterPosition()).getImage()));
        holder.name.setText(data.get(holder.getAdapterPosition()).getName());
        holder.quantitycount.setText(
                String.valueOf(data.get(holder.getAdapterPosition()).getQty()));

        ArrayList<String> addonList = new ArrayList<>(data.get(holder.getAdapterPosition()).getItems());
        holder.addon.setText(getAddon(addonList));

        holder.price.setText("$".concat(
                String.valueOf((data.get(holder.getAdapterPosition()).getPrice()
                        + data.get(holder.getAdapterPosition()).getExtraPrice()))));


        holder.qualitydecreasee.setOnClickListener(view -> {
            int qty = Integer.parseInt(holder.quantitycount.getText().toString());
            if(qty>1){
                int inc = qty-1;
                data.get(holder.getAdapterPosition()).setQty(inc);
                holder.quantitycount.setText(
                        String.valueOf(inc));
            }else {
                removeItem(holder.getAdapterPosition());
                removeItem.onRemove();
            }
        });

        holder.quantityincressed.setOnClickListener(view -> {
            int qty = Integer.parseInt(holder.quantitycount.getText().toString());
            if(qty<10){
                int inc = qty+1;
                data.get(holder.getAdapterPosition()).setQty(inc);
                holder.quantitycount.setText(
                        String.valueOf(inc));
            }
        });
    }

    private void removeItem(int adapterPosition) {
        data.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
        notifyItemRangeChanged(adapterPosition, data.size());
    }


    private String getAddon(ArrayList<String> items) {
        StringBuilder stringBuilder =  new StringBuilder();
        for (int a = 0; a< items.size(); a++){
            if (a !=items.size()-1){
                stringBuilder.append(items.get(a).concat(","));
            }else {
                stringBuilder.append(items.get(a));
            }
        }

        return  stringBuilder.toString();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface RemoveItem{
       void  onRemove();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        AppCompatImageView image;
        AppCompatImageView qualitydecreasee;
        AppCompatImageView quantityincressed;
        TextView price;
        TextView addon;
        AppCompatTextView quantitycount;
        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            image = view.findViewById(R.id.pizzaImage);
            price = view.findViewById(R.id.price);
            addon = view.findViewById(R.id.addon);
            quantitycount = view.findViewById(R.id.quantity_count);
            qualitydecreasee = view.findViewById(R.id.Quality_decreasee);
            quantityincressed = view.findViewById(R.id.Quantity_incressed);
        }
    }

}
