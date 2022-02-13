package com.example.musicassignment.viewmodel

import com.example.musicassignment.model.rock.SongResponse
import com.example.musicassignment.view.MusicView

interface IPresenterMusic {
    fun bind(view: MusicView)
    fun unbind()
    fun getSongInfo(song: String)
}