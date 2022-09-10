package com.example.registerloginex.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registerloginex.Model.Dashboard_Model;
import com.example.registerloginex.R;

import java.util.List;

public class Dashboard_Adapter extends RecyclerView.Adapter<Dashboard_Adapter.MyView>
{
        Context context;
        List<Dashboard_Model>list;

        public Dashboard_Adapter(Context context, List<Dashboard_Model> list)
        {
            this.context=context;
            this.list=list;
        }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater in=LayoutInflater.from(context);
        View view=in.inflate(R.layout.design_dashboard,parent,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position)
    {
        holder.txtname.setText(list.get(position).getProduct_name());
        holder.txtprice.setText(list.get(position).getProdcut_price());
        holder.txtdes.setText(list.get(position).getProduct_description());
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
    class MyView extends RecyclerView.ViewHolder
    {
        TextView txtname,txtprice,txtdes;

        public MyView(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.txt1);
            txtprice=itemView.findViewById(R.id.txt2);
            txtdes=itemView.findViewById(R.id.txt3);
        }
    }
}
