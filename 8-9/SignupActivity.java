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

public class SignupActivity extends AppCompatActivity
{
    EditText fname,lname,email,mobile,pass,cpass;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn1=findViewById(R.id.btnAlreadyAccount);
        btn2=findViewById(R.id.btnRegister);
        fname=findViewById(R.id.edtFirstName);
        lname=findViewById(R.id.edtLastName);
        email=findViewById(R.id.edtEmail);
        mobile=findViewById(R.id.edtPhone);
        pass=findViewById(R.id.edtPassword);
        cpass=findViewById(R.id.edtConfirmPassword);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fname1=fname.getText().toString();
                String lname1=lname.getText().toString();
                String email1=email.getText().toString();
                String mob=mobile.getText().toString();
                String pass1=pass.getText().toString();
                String cpass1=cpass.getText().toString();


                StringRequest stringRequest=new StringRequest(Request.Method.POST, MyUrl.REGISTER, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        Toast.makeText(SignupActivity.this, "Registration Done", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignupActivity.this,SigninActivity.class));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "No Internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap map =new HashMap();
                        map.put("firstname",fname1);
                        map.put("lastname",lname1);
                        map.put("mobile",mob);
                        map.put("email",email1);
                        map.put("password",pass1);
                        return map;
                    }
                };

                RequestQueue queue= Volley.newRequestQueue(SignupActivity.this);
                queue.add(stringRequest);



            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(SignupActivity.this,SigninActivity.class);
                startActivity(i);

            }
        });
    }
}