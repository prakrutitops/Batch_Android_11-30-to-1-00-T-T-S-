package com.example.registerloginex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SigninActivity extends AppCompatActivity {

    Button btn1;
    EditText edt1,edt2;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btn1=findViewById(R.id.signup);
        edt1=findViewById(R.id.edtPhone);
        edt2=findViewById(R.id.edtPassword);
        btnlogin=findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String mob = edt1.getText().toString();
                String pass=edt2.getText().toString();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.LOGIN, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(SigninActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(SigninActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SigninActivity.this, "No Internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap map=new HashMap();
                        map.put("mobile",mob);
                        map.put("password",pass);
                        return map;

                    }
                };

                RequestQueue queue= Volley.newRequestQueue(SigninActivity.this);
                queue.add(stringRequest);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(SigninActivity.this,SignupActivity.class);
                startActivity(i);

            }
        });
    }
}