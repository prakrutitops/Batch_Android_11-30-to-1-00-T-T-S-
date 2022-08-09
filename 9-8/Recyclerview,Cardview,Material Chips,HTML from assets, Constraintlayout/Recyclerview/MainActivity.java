package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<Model>list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        list=new ArrayList<>();

        RecyclerView.LayoutManager rl =new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(rl);

        list.add(new Model("SAMSUNG",R.drawable.sam));
        list.add(new Model("SAMSUNG",R.drawable.sam));
        list.add(new Model("SAMSUNG",R.drawable.sam));
        list.add(new Model("SAMSUNG",R.drawable.sam));

       MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
       recyclerView.setAdapter(myAdapter);



    }
}