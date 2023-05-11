package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity8 extends AppCompatActivity {

    EditText editTextTextPersonName4;
    EditText editTextTextPersonName5;
    Button buttonadd;
    Button buttonadd2;
    static int count;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        buttonadd=findViewById(R.id.buttonadd);
        buttonadd2=findViewById(R.id.buttonadd2);
        editTextTextPersonName4=findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName5=findViewById(R.id.editTextTextPersonName5);



        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = editTextTextPersonName4.getText().toString().trim();
                HashMap<String,Object> hm =new HashMap<String,Object>();
                hm.put(t,t);
                FirebaseDatabase.getInstance().getReference().child("Time").updateChildren(hm);
                count++;
                Toast.makeText(MainActivity8.this, "Done", Toast.LENGTH_LONG).show();
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            }
        });
        buttonadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st = editTextTextPersonName5.getText().toString().trim();
                HashMap<String,Object> hm =new HashMap<String,Object>();
                hm.put(st,st);
                FirebaseDatabase.getInstance().getReference().child("Status").updateChildren(hm);
                count++;
                Toast.makeText(MainActivity8.this, "Done", Toast.LENGTH_LONG).show();
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
            }
        });
    }
}