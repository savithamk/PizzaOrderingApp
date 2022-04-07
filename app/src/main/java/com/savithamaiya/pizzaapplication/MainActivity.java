package com.savithamaiya.pizzaapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.adapter.ItemListAdapter;
import com.savithamaiya.pizzaapplication.adapter.TopItemListAdapter;
import com.savithamaiya.pizzaapplication.model.VegList;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        RecyclerView recyclerView = findViewById(R.id.listTop);
        AppCompatImageView cart = findViewById(R.id.cart);
        recyclerView.setAdapter(new TopItemListAdapter(this,getVegNonVegList()));


        RecyclerView recyclerViewvegLIst = findViewById(R.id.vegLIst);
        recyclerViewvegLIst.setAdapter(new ItemListAdapter(this,getVegList()));
         RecyclerView recyclerViewnonvegLIst = findViewById(R.id.nonvegLIst);
        recyclerViewnonvegLIst.setAdapter(new ItemListAdapter(this,getNonVegList()));
        cart.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));


    }

    private List<VegList> getVegList() {
        ArrayList<VegList> vegLists = new ArrayList<>();
        vegLists.add(new VegList(R.drawable.tangy,"Tangy Tomato"));
        vegLists.add(new VegList(R.drawable.mushrum,"Mushroom"));
        vegLists.add(new VegList(R.drawable.garden,"Garden Veggie"));
        vegLists.add(new VegList(R.drawable.mushrum,"Mushroom"));
        vegLists.add(new VegList(R.drawable.tangy,"Tangy Tomato"));
        return vegLists;
    }
 private List<VegList> getNonVegList() {
        ArrayList<VegList> vegLists = new ArrayList<>();
        vegLists.add(new VegList(R.drawable.meetsupreme,"Meet Supreme"));
        vegLists.add(new VegList(R.drawable.cheesychiken,"Cheesy Chicken"));
        vegLists.add(new VegList(R.drawable.pepernoe,"Pepperoni"));
        vegLists.add(new VegList(R.drawable.cheesychiken,"Cheesy Chicken"));
        vegLists.add(new VegList(R.drawable.meetsupreme,"Meet Supreme"));
        return vegLists;
    }


    private List<VegList> getVegNonVegList() {
        ArrayList<VegList> vegLists = new ArrayList<>();
        vegLists.addAll(getVegList());
        vegLists.addAll(getNonVegList());
        return vegLists;
    }

}
