package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity5 extends AppCompatActivity {
    TextView textView9;
    TextView dis;
    static int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        textView9=findViewById(R.id.textView9);
        dis=findViewById(R.id.dis);


        String total ="";

        ArrayList<String> str = getIntent().getStringArrayListExtra("str");
        ArrayList<String> qn = getIntent().getStringArrayListExtra("qn");
        ArrayList<String> pr = getIntent().getStringArrayListExtra("pr");

        for (int i = 0; i < str.size() ; i++) {

            total+=((i+1)+". ")+(str.get(i))+"-"+(qn.get(i))+"-"+(pr.get(i));
            total+="\n";
        }
        total+="Total Amount     =     "+(getIntent().getStringExtra("tot").toString());
        dis.setText(total);


        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s ="Total Amount     =     "+(getIntent().getStringExtra("tot").toString());
                HashMap<String,Object> hm =new HashMap<String,Object>();
                hm.put(s,s);
                FirebaseDatabase.getInstance().getReference().child("Database").updateChildren(hm);
                count++;
                Toast.makeText(MainActivity5.this, "Order Confirm", Toast.LENGTH_LONG).show();
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                for(String str : str) {
                    rootRef.child("Item").child(str).setValue(str);
                }
                for(String qn : qn) {
                    rootRef.child("Quantity").child(qn).setValue(qn);
                }

                Intent intent=new Intent(MainActivity5.this,MainActivity7.class);
                startActivity(intent);
            }
        });










    }
}