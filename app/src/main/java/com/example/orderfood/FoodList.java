package com.example.orderfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.orderfood.model.Category;
import com.example.orderfood.model.Food;
import com.example.orderfood.viewHolder.FoodViewHolder;
import com.example.orderfood.viewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private FirebaseDatabase mDatabase;
    private DatabaseReference foodList;
    private FirebaseRecyclerAdapter<Food, FoodViewHolder> adapter;
    private Query foodQuery;

    private String categoryId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        //FireBase
        mDatabase = FirebaseDatabase.getInstance();
        foodList = mDatabase.getReference("Foods");

        mRecyclerView = findViewById(R.id.recycler_food);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Get intent
        if (getIntent() != null) {
            categoryId = getIntent().getStringExtra("CategoryId");
        }
        if (!categoryId.isEmpty() && categoryId != null) {
            loadListFood(categoryId);
        }

    }

    private void loadListFood(String categoryId) {
        foodQuery = foodList.orderByChild("MenuId").equalTo(categoryId); //Select * from Foods where MenuId = categoryId
        FirebaseRecyclerOptions<Food> foodOptions = new FirebaseRecyclerOptions.Builder<Food>().setQuery(foodQuery, Food.class).build();
        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(foodOptions) {
            @NonNull
            @Override
            public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.food_item, parent, false);

                return new FoodViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FoodViewHolder holder, int position, @NonNull Food model) {
                holder.foodName.setText(model.getName());
                Picasso.get().load(model.getImage())
                        .into(holder.foodImage);

                final Food local = model;
                holder.setItemClickListner(new ItemClickListner() {
                    @Override
                    public void onClick(View view, int position, boolean islongClick) {
                       //Start new Activity
                        Intent foodDetail = new Intent(FoodList.this, FoodDetail.class);
                        foodDetail.putExtra("FoodId", adapter.getRef(position).getKey()); //Send FoodId to new activity
                        startActivity(foodDetail);
                    }
                });
            }
        };
        adapter.startListening();
        mRecyclerView.setAdapter(adapter);
    }
}