package com.example.permissionex;

import static android.Manifest.permission.CALL_PHONE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText edt1,edt2;
    Button btn1;
    SharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);


        if(!(checkSelfPermission(CALL_PHONE) == PackageManager.PERMISSION_GRANTED))
        {
            requestPermissions(new String[]{CALL_PHONE},101);
        }

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("e1", "").isEmpty())
        {
            startActivity(new Intent(MainActivity.this,DashboardActivity.class));
            finish();
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=edt1.getText().toString();
                String pass=edt2.getText().toString();

                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("e1",email);
                editor.putString("p1",pass);
                editor.putBoolean("user_session",true);
                editor.commit();

                startActivity(new Intent(MainActivity.this,DashboardActivity.class));

            }
        });
    }
}