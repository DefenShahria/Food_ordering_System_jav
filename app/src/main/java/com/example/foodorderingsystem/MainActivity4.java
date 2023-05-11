package com.example.foodorderingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity4 extends AppCompatActivity {
    private CheckBox c1,c2,c3,c4,c5;
    private EditText i1,i2,i3,i4,i5;
    TextView textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        c1 = (CheckBox) findViewById(R.id.checkBox);
        c2 = (CheckBox) findViewById(R.id.checkBox2);
        c3 = (CheckBox) findViewById(R.id.checkBox3);
        c4 = (CheckBox) findViewById(R.id.checkBox4);
        c5 = (CheckBox) findViewById(R.id.checkBox5);

        i1 = (EditText) findViewById(R.id.i1);
        i2 = (EditText) findViewById(R.id.i2);
        i3 = (EditText) findViewById(R.id.i3);
        i4 = (EditText) findViewById(R.id.i4);
        i5 = (EditText) findViewById(R.id.i5);

        textView10=findViewById(R.id.textView10);

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinkedList<String> str = new LinkedList<String>();
                LinkedList<String> qn = new LinkedList<String>();
                LinkedList<String> pr = new LinkedList<String>();
                int v1 = 1, v2 =1  , v3 =1 , v4 = 1 , v5 =1 ;
                if(!i1.getText().toString().equals("")) {
                    v1 = Integer.parseInt(i1.getText().toString());
                }
                if(!i2.getText().toString().equals("")) {
                    v2 = Integer.parseInt(i2.getText().toString());
                }
                if(!i3.getText().toString().equals("")) {
                    v3 = Integer.parseInt(i3.getText().toString());
                }
                if(!i4.getText().toString().equals("")) {
                    v4 = Integer.parseInt(i4.getText().toString());
                }
                if(!i5.getText().toString().equals("")) {
                    v5 = Integer.parseInt(i5.getText().toString());
                }
                int sum = 0;
                if(c1.isChecked()){
                    sum+=(250*v1);
                    pr.add((250*v1)+"");
                    qn.add(v1+"");
                    str.add("Beef jucey burger  packege");
                }
                if(c2.isChecked()){
                    sum+=(100*v2);
                    pr.add((100*v2)+"");
                    qn.add(v2+"");
                    str.add("Chicken Regular Burger");
                }
                if(c3.isChecked()){
                    sum+=(130*v3);
                    pr.add((130*v3)+"");
                    qn.add(v3+"");
                    str.add("Chicken Cheesblast burger");
                }
                if(c4.isChecked()){
                    sum+=(250*v4);
                    pr.add((250*v4)+"");
                    qn.add(v4+"");
                    str.add("Beef Double petty burger");
                }
                if(c5.isChecked()){
                    sum+=(120*v5);
                    pr.add((120*v5)+"");
                    qn.add(v5+"");
                    str.add("Naga chicken Burger");
                }


                Intent intent = new Intent(MainActivity4.this,MainActivity5.class);
                intent.putExtra("tot",(sum+""));
                intent.putExtra("qn",qn);
                intent.putExtra("str",str);
                intent.putExtra("pr",pr);
                startActivity(intent);
            }
        });
    }
}