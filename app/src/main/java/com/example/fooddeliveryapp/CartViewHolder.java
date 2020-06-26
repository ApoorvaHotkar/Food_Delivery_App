package com.example.fooddeliveryapp;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CartViewHolder extends RecyclerView.ViewHolder {
    View v;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        v=itemView;
    }
    public void set(Context context, String imageName, String imageurl, String imagePrice,String Quantity){
        TextView txt1=v.findViewById(R.id.name);
        TextView txt2=v.findViewById(R.id.price);
        TextView txt3=v.findViewById(R.id.quantity);
        CircleImageView image=v.findViewById(R.id.imageView2);
        txt1.setText(imageName);
        txt2.setText(imagePrice);
        txt3.setText("Quantity: "+Quantity);
        Picasso.get().load(imageurl).into(image);
    }
}
