package com.example.fooddeliveryapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodViewHolder extends RecyclerView.ViewHolder {
    View v;




    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        v=itemView;


    }
    public void set(Context context, String imageName, String imageurl, String imagePrice){
        TextView txt1=v.findViewById(R.id.textView1);
        TextView txt2=v.findViewById(R.id.textView2);
        CircleImageView image=v.findViewById(R.id.imageView);
        txt1.setText(imageName);
        txt2.setText(imagePrice);
        Picasso.get().load(imageurl).into(image);
    }


}


