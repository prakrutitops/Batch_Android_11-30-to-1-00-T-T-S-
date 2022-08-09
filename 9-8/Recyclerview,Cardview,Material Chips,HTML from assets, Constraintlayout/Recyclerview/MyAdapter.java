package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview>
{
    Context context;
    List<Model> list;

    MyAdapter(Context context,List<Model> list)
    {
       this.context=context;
       this.list=list;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater in=LayoutInflater.from(context);
        View view=in.inflate(R.layout.design,parent,false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position)
    {
        holder.textView.setText(list.get(position).text);
        holder.imageView.setImageResource(list.get(position).image);
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class Myview extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;

        public Myview(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            textView=itemView.findViewById(R.id.txt);
        }
    }
}
