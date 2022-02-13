package com.example.musicassignment.model.common

// https://itunes.apple.com/
//https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
//term =
//pop
//rock
const val END_POINT = "search"

var musicTypesUI = mutableListOf<String>("Rock" , "Classic", "Pop")
var musicTypesData = mutableListOf<String>("rock", "classick", "pop")

const val BASE_URL ="https://itunes.apple.com/"

const val TERM = "term"
const val AMP_MEDIA = "amp;media"
const val AMP_ENTITY = "&amp;entity"
const val AMP_LIMIT = "amp;limit"