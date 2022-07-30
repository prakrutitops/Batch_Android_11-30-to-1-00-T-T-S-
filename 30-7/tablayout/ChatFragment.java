package com.example.tabexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ChatFragment extends Fragment {

    ListView listView;
    List<Model> list;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_chat, container, false);

        listView=view.findViewById(R.id.list);
        list=new ArrayList<>();

        list.add(new Model("Heet","Hello","1:23",R.drawable.p2));
        list.add(new Model("Heet","Hello","1:23",R.drawable.p2));
        list.add(new Model("Heet","Hello","1:23",R.drawable.p2));
        list.add(new Model("Heet","Hello","1:23",R.drawable.p2));

            MyAdapter2 myAdapter2=new MyAdapter2(getActivity(),list);
            listView.setAdapter(myAdapter2);

        return view;

    }
}