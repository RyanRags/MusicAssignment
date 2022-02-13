package com.example.musicassignment.model.common

import com.example.musicassignment.model.rock.SongResponse
import com.example.musicassignment.model.rock.Songs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsApi {

    @GET(END_POINT)
    fun getSongInformation(
        @Query(TERM) term: String,
        @Query(AMP_MEDIA) media: String = "music",
        @Query(AMP_ENTITY) entity: String = "song",
        @Query(AMP_LIMIT) limit: Int = 50
    )
    :Call<SongResponse>

}