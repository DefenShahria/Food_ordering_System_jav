package com.example.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity7 extends AppCompatActivity {
    ListView listView2;
    ListView listView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        listView2=findViewById(R.id.listview2);
        listView3=findViewById(R.id.listview3);


        ArrayList<String> al = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.listitem,al);
        listView2.setAdapter(adapter);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Status");
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
        listView3.setAdapter(adapter2);
        DatabaseReference databaseReference2 = FirebaseDatabase.getInstance().getReference().child("Time");
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
    }
}