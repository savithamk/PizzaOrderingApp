package com.savithamaiya.pizzaapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.adapter.CartListAdapter;

public class CartActivity extends AppCompatActivity implements CartListAdapter.RemoveItem {
    AppCompatImageView back;
    AppCompatButton checkout;
    RecyclerView cartItems;
    NestedScrollView scrollable;
    LinearLayout data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        back  =  findViewById(R.id.back);
        checkout  =  findViewById(R.id.checkout);
        cartItems  =  findViewById(R.id.cartItems);
        scrollable  =  findViewById(R.id.scrollable);
        data  =  findViewById(R.id.data);

        back.setOnClickListener(view -> onBackPressed());

        if(AppConstant.cartList.isEmpty()){
            cartItems.setVisibility(View.GONE);
            checkout.setVisibility(View.GONE);
            scrollable.setVisibility(View.GONE);
            data.setVisibility(View.VISIBLE);
        }else {
            cartItems.setVisibility(View.VISIBLE);
            checkout.setVisibility(View.VISIBLE);
            scrollable.setVisibility(View.VISIBLE);
            data.setVisibility(View.GONE);
            cartItems.setAdapter(new CartListAdapter(this,AppConstant.cartList,this));
        }


    }

    @Override
    public void onRemove() {
        if(AppConstant.cartList.isEmpty()){
            cartItems.setVisibility(View.GONE);
            checkout.setVisibility(View.GONE);
            scrollable.setVisibility(View.GONE);
            data.setVisibility(View.VISIBLE);
        }else {
            cartItems.setVisibility(View.VISIBLE);
            checkout.setVisibility(View.VISIBLE);
            scrollable.setVisibility(View.VISIBLE);
            data.setVisibility(View.GONE);
        }
    }
}
