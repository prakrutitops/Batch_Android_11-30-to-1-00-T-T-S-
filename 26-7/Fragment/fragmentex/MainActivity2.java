package com.example.fragmentex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentex.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);



    }

    @Override
    public void onClick(View view)
    {
        if(view==binding.btn1)
        {
           startActivity(new Intent(MainActivity2.this,MainActivity3.class));
        }

        if(view==binding.btn2)
        {
            BlankFragment b1 =new BlankFragment();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.frmid,b1).commit();
        }

        if(view==binding.btn3)
        {

        }

        if(view==binding.btn4)
        {

        }
    }
}