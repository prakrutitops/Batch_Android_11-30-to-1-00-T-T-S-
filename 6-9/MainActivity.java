package com.example.jsonparsingex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    List<Model>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        list=new ArrayList<>();

        StringRequest stringRequest =new StringRequest(Request.Method.POST, "https://heetnanda.000webhostapp.com/API/productview.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                        String name=jsonObject.getString("product_name");
                        String price=jsonObject.getString("product_price");
                        String image=jsonObject.getString("product_image");


                        Model m =new Model();
                        m.setName(name);
                        m.setPrice(price);
                        m.setImage(image);

                        list.add(m);
                    }

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
                listView.setAdapter(myAdapter);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
}