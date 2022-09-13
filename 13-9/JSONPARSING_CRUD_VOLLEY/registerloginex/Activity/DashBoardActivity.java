package com.example.registerloginex.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.registerloginex.Adapter.Dashboard_Adapter;
import com.example.registerloginex.Model.Dashboard_Model;
import com.example.registerloginex.Other.MyUrl;
import com.example.registerloginex.R;
import com.example.registerloginex.databinding.ActivityDashBoardBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoardActivity extends AppCompatActivity {

    private ActivityDashBoardBinding binding;
    SharedPreferences sharedPreferences;
    List<Dashboard_Model>list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityDashBoardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);
        list=new ArrayList<>();
       // Toast.makeText(DashBoardActivity.this, "Logged in as a "+sharedPreferences.getString("mob","Null"), Toast.LENGTH_SHORT).show();

        RecyclerView.LayoutManager rl =new LinearLayoutManager(this);
        binding.recycler.setLayoutManager(rl);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.VIEWPRODUCTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {

                try
                {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        String id=jsonObject.getString("product_id");
                        String name=jsonObject.getString("product_name");
                        String price=jsonObject.getString("product_price");
                        String des=jsonObject.getString("product_description");

                        Dashboard_Model model =new Dashboard_Model();
                        model.setProduct_id(id);
                        model.setProduct_name(name);
                        model.setProdcut_price(price);
                        model.setProduct_description(des);
                        list.add(model);


                        Dashboard_Adapter dashboard_adapter=new Dashboard_Adapter(DashBoardActivity.this,list);
                        binding.recycler.setAdapter(dashboard_adapter);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(DashBoardActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue= Volley.newRequestQueue(DashBoardActivity.this);
        queue.add(stringRequest);



    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu)
    {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {

            case R.id.adddetail:

                AlertDialog.Builder alert =new AlertDialog.Builder(DashBoardActivity.this);
                LayoutInflater in=LayoutInflater.from(DashBoardActivity.this);
                View view=in.inflate(R.layout.dashboard_form,null);
                alert.setView(view);

                EditText edtname=view.findViewById(R.id.edtproductname);
                EditText edtprice=view.findViewById(R.id.edtproductprice);
                EditText edtdes=view.findViewById(R.id.edtproductdescription);
                Button button=view.findViewById(R.id.btnaddproduct);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String pname=edtname.getText().toString();
                        String pprice=edtprice.getText().toString();
                        String pdes=edtdes.getText().toString();

                        StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.ADDPRODUCTS, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response)
                            {
                                Toast.makeText(DashBoardActivity.this, "Prodcut Added Succesfully"+response.toString(), Toast.LENGTH_SHORT).show();
                               //Log.d("TopsTech",response.toString());
                                startActivity(new Intent(DashBoardActivity.this,DashBoardActivity.class));
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                Toast.makeText(DashBoardActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                            }
                        })
                        {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {

                                HashMap map=new HashMap();

                                map.put("product_name",pname);
                                map.put("product_price",pprice);
                                map.put("product_description",pdes);

                                return map;

                            }
                        };
                        RequestQueue queue= Volley.newRequestQueue(DashBoardActivity.this);
                        queue.add(stringRequest);

                    }
                });

                alert.show();

                break;

            case R.id.logout:
                sharedPreferences.edit().clear().commit();
                startActivity(new Intent(DashBoardActivity.this,SigninActivity.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}