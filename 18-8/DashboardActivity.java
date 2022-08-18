package com.example.permissionex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity
{
    TextView textView;
    Button btn1;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textView=findViewById(R.id.txt1);
        btn1=findViewById(R.id.btn1);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);


        Toast.makeText(DashboardActivity.this, "Logged in as "+sharedPreferences.getString("e1","error"), Toast.LENGTH_SHORT).show();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    sharedPreferences.edit().clear().commit();

                    startActivity(new Intent(DashboardActivity.this,MainActivity.class));


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {

            case R.id.i1:

                String num="9999999999";
                Intent i =new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel: "+num));
                startActivity(i);


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}