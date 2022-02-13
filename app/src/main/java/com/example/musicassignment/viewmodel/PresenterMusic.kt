package com.example.musicassignment.viewmodel

import android.util.Log
import com.example.musicassignment.model.common.Network
import com.example.musicassignment.model.common.TERM
import com.example.musicassignment.model.rock.SongResponse
import com.example.musicassignment.model.rock.Songs
import com.example.musicassignment.view.MusicView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.NullPointerException

private const val TAG = "PresenterMusic"
class PresenterMusic: IPresenterMusic {

    private var _view: MusicView? = null
    private val view: MusicView
    get() = _view?: throw NullPointerException()

    override fun bind(view: MusicView) {
        _view = view
    }

    override fun unbind() {
        _view = null
    }

    override fun getSongInfo(song: String){
        Log.d(TAG, "getSongInfo: $song")
        Network.songsApi.getSongInformation(song).enqueue(
            object: Callback<SongResponse>{
                override fun onResponse(call: Call<SongResponse>, response: Response<SongResponse>) {
        Log.d(TAG, "getSongInfo: ${response.raw().request().url()}")
                    if(response.isSuccessful)
                        response.body()?.let {
                            view.displayData(it)
                            Log.d(TAG, "onResponse: $response")
                        }
                    Log.d(TAG, "onResponse:1 $response")
                }

                override fun onFailure(call: Call<SongResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}