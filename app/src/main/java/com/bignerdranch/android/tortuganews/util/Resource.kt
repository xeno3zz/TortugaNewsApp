package com.bignerdranch.android.tortuganews.util

sealed class Resource<T>( //sealed is like an abstract class but we can define which classes are allowed to inherit
    //
    val data: T? = null,
    val message: String? = null
) { //generic type T
    //class used to wrap network responses
    //generic class useful to differentiate between successful and error responses
    //helps handling the loading states  (progress bar for the response)
    class Success<T>(data: T) : Resource<T>(data) //not nullable because if success we are sure to have data
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message) //this time message is not nullable because we are sure to have a message if we got an error
    class Loading<T> : Resource<T>()
}