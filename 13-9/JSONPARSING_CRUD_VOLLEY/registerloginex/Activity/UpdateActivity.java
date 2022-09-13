package com.example.registerloginex.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.registerloginex.Other.MyUrl;
import com.example.registerloginex.R;
import com.example.registerloginex.databinding.ActivityDashBoardBinding;
import com.example.registerloginex.databinding.ActivityUpdateBinding;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {

    private ActivityUpdateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent i =getIntent();
       String id = i.getStringExtra("product_id");
       String name = i.getStringExtra("product_name");
       String price =  i.getStringExtra("product_price");
       String des = i.getStringExtra("product_description");

        binding.edtproductname.setText(name);
        binding.edtproductprice.setText(price);
        binding.edtproductdescription.setText(des);

        binding.btnaddproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=binding.edtproductname.getText().toString();
                String price=binding.edtproductprice.getText().toString();
                String des=binding.edtproductdescription.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.UPDATEPRODUCT, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(UpdateActivity.this,DashBoardActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(UpdateActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        HashMap map=new HashMap();
                        map.put("product_id",id);
                        map.put("product_name",name);
                        map.put("product_price",price);
                        map.put("product_description",des);
                        return map;
                    }
                };

                RequestQueue queue= Volley.newRequestQueue(UpdateActivity.this);
                queue.add(stringRequest);




            }
        });




    }
}