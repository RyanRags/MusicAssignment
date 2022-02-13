package com.example.musicassignment.model.rock


data class SongResponse(
    val results: List<Songs>
)

data class Songs(
    val artistName: String,
    val collectionName: String,
    val artworkUrl60: String,
    val trackPrice: Double,
    val previewUrl: String
)
