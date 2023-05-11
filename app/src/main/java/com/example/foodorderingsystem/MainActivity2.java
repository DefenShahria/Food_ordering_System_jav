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

public class MainActivity2 extends AppCompatActivity {
TextView textView5;
TextView textView3;
FirebaseAuth mAuth;
EditText editTextTextPersonName3;
EditText editTextTextPersonName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView3=findViewById(R.id.textView3);
        textView5=findViewById(R.id.textView5);
        editTextTextPersonName=findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName3=findViewById(R.id.editTextTextPersonName3);
        mAuth = FirebaseAuth.getInstance();


        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }

            private void login() {
                String email = editTextTextPersonName3.getText().toString();
                String pass = editTextTextPersonName.getText().toString();

                if(TextUtils.isEmpty(email)){
                    editTextTextPersonName3.setError("Email cannot be Empty");
                } else if (TextUtils.isEmpty(pass)) {
                    editTextTextPersonName.setError("Password cannot be Empty");
                } else if (email.equals("admin")&& pass.equals("admin")){
                    startActivity(new Intent(MainActivity2.this,MainActivity6.class));
                } else {
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(MainActivity2.this, "Sign in done", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity2.this, "Sign in Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}