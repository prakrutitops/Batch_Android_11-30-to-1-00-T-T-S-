package com.example.e_greetingsheet.Interface

import com.example.e_greetingsheet.Model.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
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
    fun logindata(  @Field("phone") mobile: String?,  @Field("pass") password: String?):Call<Void>


}