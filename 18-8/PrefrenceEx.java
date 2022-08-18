package com.example.prefrenceex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrefrenceEx extends AppCompatActivity {

    Button btn1,btn2;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefrence_ex);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(PrefrenceEx.this,MainActivity2.class);
                startActivity(i);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String a=sharedPreferences.getString("edt1","tops");
                String b=sharedPreferences.getString("edt2","tops");
                boolean c=sharedPreferences.getBoolean("chk1",false);
                String d=sharedPreferences.getString("list","tops");

                Toast.makeText(PrefrenceEx.this, ""+a+" "+b+" "+c+" "+d, Toast.LENGTH_SHORT).show();
            }
        });
        }
}