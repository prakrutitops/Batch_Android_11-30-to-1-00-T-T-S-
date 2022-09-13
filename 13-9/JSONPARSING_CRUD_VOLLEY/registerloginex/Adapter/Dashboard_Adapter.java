package com.example.registerloginex.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.registerloginex.Activity.DashBoardActivity;
import com.example.registerloginex.Activity.UpdateActivity;
import com.example.registerloginex.Model.Dashboard_Model;
import com.example.registerloginex.Other.MyUrl;
import com.example.registerloginex.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void onBindViewHolder(@NonNull MyView holder, @SuppressLint("RecyclerView") int position)
    {
        holder.txtname.setText(list.get(position).getProduct_name());
        holder.txtprice.setText(list.get(position).getProdcut_price());
        holder.txtdes.setText(list.get(position).getProduct_description());

        holder.txtname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Select Operations?");
                alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Intent i1 =new Intent(context, UpdateActivity.class);
                        i1.putExtra("product_id",list.get(position).getProduct_id());
                        i1.putExtra("product_name",list.get(position).getProduct_name());
                        i1.putExtra("product_price",list.get(position).getProdcut_price());
                        i1.putExtra("product_description",list.get(position).getProduct_description());
                        context.startActivity(i1);


                    }
                });
                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        String id=list.get(position).getProduct_id();

                        StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.DELETEPRODUCT, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response)
                            {

                                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();

                                context.startActivity(new Intent(context, DashBoardActivity.class));
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(context, "No Internet", Toast.LENGTH_SHORT).show();

                            }
                        })
                        {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError
                            {
                                HashMap map=new HashMap();
                                map.put("product_id",id);
                                return map;
                            }
                        };
                        RequestQueue queue= Volley.newRequestQueue(context);
                        queue.add(stringRequest);


                    }
                });
                alert.show();



            }
        });

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
