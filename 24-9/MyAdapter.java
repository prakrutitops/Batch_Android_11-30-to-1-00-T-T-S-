package com.example.retrofitex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview>
{
    Context context;
    List<Model> dataList;
    Apiinterface api;

    public MyAdapter(Context context, List<Model> dataList)
    {
        this.context=context;
        this.dataList = dataList;
    }

    @Override
    public Myview onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(Myview holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(dataList.get(position).getProduct_name());
        holder.t2.setText(dataList.get(position).getProduct_price());
        holder.t3.setText(dataList.get(position).getProduct_description());

    }







    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Myview extends RecyclerView.ViewHolder {
        TextView t1, t2,t3;

        public Myview(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            t3=itemView.findViewById(R.id.txt3);

        }
    }
}