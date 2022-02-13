package com.example.musicassignment.view

import com.example.musicassignment.model.rock.SongResponse
import com.example.musicassignment.model.rock.Songs

interface MusicView {
    fun requestData()
    fun displayData(songs: SongResponse)
    fun initViews(data: SongResponse)
}