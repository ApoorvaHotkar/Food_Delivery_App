package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Cart_Activity extends AppCompatActivity {
    Button btn3,btn4;
    private DatabaseReference databaseReference,dbrdelete;
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<CartModelClass,CartViewHolder>recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_);
        btn3=(Button)findViewById(R.id.buttonplaceorder);
        btn4=(Button)findViewById(R.id.buttonclearcart);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView2);
        dbrdelete=FirebaseDatabase.getInstance().getReference("CartList");
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbrdelete.removeValue();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cart_Activity.this,MainActivity.class);
                Toast.makeText(getApplicationContext(),"Order Placed!!",Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("CartList");
        databaseReference.keepSynced(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Query query=databaseReference.orderByKey();
        FirebaseRecyclerOptions options=new FirebaseRecyclerOptions.Builder<CartModelClass>().setQuery(query,CartModelClass.class).build();
        recyclerAdapter=new FirebaseRecyclerAdapter<CartModelClass, CartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CartViewHolder holder, int position, @NonNull CartModelClass model) {

                holder.set(getApplicationContext(),model.getImageName(),model.getImageurl(),model.getImagePrice(),model.getQuantity());
            }

            @NonNull
            @Override
            public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list,parent,false);
                return new CartViewHolder(v);
            }
        };
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.startListening();

        }

    }

