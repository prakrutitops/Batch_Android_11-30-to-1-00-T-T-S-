package com.example.retrofitex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiinterface
{
   @FormUrlEncoded
   @POST("productinsert.php")
   Call<Void>productadd(
           @Field("product_name")  String prodct_name,
           @Field("product_price") String product_price,
           @Field("product_description") String product_description
   );

   @GET("productview.php")
   Call<List<Model>> productview();


}
