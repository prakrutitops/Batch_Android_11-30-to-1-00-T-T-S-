package com.example.tabexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);

        viewPager=findViewById(R.id.viewpager);
        setupviewpager();

        tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        floatingActionButton=findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Success",Snackbar.LENGTH_LONG).show();

            }
        });

    }

    private void setupviewpager()
    {
            MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager());
            myAdapter.addfragment(new ChatFragment(),"CHAT");
            myAdapter.addfragment(new StatusFragment(),"STATUS");
            myAdapter.addfragment(new CallFragment(),"CALL");
            viewPager.setAdapter(myAdapter);

    }
}