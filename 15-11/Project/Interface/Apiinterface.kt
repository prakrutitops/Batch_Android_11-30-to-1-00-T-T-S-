package com.example.e_greetingsheet.Interface

import com.example.e_greetingsheet.Model.CategoryModel
import com.example.e_greetingsheet.Model.Dashboard_Model
import com.example.e_greetingsheet.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{

    @FormUrlEncoded
    @POST("registration.php")
    fun registerdetail(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("phone") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun logindata(  @Field("phone") mobile: String?,  @Field("pass") password: String?):Call<RegisterModel>

    @get:GET("dashboard_view.php")
    val dashboardviewdata: Call<List<Dashboard_Model?>?>?

    @get:GET("diwali_view.php")
    val diwalidata: Call<List<CategoryModel?>?>?

    @get:GET("holi_view.php")
    val holidata: Call<List<CategoryModel?>?>?

}