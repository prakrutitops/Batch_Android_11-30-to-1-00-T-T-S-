package com.example.e_greetingsheet

import com.example.e_greetingsheet.Interface.Apiinterface
import com.example.e_greetingsheet.Model.CategoryModel
import com.example.e_greetingsheet.databinding.ActivityCategoryBinding



import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetingsheet.Adapter.CategoryAdapter
import com.example.e_greetingsheet.Client.ApiClient

import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class CategoryActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityCategoryBinding
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<CategoryModel>
    lateinit var apiinterface: Apiinterface
    var call: Call<List<CategoryModel?>?>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        recyclerView = findViewById(R.id.recycler)
        list = ArrayList<CategoryModel>()

        var i=intent
        var pos= i.getIntExtra("pos",100)

        // Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()

        val rl: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = rl
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        if(pos==0)
        {
            call = apiinterface!!.diwalidata
        }
        if(pos==1)
        {
            call = apiinterface!!.holidata
        }





        call!!.enqueue(object : Call<List<CategoryModel?>>, Callback<List<CategoryModel?>?> {
            /*  override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {

              }

              override fun onFailure(call: Call<List<Model?>>, t: Throwable) {}*/
            override fun onResponse(call: Call<List<CategoryModel?>?>, response: Response<List<CategoryModel?>?>) {
                list = response.body() as MutableList<CategoryModel>
                val customAdapter = CategoryAdapter(applicationContext, list!!)
                recyclerView.adapter = customAdapter
            }

            override fun onFailure(call: Call<List<CategoryModel?>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            }

            override fun clone(): Call<List<CategoryModel?>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<CategoryModel?>> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<CategoryModel?>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }


        })

    }
}