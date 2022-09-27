package com.example.retrofitex;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText edt1,edt2,edt3;
    Button btn1,btn2;
    Apiinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt1.getText().toString();
                String price =edt2.getText().toString();
                String des =edt3.getText().toString();

                apiinterface =ApiClient.getapiclient().create(Apiinterface.class);
                Call<Void> call = apiinterface.productadd(name,price,des);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        Toast.makeText(MainActivity.this, "Product added", Toast.LENGTH_SHORT).show();
                        Intent i =new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);

            }
        });

    }
}