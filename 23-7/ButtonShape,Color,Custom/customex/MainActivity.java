package com.example.customex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater in=LayoutInflater.from(getApplicationContext());
                View view1=in.inflate(R.layout.design_toast,null);

                Toast toast =new Toast(MainActivity.this);
                toast.setView(view1);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater in=LayoutInflater.from(getApplicationContext());
                View view1=in.inflate(R.layout.design_dialog,null);


                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setView(view1);
                Button btn1=view1.findViewById(R.id.btn1);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Toast.makeText(MainActivity.this, "abcd", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();


            }
        });

    }
}