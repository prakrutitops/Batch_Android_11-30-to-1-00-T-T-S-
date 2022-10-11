package com.example.heetprojectfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    FloatingActionButton f1;
    RecyclerView recyclerView;
    List<Model> list;
    myadapter myAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reycler);
        list = new ArrayList<>();

        RecyclerView.LayoutManager rl =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rl);

        FirebaseRecyclerOptions<Model> options=new FirebaseRecyclerOptions.Builder<Model>()
                .setQuery( FirebaseDatabase.getInstance().getReference().child("t1"),Model.class)
                .build();

        myAdapter1=new myadapter(options);
        recyclerView.setAdapter(myAdapter1);

        f1 = findViewById(R.id.f1);

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainActivity.this,AdduserActivity.class));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        myAdapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        myAdapter1.stopListening();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        myAdapter1.startListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        myAdapter1.startListening();
    }

    @Override
    protected void onPause() {
        super.onPause();
        myAdapter1.stopListening();
    }
}