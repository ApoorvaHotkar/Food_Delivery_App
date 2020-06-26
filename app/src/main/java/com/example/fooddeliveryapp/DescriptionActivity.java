package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {
    private String receivename;
    private String receiveprice;
    private String receiveimageurl;
    private String Quantity;
    TextView txt1,txt2;
    EditText ed1;
    CircleImageView img;
    Button btn,btn2;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        receivename=getIntent().getExtras().get("name").toString();
        receiveprice=getIntent().getExtras().get("Price").toString();
        receiveimageurl=getIntent().getExtras().get("image").toString();
        txt1=(TextView)findViewById(R.id.textViewname);
        txt2=(TextView)findViewById(R.id.textViewPrice);
        ed1=(EditText)findViewById(R.id.editText);
        img=(CircleImageView) findViewById(R.id.imageView2);
        btn=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.btn2);
        databaseReference= FirebaseDatabase.getInstance().getReference("CartList");
        txt1.setText(receivename);
        txt2.setText(receiveprice);
        Picasso.get().load(receiveimageurl).into(img);
        Quantity=ed1.getText().toString();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txt1.getText().toString();
                String price=txt2.getText().toString();
                String quantity=ed1.getText().toString();
                String imageurl=receiveimageurl;
                FoodModel foodModel=new FoodModel(name,price,imageurl);
                databaseReference.child(name).setValue(foodModel);
                databaseReference.child(name).child("Quantity").setValue(quantity);
                Toast.makeText(getApplicationContext(),"Added To Cart!!!",Toast.LENGTH_LONG).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DescriptionActivity.this,Cart_Activity.class);
                startActivity(intent);

            }
        });



    }
}
