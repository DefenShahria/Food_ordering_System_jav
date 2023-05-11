package com.example.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
ListView listView;
ListView listqn;
TextView textView15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        listView=findViewById(R.id.listview);
        listqn=findViewById(R.id.listqn);
        textView15=findViewById(R.id.textView15);



        ArrayList<String> al = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listitem,al);
        listView.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Item");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Datasnapshot) {
                al.clear();
                for(DataSnapshot dataSnapshot : Datasnapshot.getChildren()){
                    String ok = dataSnapshot.getValue().toString();
                    al.add(ok);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        ArrayList<String> qn = new ArrayList<>();
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this,R.layout.listitem,qn);
        listqn.setAdapter(adapter2);
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Quantity");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Datasnapshot) {
                qn.clear();
                for(DataSnapshot dataSnapshot : Datasnapshot.getChildren()){
                    String ok = dataSnapshot.getValue().toString();
                    qn.add(ok);
                }
                adapter2.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        textView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity6.this,MainActivity8.class);
                startActivity(intent);
            }
        });
    }
}