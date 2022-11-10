package com.example.e_greetingsheet.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        var url = "https://vyasprakruti.000webhostapp.com/E-Greetings%20Project/"
        fun getapiclient(): Retrofit {
            var retrofit: Retrofit? = null

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit!!
        }

    }
}

