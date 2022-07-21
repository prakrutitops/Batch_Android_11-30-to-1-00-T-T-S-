package com.example.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextMenuActivity extends AppCompatActivity {

    ListView listView;
    List<String>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();

        list.add("Android");
        list.add("Java");
        list.add("Php");
        list.add("Ios");

        ArrayAdapter arrayAdapter=new ArrayAdapter(ContextMenuActivity.this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id=acm.position;

       switch (item.getItemId())
       {
           case R.id.pos:
               Toast.makeText(ContextMenuActivity.this, "Position Called "+id, Toast.LENGTH_SHORT).show();
               break;
       }

        return super.onContextItemSelected(item);
    }
}