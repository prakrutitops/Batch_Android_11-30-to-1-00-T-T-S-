package com.example.jsonparsingex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter
{
    Context context;
    List<Model>list;

    MyAdapter( Context context,List<Model>list)
    {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        LayoutInflater in =LayoutInflater.from(context);
        view=in.inflate(R.layout.design,viewGroup,false);

        TextView txt1 =view.findViewById(R.id.txt1);
        TextView txt2=view.findViewById(R.id.txt2);
        TextView txt3=view.findViewById(R.id.txt3);
        ImageView img=view.findViewById(R.id.img);

        txt1.setText(list.get(i).name);
        txt2.setText(list.get(i).realname);
        txt3.setText(list.get(i).team);
        Picasso.get().load(list.get(i).getImage()).placeholder(R.mipmap.ic_launcher)/*.resize(250,250)*/.into(img);

        return view;
    }
}
