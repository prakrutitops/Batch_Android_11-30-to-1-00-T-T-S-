package com.example.toolbarex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity
{
    ListView listView;
    List<Model>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();

        list.add(new Model(R.drawable.p1,"Pizza 1","150"));
        list.add(new Model(R.drawable.p2,"Pizza 2","250"));
        list.add(new Model(R.drawable.p3,"Pizza 3","350"));
        list.add(new Model(R.drawable.p1,"Pizza 1","150"));
        list.add(new Model(R.drawable.p2,"Pizza 2","250"));
        list.add(new Model(R.drawable.p3,"Pizza 3","350"));
        list.add(new Model(R.drawable.p1,"Pizza 1","150"));
        list.add(new Model(R.drawable.p2,"Pizza 2","250"));
        list.add(new Model(R.drawable.p3,"Pizza 3","350"));
        list.add(new Model(R.drawable.p1,"Pizza 1","150"));
        list.add(new Model(R.drawable.p2,"Pizza 2","250"));
        list.add(new Model(R.drawable.p3,"Pizza 3","350"));

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
        listView.setAdapter(myAdapter);
    }
}