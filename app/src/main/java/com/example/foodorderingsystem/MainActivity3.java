package com.example.foodorderingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {
TextView textView6;
EditText editText5;
EditText editText4;

FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView6=findViewById(R.id.textView6);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        mAuth = FirebaseAuth.getInstance();

        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creatuser();
            }

            private void creatuser() {
              String email = editText5.getText().toString();
              String pass = editText4.getText().toString();

              if(TextUtils.isEmpty(email)){
                  editText5.setError("Email cannot be Empty");
              } else if (TextUtils.isEmpty(pass)) {
                  editText4.setError("Password cannot be Empty");
              }else{
                  mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()){
                              Toast.makeText(MainActivity3.this, "Register done ", Toast.LENGTH_SHORT).show();
                              Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                              startActivity(intent);
                          }else{
                              Toast.makeText(MainActivity3.this, "Register Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                          }
                      }
                  });
              }
            }
        });
    }
}