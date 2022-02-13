package com.example.musicassignment.model.common

import android.util.Log
import com.example.musicassignment.view.MusicView
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val TAG = "Network"
object Network {

    val songsApi: SongsApi by lazy {
        initRetrofit().create(SongsApi::class.java)
    }

    //If not getting the right data try RXJava from the
    // new project
    private fun initRetrofit(): Retrofit {
        Log.d(TAG, "initRetrofit: ")
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}