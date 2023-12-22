package com.bignerdranch.android.tortuganews.api

import com.bignerdranch.android.tortuganews.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            //this is initialized once (by lazy)
            val logging = HttpLoggingInterceptor() //loggin responses of retrofit
            //we are attaching this to our retrofit object to be able to see which requests we are making
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()//network client - program that requests the activity of one or more other systems or programs, called servers, to accomplish the task
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//determines how the response should be interpreted and converted to Kotlin objects
                .client(client)
                .build()
        }
        val api by lazy { // this is the api object we are going to use later everywhere to make external network requests
            retrofit.create(NewsAPI::class.java)
        }
    }
}