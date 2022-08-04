package com.example.myapplication.ui.Android;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Model;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AndroidFragment extends Fragment {


    ListView listView;
    List<Model>list;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_android2, container, false);

        listView=view.findViewById(R.id.list);
        list=new ArrayList<>();

        list.add(new Model("Intent",R.drawable.a1));
        list.add(new Model("Fragment",R.drawable.a1));
        list.add(new Model("AlertDialog",R.drawable.a1));


        MyAdapter myAdapter=new MyAdapter(getActivity(),list);
        listView.setAdapter(myAdapter);


        return view;
    }
}