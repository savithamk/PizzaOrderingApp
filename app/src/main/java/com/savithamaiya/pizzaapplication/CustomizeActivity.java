package com.savithamaiya.pizzaapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.savithamaiya.pizzaapplication.adapter.SauceAdapter;
import com.savithamaiya.pizzaapplication.adapter.SizeAdapter;
import com.savithamaiya.pizzaapplication.model.SizeList;

import java.util.ArrayList;
import java.util.List;

public class CustomizeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout
                .activity_customize);
        AppCompatImageView back  =  findViewById(R.id.back);
        RecyclerView size  =  findViewById(R.id.size);
        RecyclerView crust  =  findViewById(R.id.crust);
        RecyclerView sauce  =  findViewById(R.id.sauce);

        AppCompatButton next  =  findViewById(R.id.next);
        RecyclerView choosetoppings  =  findViewById(R.id.choosetoppings);
        back.setOnClickListener(view -> onBackPressed());
        size.setAdapter(new SizeAdapter(this,getSize(),"Size"));
        crust.setAdapter(new SizeAdapter(this,getCrust(),"Crust"));
        sauce.setAdapter(new SauceAdapter(this,getSauce()));
        choosetoppings.setAdapter(new SauceAdapter(this,getChooseToppings()));
        next.setOnClickListener(view -> {
            AppConstant.cartList.add(AppConstant.cartModel);
            startActivity(new Intent(CustomizeActivity.this, CartActivity.class)) ;
            finish();

        });
    }

    private List<SizeList> getChooseToppings() {
        List<SizeList> size =new ArrayList<>();
        size.add(new SizeList("Pineapple",0.0));
        size.add(new SizeList("Jalapenos",0.0));
        size.add(new SizeList("Sweet Corn",0.0));
        size.add(new SizeList("Pepperoni",0.0));
        size.add(new SizeList("Red Onions",0.0));
        size.add(new SizeList("BBQ Chicken",0.0));

        size.add(new SizeList("Tuna",0.0));
        size.add(new SizeList("Tomatoes",0.0));
        size.add(new SizeList("Paneer",0.0));
        return  size;
    }

    private List<SizeList> getSauce() {
        List<SizeList> size =new ArrayList<>();
        size.add(new SizeList("BBQ",0.0));
        size.add(new SizeList("Tomato",0.0));
        size.add(new SizeList("Creamy Garlic",0.0));
        return  size;
    }

    private List<SizeList> getCrust() {
        List<SizeList> size =new ArrayList<>();
        size.add(new SizeList("Classic Crust",0.0));
        size.add(new SizeList("Thin Crust",0.99));
        return  size;
    }

    private List<SizeList> getSize() {
        List<SizeList> size =new ArrayList<>();
        size.add(new SizeList("Small",5.99));
        size.add(new SizeList("Medium",11.99));
        size.add(new SizeList("Large",13.99));
        size.add(new SizeList("X-Large",15.99));
        return  size;
    }


}
